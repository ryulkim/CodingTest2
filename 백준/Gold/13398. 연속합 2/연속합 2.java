import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 시간: 384ms	메모리: 17,788KB
 */
public class Main {
	
	static int N, X, ans=Integer.MIN_VALUE;
	static int dp[][];
	static ArrayList<V> arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		dp=new int[N+1][2];
		arr=new ArrayList<>();
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		X=Integer.parseInt(st.nextToken());
		dp[1][0]=X;
		ans=X;
		
		for (int i = 2; i <= N; i++) {
			X=Integer.parseInt(st.nextToken());
			
			dp[i][0]=Math.max(dp[i-1][0]+X, X);
			dp[i][1]=Math.max(dp[i-1][1]+X, dp[i-1][0]);
			ans=Math.max(ans, dp[i][0]);
			ans=Math.max(ans, dp[i][1]);
		}
		
		if(N==1) System.out.println(X);
		else System.out.println(ans);
	}
	
	static class V{
		int r,c;

		public V(int r, int c) {
			super();
			this.r = r;
			this.c = c;
			
		}
		
		
	}
}

