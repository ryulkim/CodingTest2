import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 시간: 120ms	메모리: 20,168KB
 */
public class Main {
	
	static int V, E, K, u, v, w;
	static ArrayList<Node>[] graph;
	static int distance[];
	static boolean visited[];
	static int INF=Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(br.readLine());
		graph=new ArrayList[V+1];
		distance=new int[V+1];
		visited=new boolean[V+1];
		
		for (int i = 0; i <= V; i++) {
			graph[i]=new ArrayList<>();
			distance[i]=INF;
		}
		
		for (int i = 0; i < E; i++) {
			st=new StringTokenizer(br.readLine());
			u=Integer.parseInt(st.nextToken());
			v=Integer.parseInt(st.nextToken());
			w=Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v,w));
		}
		
		PriorityQueue<Vertex> q=new PriorityQueue<>();
		q.add(new Vertex(0,K));
		distance[K]=0;
		
		while(!q.isEmpty()) {
			Vertex v=q.poll();
			int num=v.node;
			int weight=v.weight;
			int sz=graph[num].size();
			int value=distance[num];
			
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
		
		for (int i = 1; i <= V; i++) {
			if(distance[i]==INF) System.out.println("INF");
			else System.out.println(distance[i]);
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
		int weight, node;

		public Vertex(int weight, int node) {
			super();
			this.weight = weight;
			this.node = node;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.weight-o.weight;
		}
	}
}

