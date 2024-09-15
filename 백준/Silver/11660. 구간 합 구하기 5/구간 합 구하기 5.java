import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 시간: 244ms	메모리: 26,284KB
 */
public class Main {
	
	static int N, M, X, ans=Integer.MIN_VALUE;
	static int dp[][], arr[][]; //dp[i][j]: i*j 크기의 정사각형의 합

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		dp=new int[N+1][N+1];
		arr=new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for (int j = 1; j <= N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j]=dp[i-1][j]+dp[i][j-1]+arr[i][j]-dp[i-1][j-1];
			}
		}
		
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			
			System.out.println(dp[x2][y2]-dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1]);
		}
		
	}
	
}

