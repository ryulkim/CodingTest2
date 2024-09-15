import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 시간: 776ms	메모리: 128,744KB
 */
public class Main {
	
	static int N, M, K, ans=Integer.MAX_VALUE;
	static int dp[][][], arr[][]; //dp[i][j][B/W]:i*j 크기의 정사각형까지 다시 칠해야 하는 정사각형 개수(i,j번째가 B나 W로 칠할 때)

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		StringBuilder sb=new StringBuilder();
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		dp=new int[N+1][M+1][2];
		arr=new int[N+1][M+1];
		
		for (int i = 0; i < N; i++) {
			String s=br.readLine();
			for (int j = 0; j < M; j++) {
				if(s.charAt(j)=='B') arr[i][j]=0;
				else arr[i][j]=1;
			}
		}
		
		if(arr[0][0]==0) {
			dp[0][0][1]=1;
			dp[0][0][0]=0;
		}
		else {
			dp[0][0][0]=1;
			dp[0][0][1]=0;
		}
		
		for (int i = 1; i < N; i++) {
			int color=arr[i][0];
			int oppositeColor=(color+1)%2;
			dp[i][0][color]+=dp[i-1][0][oppositeColor];
			dp[i][0][oppositeColor]+=dp[i-1][0][color]+1;
		}
		
		for (int i = 1; i < M; i++) {
			int color=arr[0][i];
			int oppositeColor=(color+1)%2;
			dp[0][i][color]+=dp[0][i-1][oppositeColor];
			dp[0][i][oppositeColor]+=dp[0][i-1][color]+1;
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				int color=arr[i][j];
				int oppositeColor=(color+1)%2;
				dp[i][j][color]=(dp[i-1][j][oppositeColor]+dp[i][j-1][oppositeColor]-dp[i-1][j-1][color]);
				dp[i][j][oppositeColor]=(dp[i-1][j][color]+dp[i][j-1][color]-dp[i-1][j-1][oppositeColor]+1);
			}
		}
		
		for (int i = K-1; i < N; i++) {
			for (int j = K-1; j < M; j++) {
				int bnum=dp[i][j][0]; //i,j번째 타일이 black인 정사각형일 때
				int color=K%2==0?0:1;
				
				if(i-K+1!=0) {
					bnum-=dp[i-K][j][color];
				}
				if(j-K+1!=0) {
					bnum-=dp[i][j-K][color];
				}
				if(i-K+1!=0&&j-K+1!=0) {
					bnum+=dp[i-K][j-K][0];
				}
				
				int wnum=dp[i][j][1]; //i,j번째 타일이 white인 정사각형일 때
				color=K%2==0?1:0;
				
				if(i-K+1!=0) {
					wnum-=dp[i-K][j][color];
				}
				if(j-K+1!=0) {
					wnum-=dp[i][j-K][color];
				}
				if(i-K+1!=0&&j-K+1!=0) {
					wnum+=dp[i-K][j-K][1];
				}
				
				ans=Math.min(ans, bnum);
				ans=Math.min(ans, wnum);
			}
		}
		
		
		
		System.out.println(ans);
		
	}
	
	
	
}

