import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

    public static int N,M;
    public static long ans=0, last=0;
    public static int[] parents;
    public static boolean flag=true;
    public static Edge[] edges;
    
    

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        parents=new int[N+1];
        edges=new Edge[M];
        
        for (int i = 0; i < N; i++) {
			parents[i]=i;
		}
        
        for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			edges[i]=new Edge(a,b,c);
		}
        
        Arrays.sort(edges);
        
        
        for (Edge edge : edges) {
        	int a=edge.a;
        	int b=edge.b;
        	long c=edge.w;
        	
			if(union(a,b)) {
				ans+=c;
				last=Math.max(last, c);
			}
		}
        
        ans-=last;
        
        System.out.println(ans);
        
    }
    
    private static boolean union(int a, int b) {
    	int aRoot=find(a);
    	int bRoot=find(b);
    	
    	if(aRoot==bRoot) {
    		return false;
    	}
    	parents[bRoot]=aRoot;
    	return true;
    }
    
    private static int find(int num) {
    	if(parents[num]==num) return num;
    	return parents[num]=find(parents[num]);
    }
}

class Edge implements Comparable<Edge>{
	int a, b;
	long w;

	public Edge(int a, int b, long w) {
		super();
		this.a = a;
		this.b = b;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return Long.compare(this.w, o.w);
	}
}