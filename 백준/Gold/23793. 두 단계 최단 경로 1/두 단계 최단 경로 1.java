import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 시간: 688ms	메모리: 64,324KB
 */
public class Main {
	
	static int V, E, X, Y, Z, u, v, w, ans;
	static ArrayList<Node>[] graph;
	static int dxy[], dyz[], dxz[];
	static boolean visited[];
	static int INF=Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		graph=new ArrayList[V+1];
		dxy=new int[V+1];
		dyz=new int[V+1];
		dxz=new int[V+1];
		ans=0;
		
		for (int i = 0; i <= V; i++) {
			graph[i]=new ArrayList<>();
		}
		
		for (int i = 0; i <= V; i++) {
			dxy[i]=INF;
			dxz[i]=INF;
			dyz[i]=INF;
		}
		
		for (int i = 0; i < E; i++) {
			st=new StringTokenizer(br.readLine());
			u=Integer.parseInt(st.nextToken());
			v=Integer.parseInt(st.nextToken());
			w=Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v,w));
		}
		
		st=new StringTokenizer(br.readLine());
		X=Integer.parseInt(st.nextToken());
		Y=Integer.parseInt(st.nextToken());
		Z=Integer.parseInt(st.nextToken());
		
		djik(X, dxy, false);
		djik(Y, dyz, false);
		djik(X, dxz, true);
		
		if(dxy[Y]==INF||dyz[Z]==INF) {
			System.out.print(-1+" ");
		}
		else {
			System.out.print(dxy[Y]+dyz[Z]+" ");
		}
		if(dxz[Z]==INF) {
			System.out.println(-1);
		}
		else {
			System.out.println(dxz[Z]);
		}
		
	}
	
	public static void djik(int start, int[] distance, boolean flag) {
		PriorityQueue<Vertex> q=new PriorityQueue<>();
		q.add(new Vertex(0,start));
		distance[start]=0;
		visited=new boolean[V+1];
		
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
				if(flag&&to.v==Y) {
					continue;
				}
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

