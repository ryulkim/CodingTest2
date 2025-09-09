import java.io.*;
import java.util.*;

public class Main {

	static int C, N;
	static int[] costs, counts;
	static int[] dp;
	
    public static void main(String[] args) throws Exception {
    	init();	
    	proc();
    }
    
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	StringBuilder sb=new StringBuilder();
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	C=Integer.parseInt(st.nextToken());
    	N=Integer.parseInt(st.nextToken());
    	costs=new int[N];
    	counts=new int[N];
    	dp=new int[2000];
    	Arrays.fill(dp, 1000_000_000);
    	
    	for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			int cost=Integer.parseInt(st.nextToken());
			int cnt=Integer.parseInt(st.nextToken());
			
			costs[i]=cost;
			counts[i]=cnt;
		}
    }
    
    public static void proc() {
    	dp[0]=0;
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j <= 1500; j++) {
				int target=j+counts[i];
				dp[target]=Math.min(dp[j]+costs[i], dp[target]);
			}
		}
    	
    	int ans=1000_000_000;
    	for (int i = C; i < 2000; i++) {
			ans=Math.min(dp[i], ans);
		}
    	System.out.println(ans);
    }
    
}
