import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static long ans=0;
	static int[] arr, sum;
	static HashMap<Integer, Integer> hm;
	
    public static void main(String[] args) throws Exception {
    	init();
    	proc();
    }
        
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	arr=new int[N];
    	sum=new int[N+1];
    	hm=new HashMap<>();
    	
    	st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
    	
    	for (int i = 1; i <= N; i++) {
			sum[i]=(sum[i-1]+arr[i-1]%M)%M;
		}
    	
    }
    
    public static void proc() {
    	for (int i = 0; i <= N; i++) {
    		int value=hm.getOrDefault(sum[i], 0);
    		ans+=value;
			hm.put(sum[i], value+1);
		}
    	
    	System.out.println(ans);
    }
    
    
}
