import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 시간: 144ms	메모리: 16,560KB
 */
public class Main {
	
	static int N, M;
	static long ans=0;
	static long dp[], arr[], prefix[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		dp=new long[N+1];
		arr=new long[N+1];
		prefix=new long[N+1];
		
		for (int i = 1; i <= N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
			prefix[i]=prefix[i-1]+arr[i];
		}
		
		dp[M]=prefix[M]-prefix[0];
		ans=Math.max(0, dp[M]);
		for (int i = M+1; i <= N; i++) {
			dp[i]=Math.max(prefix[i]-prefix[i-M], dp[i-1]+arr[i]);
			ans=Math.max(dp[i], ans);
		}
		
		System.out.println(ans);
	}
	
	
}

