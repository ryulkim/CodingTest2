import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// A G C T A T

public class Main {
    
	static String s;
	static int[][] dp;
	static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
        
    	proc();
    	
//    	chk();
        
        System.out.println(dp[0][N-1]);
        
    }
    
    public static void chk() {
    	StringBuilder sb=new StringBuilder();
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(dp[i][j]+" ");
			}
			sb.append("\n");
		}
    	
    	System.out.println(sb);
    }
    
    public static void proc() {
    	for (int len = 2; len <= N; len++) {
    		for (int i = 0; i <= N-len; i++) {
    			int end=i+len-1;
    			
    			if(isPair(s.charAt(i), s.charAt(end))){
    				if(len==2) dp[i][end]=2;
    				else dp[i][end]=dp[i+1][end-1]+2;
    			}
    			
    			for (int j = i; j < end; j++) {
    				dp[i][end]=Math.max(dp[i][j]+dp[j+1][end], dp[i][end]);
    			}
    		}
//    		chk();
		}
    	
    }
    
    public static boolean isPair(char a, char b) {
    	if(a=='a'&&b=='t') return true;
    	if(a=='g'&&b=='c') return true;
    	return false;
    }
    
    public static void init() throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        s=br.readLine();
        N=s.length();
        dp=new int[N][N];
    }
}