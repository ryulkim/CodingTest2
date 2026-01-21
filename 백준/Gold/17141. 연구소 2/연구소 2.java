import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, ans=Integer.MAX_VALUE;
	static int[][] arr;
	static ArrayList<int[]> birus;
	static int[] select;
	static int[] dr= {0,0,1,-1};
	static int[] dc= {1,-1,0,0};
	
    public static void main(String[] args) throws IOException {
    	init();
    	proc(0,0);
    	System.out.println(ans==Integer.MAX_VALUE?-1:ans);
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	arr=new int[N][N];
    	select=new int[M];
    	birus=new ArrayList<>();
    	
    	for (int i = 0; i < N; i++) {
    		st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int value=Integer.parseInt(st.nextToken());
				arr[i][j]=value;
				if(value==2) {
					birus.add(new int[] {i,j});
				}
			}
		}
    }
    
    public static void proc(int depth, int start) {
    	if(depth==M) {
    		int value=spread();
    		if(value!=-1) {
    			ans=Math.min(ans, value);
    		}
    		return;
    	}
    	
    	for (int i = start; i < birus.size(); i++) {
    		int[] info=birus.get(i);
    		select[depth]=i;
			proc(depth+1, i+1);
		}
    }
    
    public static int spread() {
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	int time=0;
    	boolean[][] chk=new boolean[N][N];
    	
    	for (int i = 0; i < M; i++) {
			int num=select[i];
			int[] info=birus.get(num);
			q.add(new int[] {info[0], info[1], 0});
			chk[info[0]][info[1]]=true;
		}
    	
    	while(!q.isEmpty()) {
    		int[] info=q.poll();
    		time=info[2];
    		
    		for (int i = 0; i < 4; i++) {
				int nr=info[0]+dr[i];
				int nc=info[1]+dc[i];
				
				if(!valid(nr,nc)||arr[nr][nc]==1||chk[nr][nc]) {
					continue;
				}
				
				chk[nr][nc]=true;
				q.add(new int[] {nr, nc, time+1});
			}
    	}
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j]!=1&&!chk[i][j]) {
					return -1;
				}
			}
		}
    	
    	return time;
    }
    
    private static boolean valid(int i, int j) {
    	return i>=0&&i<N&&j>=0&&j<N;
    }
}


