import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] arr, cnt;
	
    public static void main(String[] args) throws Exception {
    	init();
    	proc();
    }
        
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N+1][N+1];
    	cnt=new int[N+1][N+1];
    	
    	for (int i = 1; i <= N; i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		for (int j = 1; j <= N; j++) {
    			arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    	
    	for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cnt[i][j]=cnt[i][j-1]+cnt[i-1][j]-cnt[i-1][j-1]+arr[i][j];
			}
		}
    }
    
    public static void proc() {
    	int sum=-1000_000_000;
    	
    	for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N-k+1; i++) {
				for (int j = 1; j <= N-k+1; j++) {
					int value=cnt[i+k-1][j+k-1]-cnt[i-1][j+k-1]-cnt[i+k-1][j-1]+cnt[i-1][j-1];
					sum=Math.max(value, sum);
				}
			}
			
		}
    	
    	System.out.println(sum);
    }
}
