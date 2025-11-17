import java.io.*;
import java.util.*;

public class Main {
	
	static int N, ans=0;
	static long[][] dp;
	static int[][] arr;
	static int[] dr= {0,1};
	static int[] dc= {1,0};

    public static void main(String[] args) throws IOException {
    	init();
    	proc();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N][N];
    	dp=new long[N][N];
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    }
    
    public static void proc() {
    	dp[0][0]=1;
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int num=arr[i][j];
				
				if(num==0) continue;
				
				for (int k = 0; k < 2; k++) {
					int nr=i+dr[k]*num;
					int nc=j+dc[k]*num;
					
					if(!valid(nr,nc)) continue;
					
					dp[nr][nc]+=dp[i][j];
				}
			}
		}
    	
    	System.out.println(dp[N-1][N-1]);
    }

    public static boolean valid(int i, int j) {
    	return i>=0&&i<N&&j>=0&&j<N;
    }
    
}