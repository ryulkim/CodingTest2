import java.io.*;
import java.util.*;

/*
 * 23,180 kb
 * 193 ms
 */
public class Main {
	
	public static int N;
	public static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		dp=new int[N+1][N+1];
		
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				int num=Integer.parseInt(st.nextToken());
				dp[i][j]=num;
				if(i==0) continue;
				dp[i][j]=Math.min(dp[i-1][(j+1)%3]+num,dp[i-1][(j+2)%3]+num);
			}
		}
		System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
	}
}
