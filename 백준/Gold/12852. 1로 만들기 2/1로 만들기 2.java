import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] last, dp;

    public static void main(String[] args) throws IOException {
    	init();
    	proc();
    	System.out.println(dp[N]);
    	StringBuilder sb=new StringBuilder();
    	while(N>0) {
    		sb.append(N).append(" ");
    		N=last[N];
    	}
    	System.out.println(sb);
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	last=new int[N+1];
    	dp=new int[N+1];
    	
    	Arrays.fill(dp, 1000_000_000);
    	dp[1]=0;
    }
    
    public static void proc() {
    	for (int i = 1; i < N; i++) {
    		int num=dp[i]+1;
    		
    		if(dp[i+1]>num) {
    			last[i+1]=i;
    			dp[i+1]=num;
    		}
    		if(i*3<=N&&dp[i*3]>num) {
    			last[i*3]=i;
    			dp[i*3]=num;
    		}
    		if(i*2<=N&&dp[i*2]>num) {
    			last[i*2]=i;
    			dp[i*2]=num;
    		}
		}
    }
}
