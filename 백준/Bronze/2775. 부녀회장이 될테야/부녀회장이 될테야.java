import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static int T, k, n;
	static int[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	T=Integer.parseInt(br.readLine());
    	dp=new int[15][15];
    	
    	proc();
    	
    	StringBuilder sb=new StringBuilder();
    	
    	for (int testCase = 0; testCase < T; testCase++) {
			k=Integer.parseInt(br.readLine());
			n=Integer.parseInt(br.readLine());
			
			sb.append(dp[k][n]);
			sb.append("\n");
		}
    	
    	System.out.println(sb);
    	
    }
    
    public static void proc() {
    	for (int i = 0; i < 15; i++) {
			for (int j = 1; j < 15; j++) {
				if(i==0) {
					dp[i][j]=j;
				}
				else {
					dp[i][j]=dp[i-1][j]+dp[i][j-1];
				}
			}
		}
    }
    
}