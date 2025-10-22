import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] dp, arr;

    public static void main(String[] args) throws IOException {
    	init();
    	proc();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		dp=new int[N+1][M+1];
		
		for (int i = 0; i < N; i++) {
			String s=br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j]=s.charAt(j)-'0';
			}
		}
		
    }
    
    public static void proc() {
    	int ans=0;
    	
    	for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if(arr[i-1][j-1]==0) continue;
				dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1])+1;
				dp[i][j]=Math.min(dp[i-1][j-1]+1, dp[i][j]);
				
				ans=Math.max(ans, dp[i][j]);
			}
		}
    	
    	System.out.println(ans*ans);
    	
    }
    
    public static boolean valid(int i, int j) {
    	return i>=0&&i<N&&j>=0&&j<M;
    }
    
}
