import java.io.*;
import java.util.*;

public class Main {

	static int T, D, N, X;
	static long[] arr, cnt;
	static HashMap<Long, Integer> hm;
	
    public static void main(String[] args) throws Exception {
    	init();
    }
        
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	T=Integer.parseInt(br.readLine());
    	for (int testCase = 0; testCase < T; testCase++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		D=Integer.parseInt(st.nextToken());
    		N=Integer.parseInt(st.nextToken());
    		arr=new long[N+1];
    		cnt=new long[N+1];
    		hm=new HashMap<>();
    		hm.put(0L, 1);
    		
    		st=new StringTokenizer(br.readLine());
    		
    		int ans=0;
    		for (int i = 1; i <= N; i++) {
				arr[i]=Long.parseLong(st.nextToken());
				cnt[i]=cnt[i-1]+arr[i];
				long diff=cnt[i]%D;
				ans+=hm.getOrDefault(diff, 0);
				hm.put(diff, hm.getOrDefault(diff,0)+1);
			}
    		
    		sb.append(ans).append('\n');
		}
    	
    	System.out.println(sb);
    }
    
}
