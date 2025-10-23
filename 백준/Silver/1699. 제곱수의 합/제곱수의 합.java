import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] dp;

    public static void main(String[] args) throws IOException {
    	init();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		dp=new int[N+1];
		Arrays.fill(dp, 1000_000);
		dp[0]=0;
		int sqrt=(int) Math.sqrt(N);
		
		for (int i = 1; i <= sqrt; i++) {
			int num=i*i;
			for (int j = 0; j < N; j++) {
				int nxt=j+num;
				if(nxt>N) continue;
				dp[nxt]=Math.min(dp[nxt], dp[j]+1);
			}
		}
		
		System.out.println(dp[N]);
    }
    
    
}
