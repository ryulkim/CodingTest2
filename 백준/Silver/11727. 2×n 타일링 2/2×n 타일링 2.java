import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
	static int N;
	static int[] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
        
    	proc();
    	
//    	chk();
        
        System.out.println(dp[N]);
        
    }
    
    public static void chk() {
    	for (int i = 0; i <= N; i++) {
			System.out.print(dp[i]+" ");
		}
    }
    
    public static void proc() {
    	for (int i = 0; i < N; i++) {
    		// 길이 +2 => 가로 2개, 정사각형 1개
    		if(i+2<=N) {
    			dp[i+2]+=2*dp[i];
    			dp[i+2]%=10007;
    		}
    		// 길이 +1 => 세로 1개
    		dp[i+1]+=dp[i];
    		dp[i+1]%=10007;
		}
    }
    
    public static void init() throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        N=Integer.parseInt(br.readLine());
        dp=new int[N+1];
        
        dp[0]=1;
    }
}