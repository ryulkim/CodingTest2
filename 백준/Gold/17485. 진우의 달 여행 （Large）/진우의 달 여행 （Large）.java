import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	static int N, M;
	static int[][] arr;
	static int[][][] dp;
	static int[] dc= {-1,0,1};

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
//    	chk();
    	print();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	arr=new int[N][M];
    	dp=new int[N][M][3];
    	
    	for (int i = 0; i < N; i++) {
    		st=new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int x=Integer.parseInt(st.nextToken());
				arr[i][j]=x;
				dp[i][j][0]=x;
				dp[i][j][1]=x;
				dp[i][j][2]=x;
			}
		}
    	
    	for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Arrays.fill(dp[i][j], 1000_000_000);
			}
		}
    }
    
    public static void proc() {
    	for (int i = 0; i < N-1; i++) {
    		for (int j = 0; j < M; j++) {
    			for (int k = 0; k < 3; k++) {
    				for (int l = 0; l < 3; l++) {
    					if(k==l) continue;
    					int nc=j+dc[l];
    					if(!valid(nc)) continue;
    					
    					dp[i+1][nc][l]=Math.min(dp[i+1][nc][l], dp[i][j][k]+arr[i+1][nc]);
//    					System.out.println("chk: "+dp[i+1][nc][l]+" "+(dp[i][j][k]+arr[i+1][nc]));
					}
    			}
			}
		}
    }
    
    
    public static void chk() {
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < 3; k++) {
					System.out.print(dp[i][j][k]+" ");
				}
				System.out.println();
			}
			System.out.println("==========");
		}
    }
    
    public static void print() {
    	int ans=1000_000_000;
    	for (int i = 0; i < M; i++) {
			for (int j = 0; j < 3; j++) {
				ans=Math.min(ans, dp[N-1][i][j]);
			}
		}
    	System.out.println(ans);
    }
    
    public static boolean valid(int c) {
    	return c>=0&&c<M;
    }
}