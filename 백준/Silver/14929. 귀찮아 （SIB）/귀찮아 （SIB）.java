import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] arr, cnt;
	
    public static void main(String[] args) throws Exception {
    	init();
    	proc();
    }
        
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N+1];
    	cnt=new int[N+1];
    	
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	for (int i = 1; i <= N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
    	
    }
    
    public static void proc() {
    	for (int i = 1; i <= N; i++) {
			cnt[i]=cnt[i-1]+arr[i];
		}
    	
    	long sum=0;
    	
    	for (int i = 1; i <= N; i++) {
    		sum+=(cnt[N]-cnt[i])*arr[i];
		}
    	
    	System.out.println(sum);
    }
    
}
