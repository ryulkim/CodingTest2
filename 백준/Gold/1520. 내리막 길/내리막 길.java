import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] dp, arr;
	static int[] dr= {0,0,1,-1};
	static int[] dc= {-1,1,0,0};
	static ArrayDeque<int[]> q;

    public static void main(String[] args) throws IOException {
    	init();
    	dfs(0, 0);
    	System.out.println(dp[0][0]);
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		dp=new int[N][M];
		q=new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				dp[i][j]=-1;
			}
		}
		
		dp[N-1][M-1]=1;
    }
    
    public static int dfs(int r, int c) {
    	
    	if(dp[r][c]!=-1) return dp[r][c];
    	
    	int sum=0;
    	
    	for (int k = 0; k < 4; k++) {
			int nr=r+dr[k];
			int nc=c+dc[k];
			
			if(!valid(nr,nc)) continue;
			
			if(arr[r][c]>arr[nr][nc]) {
				sum+=dfs(nr, nc);
			}
		}
    	
    	dp[r][c]=sum;
    	
    	return dp[r][c];
    }
    
    public static boolean valid(int i, int j) {
    	return i>=0&&i<N&&j>=0&&j<M;
    }
    
}
