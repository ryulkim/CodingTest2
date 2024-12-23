import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;


public class Main {
	static int[][] graph, dp;
	static boolean[][] visited;
	static int[] dr= {0,0,1,-1};
	static int[] dc= {1,-1,0,0};
	static int N;

    public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	
    	graph=new int[N][N];
    	dp=new int[N][N];
    	visited=new boolean[N][N];
    	
    	for (int i = 0; i < N; i++) {
			String row=br.readLine();
			
			for (int j = 0; j < N; j++) {
				graph[i][j]=Integer.parseInt(String.valueOf(row.charAt(j)));
			}
			
			Arrays.fill(dp[i], 10000000);
		}
    	
    	dp[0][0]=0;
    	bfs();
    	
    	System.out.println(dp[N-1][N-1]);
    }
    
    public static void bfs() {
    	PriorityQueue<int[]> q=new PriorityQueue<int[]>((a,b)->{
    		return a[2]-b[2];
    	});
    	q.add(new int[]{0,0,0});
    	
    	while(!q.isEmpty()) {
    		int[] now=q.poll();
    		int i=now[0];
    		int j=now[1];
    		
    		if(dp[i][j]<now[2]) continue;
    		
    		for (int k = 0; k < 4; k++) {
				int nr=i+dr[k];
				int nc=j+dc[k];
				
				if(!valid(nr,nc)) continue;
				
				int isBlack=(graph[nr][nc]+1)%2;
				
				if(dp[nr][nc]>dp[i][j]+isBlack) {
					dp[nr][nc]=dp[i][j]+isBlack;
					q.add(new int[] {nr,nc,dp[nr][nc]});
				}
			}
    	}
    }
    
    public static boolean valid(int i, int j) {
    	return i>=0&&i<N&&j>=0&&j<N;
    }
}
