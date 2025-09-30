import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static long K, ans=0;
	static long[] arr, sum;
	static HashMap<Long, Integer> hm;
	
    public static void main(String[] args) throws Exception {
    	init();
    }
        
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N=Integer.parseInt(st.nextToken());
    	K=Integer.parseInt(st.nextToken());
    	hm=new HashMap<>();
    	arr=new long[N+1];
    	sum=new long[N+1];
    	
    	
    	st = new StringTokenizer(br.readLine());
    	for (int i = 1; i <= N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			sum[i]=(sum[i-1]+arr[i]);
		}
    	
    	for (int i = 0; i <= N; i++) {
    		long key=sum[i]-(long) K*i;
    		int value=hm.getOrDefault(key, 0);
			ans+=value;
			hm.put(key, value+1);
		}
    	
    	System.out.println(ans);
    	
    }
    
}
