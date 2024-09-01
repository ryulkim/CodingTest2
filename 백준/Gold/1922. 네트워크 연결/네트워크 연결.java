import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 시간: 560ms	메모리: 50,176KB */


class Main
{
	public static int V, E, A, B, C;
	public static int[] parents;
	public static Edges[] graph; 
	
	static class Edges implements Comparable<Edges>{
		int from, to, weight;

		public Edges(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edges o) {
			return this.weight-o.weight;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
//		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		V=Integer.parseInt(br.readLine());
		E=Integer.parseInt(br.readLine());
		parents=new int[V+1];
		graph=new Edges[E];
		
		for (int i = 0; i < E; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			A=Integer.parseInt(st.nextToken());
			B=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			
			graph[i]=new Edges(A,B,C);
		}
		
		Arrays.sort(graph);
		
		makeSet();
		
		int cnt=0, cost=0;
		for (Edges e : graph) {
			if(union(e.from, e.to)) {
				cost+=e.weight;
				cnt++;
				if(cnt==V-1) {
					break;
				}
			}
		}
		System.out.println(cost);
	}
	
	public static void makeSet() {
		for (int i = 1; i <= V; i++) {
			parents[i]=i;
		}
	}
	
	public static boolean union(int a, int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		
		if(aRoot==bRoot) return false;
		
		parents[bRoot]=aRoot;
		
		return true;
	}
	
	public static int find(int num) {
		if(parents[num]==num) return num;
		return parents[num]=find(parents[num]);
	}
}