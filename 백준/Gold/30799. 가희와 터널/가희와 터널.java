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
			// 아무것도 안먹을 경우는 순서대로 먹이가 오지 않았을 경우
        	dp[i][0]+=dp[i-1][0]*6;
        	dp[i][0]%=MOD;
		}
        
        for (int i = 1; i <= s; i++) {
			for (int j = 1; j <= 7; j++) {
				//1. 해당하는 색깔을 지금 먹는 경우
				dp[i][j]+=dp[i-1][j-1];
				dp[i][j]%=MOD;
				
				//2. 해당하는 색깔을 이미 먹었던 경우
				//2-1. 먹었는데 또 먹는 경우
				dp[i][j]+=dp[i-1][j];
				dp[i][j]%=MOD;
				//2-2. 다른거 먹는 경우
				//2-2-1. 보라색인 경우는 *6
				if(j==7) dp[i][j]+=(long)(dp[i-1][j]*6);
				//2-2-2. 다른 색인 경우는 뒤에꺼 색을 두면 안됨 따라서 *5
				else dp[i][j]+=(long)(dp[i-1][j]*5);
				dp[i][j]%=MOD;
				
			}
		}
        
        System.out.println(dp[s][7]);
    }

    
}
