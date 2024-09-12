import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 시간: 1028ms	메모리: 98,944KB
 */
public class Main {
	
	static int V, E, X, Y, Z, P, u, v, w;
	static ArrayList<Node>[] graph;
	static ArrayList<Integer> middle;
	static long dxy[], dyz[];
	static boolean visited[];
	static long INF=Long.MAX_VALUE, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		graph=new ArrayList[V+1];
		dxy=new long[V+1];
		dyz=new long[V+1];
		ans=INF;
		
		for (int i = 0; i <= V; i++) {
			graph[i]=new ArrayList<>();
		}
		
		Arrays.fill(dxy, INF);
		Arrays.fill(dyz, INF);
		
		for (int i = 0; i < E; i++) {
			st=new StringTokenizer(br.readLine());
			u=Integer.parseInt(st.nextToken());
			v=Integer.parseInt(st.nextToken());
			w=Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v,w));
			graph[v].add(new Node(u,w));
		}
		
		st=new StringTokenizer(br.readLine());
		X=Integer.parseInt(st.nextToken());
		Z=Integer.parseInt(st.nextToken());
		P=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		
		djik(X, dxy);
		djik(Z, dyz);
		
		for (int i = 0; i < P; i++) {
			Y=Integer.parseInt(st.nextToken());
			if(dyz[Y]!=INF&&dxy[Y]!=INF) {
				ans=Math.min(dyz[Y]+dxy[Y], ans);
			}
		}
		
		if(ans==INF) {
			System.out.println(-1);
		}
		else System.out.println(ans);
		
	}
	
	public static void djik(int start, long[] distance) {
		PriorityQueue<Vertex> q=new PriorityQueue<>();
		q.add(new Vertex(0,start));
		distance[start]=0;
		visited=new boolean[V+1];
		
		while(!q.isEmpty()) {
			Vertex v=q.poll();
			int num=v.node;
			long weight=v.weight;
			int sz=graph[num].size();
			long value=distance[num];
			
			if(visited[num]) continue;
			visited[num]=true;
			
			for (int i = 0; i < sz; i++) {
				Node to=graph[num].get(i);

				if(distance[to.v]>to.weight+value) {
					distance[to.v]=to.weight+value;
					q.add(new Vertex(to.weight+value, to.v));
				}
			}
		}
	}
	
	public static class Node{
		int v, weight;

		public Node(int v, int weight) {
			super();
			this.v = v;
			this.weight = weight;
		}
	}
	
	public static class Vertex implements Comparable<Vertex>{
		long weight;
		int node;

		public Vertex(long weight, int node) {
			super();
			this.weight = weight;
			this.node = node;
		}

		@Override
		public int compareTo(Vertex o) {
			return (int) (this.weight-o.weight);
		}
	}
}

