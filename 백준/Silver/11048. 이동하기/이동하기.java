import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] arr, dp;
	static int[] dr= {0,1,1};
	static int[] dc= {1,0,1};

    public static void main(String[] args) throws IOException {
    	init();
    	proc();
    	System.out.println(dp[N-1][M-1]);
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	arr=new int[N][M];
    	dp=new int[N][M];
    	
    	for (int i = 0; i < N; i++) {
    		st=new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    }
    
    public static void proc() {
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(i==0&&j==0) {
					dp[i][j]=arr[i][j];
				}
				else if(i==0) {
					dp[i][j]=dp[i][j-1]+arr[i][j];
				}
				else if(j==0) {
					dp[i][j]=dp[i-1][j]+arr[i][j];
				}
				else {
					dp[i][j]=Math.max(Math.max(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+arr[i][j];
				}
			}
		}
    }
    
    public static boolean valid(int r, int c) {
    	return r>=0&&r<N&&c>=0&&c<M;
    }
}
