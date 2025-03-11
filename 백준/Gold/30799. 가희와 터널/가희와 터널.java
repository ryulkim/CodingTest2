import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 998244353;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int s=Integer.parseInt(br.readLine());
        
        long dp[][]=new long[s+1][8]; //그 턴에서 먹은 종류까지
        dp[0][0]=1;
        
        for (int i = 1; i <=s ; i++) {
        	dp[i][0]=(dp[i-1][0]*6)%MOD;
		}
        
        for (int i = 1; i <= s; i++) {
			for (int j = 1; j <= 7; j++) {				
				if(j==7) dp[i][j]=(dp[i-1][j-1]+dp[i-1][j]*7)%MOD;
				else dp[i][j]=(dp[i-1][j-1]+dp[i-1][j]*6)%MOD;
				
			}
		}
        
        System.out.println(dp[s][7]);
    }

    
}
