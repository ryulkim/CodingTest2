import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 시간: 760ms	메모리: 108,744KB
 */
public class Main {
	
	static int N, K;
	static int distance[];
	static boolean visited[];
	static int INF=Integer.MAX_VALUE;
	static int MAX=100005;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		distance=new int[MAX];
		visited=new boolean[MAX];
		
		for (int i = 0; i <MAX ; i++) {
			distance[i]=INF;
		}
		
		PriorityQueue<Vertex> q=new PriorityQueue<>();
		q.add(new Vertex(0,N));
		distance[N]=0;
		
		while(!q.isEmpty()) {
			Vertex v=q.poll();
			int num=v.node;
			int weight=v.weight;
			
			if(num==K) {
				break;
			}
			
			if(visited[num]) continue;
			visited[num]=true;
			
			//x-1 이동
			if(num-1>=0) {
				int to=num-1;
				if(distance[to]>weight+1) {
					distance[to]=weight+1;
					q.add(new Vertex(weight+1, to));
				}
			}
			if(num+1<MAX) {
				int to=num+1;
				if(distance[to]>weight+1) {
					distance[to]=weight+1;
					q.add(new Vertex(weight+1, to));
				}
			}
			if(num*2<MAX) {
				int to=num*2;
				if(distance[to]>weight) {
					distance[to]=weight;
					q.add(new Vertex(weight, to));
				}
			}
		}
		
		System.out.println(distance[K]);
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

