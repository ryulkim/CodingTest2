import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static int N, ans=1000_000_000;
    static int[][] rgb, first;
    static int[][][] dp; // 위치, 현위치 색깔, 처음위치 색깔
    
    /*
     * 빨,초,파
     * 빨 - 초
     *   - 파
     * 초 - 빨
     *   - 파
     * 파 - 빨
     *   - 초
     * 
     * if(N<N번째 집)
     * dp[N][빨]=min(dp[N][빨],dp[N-1][초]+rgb[N][빨])
     *         =min(dp[N][빨],dp[N-1][파]+rgb[N][빨])
     * dp[N][초]+=dp[N-1][빨]
     *         +=dp[N-1][파]
     * dp[N][파]+=dp[N-1][초]
     *         +=dp[N-1][빨]
     * 
     * if(N번째 집)
     * 		if(1번째 집이 빨)
     * 		앞뒤의 색깔과 다른 것 판단(1번째와 N-1번째 집의 색깔이 다른 것)
     * 		dp[N][빨]+=dp[N-1][초] (1번째 집이 빨)
     * 		dp[N][파]+=dp[N-1][초] (1번째 집이 빨)
     * 
     * 		dp[N][빨]+=dp[N-1][초] (1번째 집이 파)
     * 
     * 
     */

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
        
    	proc();
    	
//    	chkFirst();
//    	chkDp();
        
        System.out.println(ans);
        
    }
    
    public static void chkDp() {
    	StringBuilder sb=new StringBuilder();
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					sb.append(dp[i][j][k]+"/");
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
    	
    	System.out.println(sb);
    }
    
    public static void chkFirst() {
    	StringBuilder sb=new StringBuilder();
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				sb.append(first[i][j]+" ");
			}
			sb.append("\n");
		}
    	
    	System.out.println(sb);
    }
    
    public static void proc() {
    	// N-1 이전의 위치 집을 칠할 때
        for (int i = 1; i < N-1; i++) { // 칠할 집 위치
            for (int j = 0; j < 3; j++) { // 칠할 색
				for (int k = 0; k < 3; k++) { // 이전 집의 색
					for (int l = 0; l < 3; l++) { // 첫번째 집의 색
						if(k==j) continue;
						if(dp[i][j][l]>dp[i-1][k][l]+rgb[i][j]) {
							dp[i][j][l]=dp[i-1][k][l]+rgb[i][j];
						}
					}
				}
			}
        }
        
        // N-1의 위치를 칠할 때
        for (int i = 0; i < 3; i++) { // 칠할 색
        	for (int j = 0; j < 3; j++) { // 이전 집의 색
    			if(i==j) continue;
        		for (int k = 0; k < 3; k++) { // 첫번째 집의 색
    				if(k==i) continue;
    				dp[N-1][j][k]=Math.min(dp[N-1][j][k], dp[N-2][j][k]+rgb[N-1][i]);
    				ans=Math.min(dp[N-1][j][k],ans);
				}

			}
		}
    }
    
    public static void init() throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        N=Integer.parseInt(br.readLine());
        rgb=new int[N+1][3];
        dp=new int[N+1][3][3]; //빨,초,파
        first=new int[N+1][3];
        
        for (int i = 0; i < N; i++) {
        	StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				rgb[i][j]=Integer.parseInt(st.nextToken());
			}
		}
        
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < 3; j++) {
        		Arrays.fill(dp[i][j], 1000_000_000);				
			}
		}
        
        dp[0][0][0]=rgb[0][0];
        dp[0][1][1]=rgb[0][1];
        dp[0][2][2]=rgb[0][2];
        
        first[0][0]=0;
        first[0][1]=1;
        first[0][2]=2;
    }
}