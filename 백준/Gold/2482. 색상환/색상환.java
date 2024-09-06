import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 시간: 580ms	메모리: 251,540KB
 */
public class Main {
	
	static int N,K;
	static long[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		K=Integer.parseInt(br.readLine());
		dp=new long[N+1][K+1];
		
		for (int i = 1; i <= N; i++) {
			dp[i][0]=1;
			dp[i][1]=i;
		}
		
		for (int i = 3; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				dp[i][j]=(dp[i-2][j-1]+dp[i-1][j])%1000000003;
			}
		}
		
		System.out.println((dp[N-1][K]+dp[N-3][K-1])%1000000003);
		
		
	}
	
	

}

