import java.io.*;
import java.util.*;

public class Main {

	static int T, N, K, target;
	static int[] costs, times, inbound;
	static ArrayList<Integer>[] info;
	
    public static void main(String[] args) throws Exception {
    	init();	
    	proc();
    }
    
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	
    	T=Integer.parseInt(br.readLine());
    	
    	for (int i = 0; i < T; i++) {
	    	StringTokenizer st=new StringTokenizer(br.readLine());
	    	N=Integer.parseInt(st.nextToken());
	    	K=Integer.parseInt(st.nextToken());
	    	costs=new int[N+1];
	    	times=new int[N+1];
	    	inbound=new int[N+1];
	    	info=new ArrayList[N+1];
	    	
	    	for (int j = 0; j <= N; j++) {
				info[j]=new ArrayList<>();
			}
	    	
	    	st=new StringTokenizer(br.readLine());
	    	for (int j = 0; j < N; j++) {
				costs[j]=Integer.parseInt(st.nextToken());
			}
	    	
	    	for (int j = 0; j < K; j++) {
	    		st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				inbound[b]++;
				info[a].add(b);
			}
	    	
	    	proc();
	    	
	    	target=Integer.parseInt(br.readLine());
	    	sb.append(times[target]+costs[target-1]).append('\n');
	    	
		}
    	
    	System.out.println(sb);
    	
    }
    
    public static void proc() {
    	ArrayDeque<Integer> q=new ArrayDeque();
    	for (int i = 0; i <= N; i++) {
			if(inbound[i]==0) {
				q.add(i);
			}
		}
    	
    	while(!q.isEmpty()) {
    		int num=q.poll();
    		
    		for (int value : info[num]) {
				inbound[value]--;
				times[value]=Math.max(times[value], times[num]+costs[num-1]);
				if(inbound[value]==0) {
					q.add(value);
				}
			}
    	}
    }
    
}
