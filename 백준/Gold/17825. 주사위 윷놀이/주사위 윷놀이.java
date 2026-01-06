import java.io.*;
import java.util.*;

public class Main {
	
	static class Node {
		int score;
		int color; // 0: 시작, 1: 빨강, 2: 파랑, 3: 도착
		Node redNext, blueNext; 
		
		Node(int score, int color) {
			this.score=score;
			this.color=color;
		}
		
		public void setRedNext(Node node) {
			redNext=node;
		}
		
		public void setBlueNext(Node node) {
			blueNext=node;
		}
	}
	
	static int N, M, T, ans=0, cur=0;
	static ArrayDeque<Node>[] horsesHistory;
	static Node[] horses;
	static int[] dices;
	
    public static void main(String[] args) throws IOException {
    	init();
    	makeGraph();
    	proc();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	dices=new int[10];
    	horses=new Node[4];
    	horsesHistory=new ArrayDeque[4];
    	
    	for (int i = 0; i < 4; i++) {
			horsesHistory[i]=new ArrayDeque<>();
		}
    	
    	for (int i = 0; i < 10; i++) {
			dices[i]=Integer.parseInt(st.nextToken());
		}
    }
    
    public static void proc() {
    	selectHorse(0);
    	System.out.println(ans);
    }
    
    private static void selectHorse(int depth) {
    	if(depth==10) {
    		ans=Math.max(ans, cur);
    		return;
    	}
    	for (int i = 0; i < 4; i++) {
			go(i, dices[depth]);
			if(checkHorse(i)) {				
				selectHorse(depth+1);
			}
			back(i);
		}
    }
    
    private static boolean checkHorse(int num) {
    	if(horses[num].color==3) return true;
    	
    	for (int i = 0; i < 4; i++) {
			if(i==num) continue;
			if(horses[num]==horses[i]) return false;
		}
    	return true;
    }
    
    private static void go(int num, int cnt) {
    	horsesHistory[num].addLast(horses[num]);
    	
    	boolean isRed=true;
    	if(horses[num].color==2) {
    		isRed=false;
    	}
    	
    	for (int i = 0; i < cnt; i++) {
    		if(horses[num].color==3) return;
    		
			if(!isRed) {
				horses[num]=horses[num].blueNext;
				isRed=true;
			}
			else {
				horses[num]=horses[num].redNext;
			}
		}
    	
    	cur+=horses[num].score;
    }
    
    private static void back(int num) {
    	cur-=horses[num].score;
    	horses[num]=horsesHistory[num].pollLast();
    }
    
    public static void makeGraph() {
    	Node start=new Node(0,0);
    	Node end=new Node(0,3);
    	Node blue1=new Node(10,2);
    	Node blue2=new Node(20,2);
    	Node blue3=new Node(30,2);
    	Node twentyFive=new Node(25,1);
    	Node fourty=new Node(40,1);
    	Node thirteen=new Node(13,1);
    	Node twentyTwo=new Node(22,1);
    	Node twentyEight=new Node(28,1);
    	
    	for (int i = 0; i < 4; i++) {
			horses[i]=start;
		}
    	
    	// 도착
    	fourty.setRedNext(end);
    	
    	// 가장자리 빨간색
    	Node cur=start;
    	cur=connectRed(cur, 2, 10, 2);
    	cur.setRedNext(blue1);
    	
    	cur=blue1;
    	cur=connectRed(cur, 12, 20, 2);
    	cur.setRedNext(blue2);
    	
    	cur=blue2;
    	cur=connectRed(cur, 22, 30, 2);    	
    	cur.setRedNext(blue3);
    	
    	cur=blue3;
    	cur=connectRed(cur, 32, 40, 2);    	
    	cur.setRedNext(fourty);
    	
    	// 가운데 파란색
    	blue1.setBlueNext(thirteen);
    	blue2.setBlueNext(twentyTwo);
    	blue3.setBlueNext(twentyEight);
    	
    	cur=thirteen;
    	cur=connectRed(cur, 16, 20, 3);
    	cur.setRedNext(twentyFive);
    	
    	cur=twentyTwo;
    	cur=connectRed(cur, 24, 25, 2);
    	cur.setRedNext(twentyFive);
    	
    	cur=twentyEight;
    	cur=connectRed(cur, 27, 25, -1);
    	cur.setRedNext(twentyFive);
    	
    	// 가운데
    	cur=twentyFive;
    	cur=connectRed(cur, 30, 40, 5);
    	cur.setRedNext(fourty);
    }
    
    private static Node connectRed(Node cur, int start, int end, int interval) {
    	if(interval>0) {
        	for (int i = start; i < end; i+=interval) {
    			Node nxt=new Node(i,1);
    			cur.setRedNext(nxt);
    			cur=nxt;
    		}
    	}
    	else {
    		for (int i = start; i > end; i+=interval) {
    			Node nxt=new Node(i,1);
    			cur.setRedNext(nxt);
    			cur=nxt;
    		}
    	}
    	
    	return cur;
    }
    
    

}