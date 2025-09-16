import java.io.*;
import java.util.*;

public class Main {

	static int N, K, X, Q, L, R;
	static long[] cnt;
	static HashMap<Integer, Integer> hm;
	
    public static void main(String[] args) throws Exception {
    	init();
    }
        
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	K=Integer.parseInt(st.nextToken());
    	hm=new HashMap<>();
    	cnt=new long[N+1];
    	
    	st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < K; i++) {
    		int x=Integer.parseInt(st.nextToken());
    		hm.put(x, hm.getOrDefault(x, 0)+1);
		}
    	
    	proc();
    	
    	Q=Integer.parseInt(br.readLine());
    	for (int i = 0; i < Q; i++) {
			st=new StringTokenizer(br.readLine());
			L=Integer.parseInt(st.nextToken());
			R=Integer.parseInt(st.nextToken());
			if(L>0) {
				sb.append(cnt[R]-cnt[L-1]).append('\n');
			}
			else {
				sb.append(cnt[R]).append('\n');
			}
		}
    	
    	System.out.println(sb);
    	
    }
    
    public static void proc() {
    	for(Map.Entry<Integer, Integer> info: hm.entrySet()) {
    		int key=info.getKey();
    		int value=info.getValue();
    		int i=0;
    		
    		while(i<=N) {
    			cnt[i]+=value;
    			i+=key;
    		}
    	}
    	
    	for (int i = 1; i <= N; i++) {
			cnt[i]+=cnt[i-1];
		}
    }
}
