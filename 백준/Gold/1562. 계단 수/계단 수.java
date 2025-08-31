import java.io.*;
import java.util.*;

public class Main {

	static int N, MOD=1000_000_000;
	static int[][][] dp;
	
    public static void main(String[] args) throws Exception {
    	init();
    	proc();
    }

    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	StringTokenizer st=new StringTokenizer(br.readLine());
    	StringBuilder sb=new StringBuilder();
    	
    	N=Integer.parseInt(br.readLine());
    	dp=new int[N+1][10][1<<10]; // 길이, 끝 숫자, 숫자 개수가 포함된 경우?
    	
    	
    }
    
    public static void proc() {
    	for (int i = 1; i <= 9; i++) {
			dp[1][i][1<<i]=1;
		}
    	
    	for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k < 1<<10; k++) {
					if(j>0) dp[i][j][k|(1<<j)] = (int) (((long) dp[i][j][k|(1<<j)]+dp[i-1][j-1][k])%MOD);
					if(j<9) dp[i][j][k|(1<<j)] = (int) (((long) dp[i][j][k|(1<<j)]+dp[i-1][j+1][k])%MOD);
				}
			}
		}
    	
    	long ans=0;
    	for (int i = 0; i <= 9; i++) {
			ans+=dp[N][i][(1<<10)-1];
			ans%=MOD;
		}
    	System.out.println(ans);
    }
}
