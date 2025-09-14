import java.io.*;
import java.util.*;

public class Main {

	static int N, M, max=-10_000_000;
	static int[][] arr, cnt;
	
    public static void main(String[] args) throws Exception {
    	init();	
    }
    
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	
    	arr=new int[N][M];
    	cnt=new int[100][2];
    	
    	for (int i = 0; i < N; i++) {
    		st=new StringTokenizer(br.readLine());
    		for (int j = 0; j < M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    	
    	proc();
    	
    	for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				for (int col1 = 0; col1 < M; col1++) {
					for (int col2 = col1+1; col2 < M; col2++) {
						int sum=cnt[i][0]+cnt[j][0]+cnt[col1][1]+cnt[col2][1];
						sum-=(arr[i][col1]+arr[i][col2]+arr[j][col1]+arr[j][col2]);
						sum+=(j-i-1)*(col2-col1-1);
						max=Math.max(max, sum);
					}
				}
			}
		}
    	
    	System.out.println(max);
    	
    }
    
    public static void proc() {
    	for (int i = 0; i < N; i++) {
			int sum=0;
			for (int j = 0; j < M; j++) {
				sum+=arr[i][j];
			}
			cnt[i][0]=sum;
		}
    	
    	for (int i = 0; i < M; i++) {
			int sum=0;
			for (int j = 0; j < N; j++) {
				sum+=arr[j][i];
			}
			cnt[i][1]=sum;
		}
    	
    }
    
}
