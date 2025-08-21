import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] inbound;
	static ArrayList<Integer>[] graph;
	static ArrayDeque<Integer> q;

    public static void main(String[] args) throws Exception {
    	init();
    	proc();
    }

    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        inbound=new int[N+1];
        graph=new ArrayList[N+1];
        q=new ArrayDeque<>();
        
        for (int i = 1; i <= N; i++) {
			graph[i]=new ArrayList<>();
		}
        
        for (int i = 0; i < M; i++) {
        	st=new StringTokenizer(br.readLine());
        	int cnt=Integer.parseInt(st.nextToken());
        	int prev=0;
        	for (int j = 0; j < cnt; j++) {
        		int x=Integer.parseInt(st.nextToken());
        		if(prev==0) {
        			prev=x;
        			continue; 
        		}
    			graph[prev].add(x);
				inbound[x]++;
				prev=x;
			}
		}
    	
        for (int i = 1; i <= N; i++) {
        	if(inbound[i]==0) q.add(i);
		}
    }
    
    public static void proc() {
    	StringBuilder sb=new StringBuilder();
    	ArrayList<Integer> ans=new ArrayList<>();
    	
    	while(!q.isEmpty()) {
    		int num=q.poll();
    		ans.add(num);
    		
    		for (int i = 0; i < graph[num].size(); i++) {
				if(--inbound[graph[num].get(i)]==0) {
					q.add(graph[num].get(i));
				}
			}
    	}
    	
//    	System.out.println(sb.length());
    	
    	if(ans.size()==N) {
    		for (Integer num : ans) {
				System.out.println(num);
			}
    	}
    	else System.out.println(0);
    }
}
