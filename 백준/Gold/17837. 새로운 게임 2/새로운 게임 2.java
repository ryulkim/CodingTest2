import java.io.*;
import java.util.*;

public class Main {
	
	static class Node {
		public int dir, r, c, num;
		public Node up;
		public Node(int num, int r, int c, int dir) {
			super();
			this.num = num;
			this.dir = dir;
			this.r = r;
			this.c = c;
		}
		
		public Main.Node reverse() {
			Node cur=this;
	    	Node down=null;
	    	
	    	while(cur!=null) {
	    		Node up=cur.up;
	    		cur.up=down;
	    		down=cur;
	    		cur=up;
	    	}
	    	
	    	return down;
		}
		
		public void changeUpsRC(int r, int c) {
			Node cur=this;
    		while(cur!=null) {
        		cur.r=r;
        		cur.c=c;
        		cur=cur.up;
        	}
		}
		
		public int upSize() {
			Node cur=this;
			int cnt=0;
			while(cur!=null) {
				cur=cur.up;
				cnt++;
			}
			return cnt;
		}
		
		public Main.Node getCeiling(){
			Node cur=this;
			Node down=this;
			while(cur!=null) {
				down=cur;
				cur=cur.up;
			}
			return down;
		}
	}
	
	static int N, K;
	static int[][] arr;
	static Node[][] horse;
	static Node[] nodes;
	static int[] dr= {0,0,-1,1};
	static int[] dc= {1,-1,0,0};
	
    public static void main(String[] args) throws IOException {
    	init();
    	System.out.println(proc());
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	K=Integer.parseInt(st.nextToken());
    	arr=new int[N][N];
    	nodes=new Node[K];
    	horse=new Node[N][N];
    	
    	for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    	
    	for (int i = 0; i < K; i++) {
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken())-1;
			int c=Integer.parseInt(st.nextToken())-1;
			int dir=Integer.parseInt(st.nextToken())-1;
			
			nodes[i]=new Main.Node(i,r,c,dir);
			horse[r][c]=nodes[i];
		}
    }
    
    public static int proc() {
    	for (int i = 1; i <= 1000; i++) {
    		for (int j = 0; j < K; j++) {
    			if(!move(nodes[j])) {
    				return i;
    			}
			}
		}
    	return -1;
    }
    
    private static boolean move(Node node) {
    	if(horse[node.r][node.c]==node) { // 내가 맨 아래일 경우
    		horse[node.r][node.c]=null;
    	}
    	else { 
    		Node cur=horse[node.r][node.c];
    		Node prev=null;
    		while(cur!=node) {
    			prev=cur;
    			cur=cur.up;
    		}
    		prev.up=null;
    	}
    	
    	int r=node.r+dr[node.dir];
    	int c=node.c+dc[node.dir];
    	
    	if(!valid(r,c)) { // 파란색인 경우
    		if(node.dir<=1) {
    			node.dir=(node.dir+1)%2;
    		}
    		else {
    			node.dir=(node.dir-1)%2+2;
    		}
    		r=node.r+dr[node.dir];
        	c=node.c+dc[node.dir];
    	}
    	
    	if(valid(r,c)) {
    		node.changeUpsRC(r,c);
    		
    		if(arr[r][c]==1) { // 빨간색인 경우
    			node=node.reverse();
    		}
    	}
    	else {
    		r=node.r;
    		c=node.c;
    	}
    	
    	if(horse[r][c]!=null) { // 이동할 칸에 말이 있는 경우
    		horse[r][c].getCeiling().up=node;
    	}
    	else {
    		horse[r][c]=node;
    	}
    	
    	if(horse[r][c].upSize()>=4) { // 말이 4개가 쌓여있는 경우
    		return false;
    	}
    	return true;
    }
    
    private static boolean valid(int r, int c) {
    	return r>=0&&r<N&&c>=0&&c<N&&arr[r][c]!=2;
    }
    
}