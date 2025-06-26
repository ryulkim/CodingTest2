import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Tree{
	int r,c,age;
//	boolean isLive;

	public Tree(int r, int c, int age) {
		super();
		this.r = r;
		this.c = c;
		this.age = age;
	}
}

public class Main {
	
	static int N,M,year;
	static int[][] grains, s2d2;
	static LinkedList<Tree> live;
	static LinkedList<Tree> dead;
	static int[] dr= {-1,-1,-1,0,0,1,1,1};
	static int[] dc= {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	year=Integer.parseInt(st.nextToken());
    	grains=new int[N][N];
    	s2d2=new int[N][N];
    	live=new LinkedList<>();
    	dead=new LinkedList<>();
    	
    	for (int i = 0; i < N; i++) {
    		st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				s2d2[i][j]=Integer.parseInt(st.nextToken());
				grains[i][j]=5;
			}
		}
    	
    	for (int i = 0; i < M; i++) {
    		st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken())-1;
			int c=Integer.parseInt(st.nextToken())-1;
			int z=Integer.parseInt(st.nextToken());
			live.add(new Tree(r, c, z));
		}
    }

    public static void proc() {
    	for (int i = 0; i < year; i++) {
			spring();
			summer();
			fall();
			winter();
		}
    	System.out.println(live.size());
    }

    
    public static void spring() {
    	int sz=live.size();
    	
    	for (int i = 0; i < sz; i++) {
			Tree t=live.poll();
			
			if(grains[t.r][t.c]>=t.age) {
    			grains[t.r][t.c]-=t.age;
    			t.age++;
    			live.add(t);
    		}
    		else dead.add(t);
		}	
    }
    
    public static void summer() {
    	for (Tree t : dead) {
    		grains[t.r][t.c]+=t.age/2;
		}
    	dead.clear();
    }
    
    public static void fall() {
    	LinkedList<Tree> temp=new LinkedList<>();
    	
    	for (Tree t: live) {
    		if(t.age%5==0) temp.add(t);
		}
    	
    	while(!temp.isEmpty()) {
    		Tree t=temp.poll();
    		
			for (int i = 0; i < 8; i++) {
				int nr=t.r+dr[i];
				int nc=t.c+dc[i];
				if(valid(nr,nc)) {
					Tree newTree=new Tree(nr,nc,1);
					live.addFirst(newTree);
				}
			}
		}
    	
    }
    
	public static void winter() {
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				grains[i][j]+=s2d2[i][j];
			}
		}
    }
	
	private static boolean valid(int r, int c) {
		return r>=0&&r<N&&c>=0&&c<N;
	}
    
}