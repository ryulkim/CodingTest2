import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] arr;
	static long[][] dp;

    public static void main(String[] args) throws IOException {
    	init();
    	proc();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	arr=new int[N];
    	dp=new long[N+1][21];
    	
    	for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
    }
    
    public static void proc() {
    	dp[1][arr[0]]=1;
    	
    	for (int i = 1; i < N-1; i++) {
    		int num=arr[i];
			for (int j = 0; j <= 20; j++) {
				int value=j+num;
				if(value<=20) dp[i+1][value]+=dp[i][j];
				value=j-num;
				if(value>=0) dp[i+1][value]+=dp[i][j];
			}
		}
    	
    	System.out.println(dp[N-1][arr[N-1]]);
    }

    
    
}