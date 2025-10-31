import java.io.*;
import java.util.*;

public class Main {
	
	static int N, T, P, ans=0;
	static int[][] arr;
	static int[] dp;

    public static void main(String[] args) throws IOException {
    	init();
    	proc();
    	System.out.println(ans);
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N][2]; 
    	dp=new int[N+1]; 
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
			T=Integer.parseInt(st.nextToken());
			P=Integer.parseInt(st.nextToken());
			
			arr[i][0]=T;
			arr[i][1]=P;
		}
    }
    
    public static void proc() {
    	for (int i = 0; i < N; i++) {
    		int nDay=i+arr[i][0];
    		if(i>0) dp[i]=Math.max(dp[i-1], dp[i]);
    		ans=Math.max(ans, dp[i]);
    		if(nDay>N) continue;
			dp[nDay]=Math.max(dp[nDay], dp[i]+arr[i][1]);
		}
    	
    	ans=Math.max(ans, dp[N]);
    	
    }
    
}
