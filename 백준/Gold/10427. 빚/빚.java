import java.io.*;
import java.util.*;

public class Main {

	static int T, N;
	static int[] arr;
	static long[] sum, gop;
	
    public static void main(String[] args) throws Exception {
    	init();
    }
        
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	T=Integer.parseInt(br.readLine());
    	
    	for (int testCase = 0; testCase < T; testCase++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		N=Integer.parseInt(st.nextToken());
    		arr=new int[N];
    		sum=new long[N+1];
    		gop=new long[N+1];
    		gop[0]=1;
			
    		for (int i = 0; i < N; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
    		
    		Arrays.sort(arr);
    		prefixSum();
    		sb.append(proc()).append('\n');
		}
    	
    	System.out.println(sb);
    	
    }
    
    public static void prefixSum() {
    	for (int i = 0; i < N; i++) {
			sum[i+1]=sum[i]+arr[i];
			gop[i+1]=gop[i]*arr[i];
		}
    }
    
    public static long proc() {
    	long ans=0;
    	for (int i = 1; i <= N; i++) {
    		long min=Long.MAX_VALUE;
			for (int j = 1; j <= N-i+1; j++) {
				long hap=sum[j+i-1]-sum[j-1];
				min=Math.min(min, arr[j+i-2]*i-hap);
			}
			ans+=min;
		}
    	return ans;
    }
    
    
}
