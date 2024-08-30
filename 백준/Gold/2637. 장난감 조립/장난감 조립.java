import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 시간: 195ms	메모리: 29,532KB
 */
public class Main {
	
	public static int T, N, M, X, Y, K;
	public static ArrayList<V>[] graph;
	public static int[] indegree;
	public static int[][] blocks;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		indegree=new int[N+1];
		blocks=new int[N+1][N+1];
		graph=new ArrayList[N+1];
		
		for (int i = 0; i <= N; i++) {
			graph[i]=new ArrayList<V>();
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			X=Integer.parseInt(st.nextToken());
			Y=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			
			graph[Y].add(new V(X,K));
			indegree[X]++;
		}
		
		ArrayDeque<Integer> q=new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++) {
			if(indegree[i]==0) {
				q.add(i);
				blocks[i][i]=1;
			}
		}
		
		while(!q.isEmpty()) {
			int num=q.poll();

			for (int i = 0; i < graph[num].size(); i++) {
				V v=graph[num].get(i);
				int ingre=v.to;
				int cnt=v.weight;
				indegree[ingre]--;
				if(indegree[ingre]==0) q.add(ingre);
				
				if(cnt!=0) {
					for (int j = 1; j <= N; j++) {
						blocks[ingre][j]+=blocks[num][j]*cnt;
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if(blocks[N][i]!=0) {
				System.out.println(i+" "+blocks[N][i]);
			}
		}
		System.out.println(sb);
	}
	
	static class V{
		int to, weight;

		public V(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
	}
	
}


