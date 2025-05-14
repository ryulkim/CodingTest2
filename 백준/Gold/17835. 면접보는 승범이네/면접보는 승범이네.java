import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M, K, ans_x;
	static long ans;
	static ArrayList<int[]>[] graph;
	static long[] dp;
	static int[] dr= {0,0,1,-1};
	static int[] dc= {1,-1,0,0};
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	dij();
    	chk();
//    	System.out.println();
    	System.out.println(ans_x);
    	System.out.println(ans);
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	K=Integer.parseInt(st.nextToken());
    	ans_x=N;
    	ans=0L;
    	
    	graph=new ArrayList[N+1];
    	dp=new long[N+1];
    	Arrays.fill(dp, 1000_000_000_000L);
    	
    	for (int i = 0; i <= N; i++) {
			graph[i]=new ArrayList<>();
		}
    	
    	for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			graph[v].add(new int[] {u,c});
		}
    	
    	st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < K; i++) {
			int x=Integer.parseInt(st.nextToken());
			graph[0].add(new int[] {x,0});
		}
    }
    
    public static void chk() {
    	for (int i = 1; i <= N; i++) {
    		if(dp[i]==1000_000_000_000L) continue;
    		
    		if(ans==dp[i]) {
    			ans_x=Math.min(ans_x, i);
    		}
    		else if(ans<dp[i]) {
    			ans=dp[i];
    			ans_x=i;
    		}
    	}
    }
    
    public static void dij() {
    	PriorityQueue<long[]> pq=new PriorityQueue<long[]>((a,b)->Long.compare(a[1], b[1]));
    	pq.add(new long[] {0,0});
    	dp[0]=0;
    	
    	while(!pq.isEmpty()) {
    		long[] pos=pq.poll();
    		int cur=(int) pos[0];
    		
    		if(dp[cur]<pos[1]) continue;
    		
    		int sz=graph[cur].size();

//    		System.out.println(pos[0]+" "+pos[1]+" "+sz);
    		
    		for (int i = 0; i < sz; i++) {
    			int nx=graph[cur].get(i)[0];
    			int nc=graph[cur].get(i)[1];
    			
    			if(dp[nx]>pos[1]+nc) {
    				dp[nx]=pos[1]+nc;
    				pq.add(new long[] {nx, pos[1]+nc});
    			}
			}
    	}
    	
    }
    
    public static boolean valid(int i, int j) {
    	return i>=0&&i<N&&j>=0&&j<M;
    }

}