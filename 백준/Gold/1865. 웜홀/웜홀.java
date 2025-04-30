import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge{
		int s,e,t;

		public Edge(int s, int e, int t) {
			super();
			this.s = s;
			this.e = e;
			this.t = t;
		}
	}
	
	static int tc, N, M, W;
	static int[] graph;
	static Edge[] edges;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	tc=Integer.parseInt(br.readLine());
    	
    	for (int testCase = 0; testCase < tc; testCase++) {
        	init(br);
        	
        	System.out.println(proc()?"YES":"NO");        	
		}
    	
    	
        
    }
    
    public static void chk() {
    	System.out.println(tc);
    	System.out.println(N+" "+M+" "+W);
    }
    
    public static void init(BufferedReader br) throws IOException {
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	W=Integer.parseInt(st.nextToken());
    	
//    	chk();
    	
    	
    	graph=new int[N+1];
    	edges=new Edge[2*M+W];
    	
    	Arrays.fill(graph, 1000_000_000);
    	
    	graph[1]=0;
    	
    	int idx=0;
    	
    	for (int i = 0; i < M; i++) {
    		st=new StringTokenizer(br.readLine());
    		int s=Integer.parseInt(st.nextToken());
    		int e=Integer.parseInt(st.nextToken());
    		int t=Integer.parseInt(st.nextToken());
    		
    		edges[idx++]=new Edge(s,e,t);
    		edges[idx++]=new Edge(e,s,t);
		}
    	
    	for (int i = M; i < M+W; i++) {
    		st=new StringTokenizer(br.readLine());
    		int s=Integer.parseInt(st.nextToken());
    		int e=Integer.parseInt(st.nextToken());
    		int t=Integer.parseInt(st.nextToken());
    		
    		edges[idx++]=new Edge(s,e,-t);
		}
    }
    
    public static boolean proc() {
    	for (int i = 0; i < N; i++) {
			for (Edge edge : edges) {
				if(graph[edge.e]>graph[edge.s]+edge.t) {
					graph[edge.e]=graph[edge.s]+edge.t;
					
					if(i==N-1) {
						return true;
					}
				}
			}
		}
    	
    	return false;
    }
    
    
}