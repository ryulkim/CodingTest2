import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;


public class Main {

	static int T, N;
	static int[] dp;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	T=Integer.parseInt(br.readLine());
    	dp=new int[10001];
    	
    	proc();
    	
    	for (int testCase = 0; testCase < T; testCase++) {
			N=Integer.parseInt(br.readLine());
			sb.append(dp[N]+"\n");
		}
    	
    	System.out.println(sb);
    	
    	
    }
    
    public static void print() {
    	for (int i = 1; i <= 10; i++) {
    		System.out.print(dp[i]+" ");
		}
    	System.out.println();
    }
    
    public static void proc() {
    	dp[0] = 1; // 0을 만드는 방법은 아무것도 안 쓰는 것 1개

    	for (int i = 1; i <= 3; i++) {
    	    for (int j = i; j <= 10000; j++) {
    	        dp[j] += dp[j - i];
    	    }
    	}
    }
    

}