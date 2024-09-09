import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 시간: 760ms	메모리: 108,744KB
 */
public class Main {
	
	static int V, E, X, u, v, w, ans;
	static ArrayList<Node>[] graph;
	static int distance[][];
	static boolean visited[];
	static int INF=Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
		graph=new ArrayList[V+1];
		distance=new int[V+1][V+1];
		ans=0;
		
		for (int i = 0; i <= V; i++) {
			graph[i]=new ArrayList<>();
		}
		
		for (int i = 0; i <= V; i++) {
			for (int j = 0; j <= V; j++) {
				if(i!=j) distance[i][j]=INF;
			}
		}
		
		for (int i = 0; i < E; i++) {
			st=new StringTokenizer(br.readLine());
			u=Integer.parseInt(st.nextToken());
			v=Integer.parseInt(st.nextToken());
			w=Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v,w));
		}
		
		for (int i = 1; i <= V; i++) {
			djik(i);
		}
		
		for (int i = 0; i <= V ; i++) {
			if(i==X) continue;
			ans=Math.max(distance[i][X]+distance[X][i], ans);
		}
		
		System.out.println(ans);
		
	}
	
	public static void djik(int start) {
		PriorityQueue<Vertex> q=new PriorityQueue<>();
		q.add(new Vertex(0,start));
		distance[start][start]=0;
		visited=new boolean[V+1];
		
		while(!q.isEmpty()) {
			Vertex v=q.poll();
			int num=v.node;
			int weight=v.weight;
			int sz=graph[num].size();
			int value=distance[start][num];
			
			if(visited[num]) continue;
			visited[num]=true;
			
			for (int i = 0; i < sz; i++) {
				Node to=graph[num].get(i);
				if(distance[start][to.v]>to.weight+value) {
					distance[start][to.v]=to.weight+value;
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

