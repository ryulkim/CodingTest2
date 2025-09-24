import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static long ans=0;
	static int[] trip, ticket, cost, ic, cnt;
	
    public static void main(String[] args) throws Exception {
    	init();
    	proc();
    	System.out.println(ans);
    }
        
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	
    	st=new StringTokenizer(br.readLine());
    	trip=new int[M];
    	ticket=new int[N]; cost=new int[N]; ic=new int[N]; cnt=new int[N+1];
    	for (int i = 0; i < M; i++) {
    		trip[i]=Integer.parseInt(st.nextToken());
		}
    	
    	for (int i = 1; i < N; i++) {
    		st=new StringTokenizer(br.readLine());
    		int a=Integer.parseInt(st.nextToken());
    		int b=Integer.parseInt(st.nextToken());
    		int c=Integer.parseInt(st.nextToken());
    		
    		ticket[i]=a;
    		cost[i]=b;
    		ic[i]=c;
		}
    }
    
    public static void proc() {
    	for (int i = 0; i < M-1; i++) {
			int from=Math.min(trip[i], trip[i+1]);
			int to=Math.max(trip[i], trip[i+1]);
			cnt[from]++; cnt[to]--;
		}
    	
    	for (int i = 1; i < N; i++) {
			cnt[i]+=cnt[i-1];
			ans+=Math.min(ticket[i]*cnt[i], ic[i]+cost[i]*cnt[i]);
		}
    }
    
    
}
