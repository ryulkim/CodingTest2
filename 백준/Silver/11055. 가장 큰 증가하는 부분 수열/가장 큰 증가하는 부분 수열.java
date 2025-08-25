import java.io.*;
import java.util.*;

public class Main {

	static int N, ans=0;
	static ArrayList<Integer> arr;
	static int[] dp;

    public static void main(String[] args) throws Exception {
    	init();
    	proc();
    }

    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
//    	StringBuilder sb=new StringBuilder();
    	dp=new int[N];
    	arr=new ArrayList<Integer>();
    	
        StringTokenizer st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		int x=Integer.parseInt(st.nextToken());
    		arr.add(x);
		}
    }
    
    public static void proc() {
    	for (int i = 0; i < N; i++) {
    		dp[i]=arr.get(i);
    		ans=Math.max(arr.get(i), ans);
			for (int j = 0; j < i; j++) {
				if(arr.get(i)>arr.get(j)) {
					dp[i]=Math.max(dp[j]+arr.get(i), dp[i]);
					ans=Math.max(ans, dp[i]);
				}
			}
		}
    	
    	System.out.println(ans);
    }
    
}
