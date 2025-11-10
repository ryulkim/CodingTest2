import java.io.*;
import java.util.*;

public class Main {
	
	static int T, W, ans=0;
	static int[] a, b, arr;
	static int[][][] dp;

    public static void main(String[] args) throws IOException {
    	init();
    	proc();
    	System.out.println(ans);
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	T=Integer.parseInt(st.nextToken());
    	W=Integer.parseInt(st.nextToken());
    	arr=new int[T+1];
    	dp=new int[T+1][2][W+1];
    	
    	for (int i = 1; i <= T; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
    	
    	for (int i = 0; i < T; i++) {
			for (int j = 0; j < 2; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
    }
    
    public static void proc() {
    	dp[0][0][0]=0;
    	
    	for (int i = 0; i < T; i++) {
    		for (int j = 0; j <= W; j++) {
 			
    			if(arr[i+1]==2) {
    				if(dp[i][0][j]!=-1) {
    					if(j<W) dp[i+1][1][j+1]=Math.max(dp[i+1][1][j+1],dp[i][0][j]+1);
    					dp[i+1][0][j]=Math.max(dp[i+1][0][j],dp[i][0][j]);
    				}
    				if(dp[i][1][j]!=-1) {
    					dp[i+1][1][j]=Math.max(dp[i+1][1][j],dp[i][1][j]+1);
    					if(j<W) dp[i+1][0][j+1]=Math.max(dp[i+1][0][j+1],dp[i][1][j]);
    				}
    			}
    			else {
    				if(dp[i][0][j]!=-1) {
    					if(j<W) dp[i+1][1][j+1]=Math.max(dp[i+1][1][j+1],dp[i][0][j]);
    					dp[i+1][0][j]=Math.max(dp[i+1][0][j],dp[i][0][j]+1);
    				}
    				if(dp[i][1][j]!=-1) {
    					dp[i+1][1][j]=Math.max(dp[i+1][1][j],dp[i][1][j]);
    					if(j<W) dp[i+1][0][j+1]=Math.max(dp[i+1][0][j+1],dp[i][1][j]+1);
    				}
    			}
    			ans=Math.max(ans, dp[i+1][0][j]);
    			ans=Math.max(ans, dp[i+1][1][j]);
			}
		}
    }
    
}