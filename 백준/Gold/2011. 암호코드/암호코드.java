import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] dp;
	static String input;

    public static void main(String[] args) throws IOException {
    	init();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		input=br.readLine();
		N=input.length();
		dp=new int[N+1][2];
		
		if(parseInt(input.substring(0, 1)) > 0) {			
			dp[0][0]=1; dp[0][1]=1; dp[1][0]=1;
		}
		
		for (int i = 1; i < N; i++) {
			String one=input.substring(i,i+1);
			String two=input.substring(i-1,i+1);
			
			int num=Integer.parseInt(one);
			
			if(num>0) {
				dp[i+1][0]+=dp[i][0];
				dp[i+1][0]%=1000_000;
				dp[i+1][0]+=dp[i][1];
				dp[i+1][0]%=1000_000;				
			}			
			
			if(two.charAt(0)!='0') {
				int value=parseInt(two);
				if(value>=1&&value<=26) {
					dp[i+1][1]+=dp[i-1][0];
					dp[i+1][1]%=1000_000;
					if(i>1) {
						dp[i+1][1]+=dp[i-1][1];
						dp[i+1][1]%=1000_000;
					}
				}
			}
		}
		
		System.out.println((dp[N][0]+dp[N][1])%1000_000);
    }
   
    
    public static int parseInt(String s) {
    	return Integer.parseInt(s);
    }
    
    
}
