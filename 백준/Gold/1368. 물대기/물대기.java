import java.io.*;
import java.util.*;

public class Main {

	static int N, sum=0, min=100_000, f=0;
	static int[][] arr;
	static ArrayList<int[]> edges, mstEdges;
	static ArrayList<int[]>[] graph;
	static HashSet<Integer>[] exceptN;
	static int[] cost, par;
	static boolean[] water, chk;
	
    public static void main(String[] args) throws Exception {
    	init();
    	mst();
    	proc();
    }
    
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N][N];
    	edges=new ArrayList<>();
    	mstEdges=new ArrayList<>();
    	graph=new ArrayList[N];
    	exceptN=new HashSet[N];
    	par=new int[N];
    	cost=new int[N];
    	water=new boolean[N];
    	chk=new boolean[N];
    	
    	for (int i = 0; i < N; i++) {
			par[i]=i;
			graph[i]=new ArrayList<>();
			exceptN[i]=new HashSet<>();
			cost[i]=Integer.parseInt(br.readLine());
			if(min>cost[i]) {
				min=cost[i];
				f=i;
			}
		}
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num=Integer.parseInt(st.nextToken());
				if(num!=0) edges.add(new int[] {i,j,num});
			}
		}
    }
    
    public static void proc() {
    	mstEdges.sort((a,b)->Integer.compare(b[2], a[2]));
    	
    	for (int[] edge : mstEdges) {
			int total=calculateTree(edge[0], -1);
			int A=calculateTree(edge[0], edge[1]);
			int B=calculateTree(edge[1], edge[0]);
			
			if(total>A+B) {
				exceptN[edge[0]].add(edge[1]);
				exceptN[edge[1]].add(edge[0]);
			}
		}
    	
    	int ans=0;
    	for (int i = 0; i < N; i++) {
			if(chk[i]) continue;
			ans+=finalCal(i);
		}
    	
    	System.out.println(ans);
    }
    
    public static int finalCal(int start) {
    	ArrayDeque<Integer> q=new ArrayDeque<>();
    	chk[start]=true;
    	int sum=0;
    	int min=cost[start];
    	
    	q.add(start);
    	while(!q.isEmpty()) {
    		int num=q.poll();
    		
    		for (int[] info : graph[num]) {
				if(chk[info[0]]||exceptN[num].contains(info[0])) continue;
				min=Math.min(min, cost[info[0]]);
				sum+=info[1];
				chk[info[0]]=true;
				q.add(info[0]);
			}
    	}
    	
    	return sum+min;
    }
    
    public static int calculateTree(int start, int except) {
    	ArrayDeque<Integer> q=new ArrayDeque<>();
    	q.add(start);
    	
    	boolean[] chk=new boolean[N];
    	chk[start]=true;
    	if(except!=-1) {
    		chk[except]=true;
    	}
    	
    	int min=cost[start];
    	int sum=0;
    	
    	while(!q.isEmpty()) {
    		int num=q.poll();
    		
    		for (int[] info : graph[num]) {
				if(chk[info[0]]||exceptN[num].contains(info[0])) continue;
				min=Math.min(min, cost[info[0]]);
				sum+=info[1];
				chk[info[0]]=true;
				q.add(info[0]);
			}
    	}
    	
    	return sum+min;
    }
    
    public static void mst() {	
    	edges.sort((a,b)->Integer.compare(a[2], b[2]));
    	
    	for (int[] info: edges){
			if(union(info[0], info[1])) {
				int c=info[2];
				sum+=c;
				graph[info[0]].add(new int[] {info[1],info[2]});
				graph[info[1]].add(new int[] {info[0],info[2]});
				mstEdges.add(info);
			}
		}
    }

    public static boolean union(int a, int b) {
    	int parA=find(a);
    	int parB=find(b);
    	if(parA==parB) {
    		return false;
    	}
    	par[parA]=parB;
    	return true;
    }
    
    public static int find(int num) {
    	if(par[num]==num) {
    		return num;
    	}
    	return par[num]=find(par[num]);
    }
    
    
}
