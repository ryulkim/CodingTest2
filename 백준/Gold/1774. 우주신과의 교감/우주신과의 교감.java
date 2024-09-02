import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 시간: 112ms	메모리: 14,428KB */


class Main {
	public static int N, M;
	public static int X, Y;
	public static int[] parents;
	public static ArrayList<Edges> graph; 
	public static V[] vertexs;
	public static boolean[][] connect;
	
	static class Edges implements Comparable<Edges>{
		int from, to;
		double weight;

		public Edges(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edges o) {
			return Double.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		parents=new int[N];
		vertexs=new V[N];
		graph=new ArrayList<>();
		int cnt1=0;
		
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			X=Integer.parseInt(st.nextToken());
			Y=Integer.parseInt(st.nextToken());
			
			vertexs[i]=new V(X,Y);
		}
		
		makeSet();
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			X=Integer.parseInt(st.nextToken());
			Y=Integer.parseInt(st.nextToken());
			if(union(X-1,Y-1)) {
				cnt1++;
			}
		}
		int num=0;
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				double width=Math.abs(vertexs[i].c-vertexs[j].c);
				double height=Math.abs(vertexs[i].r-vertexs[j].r);
				
				graph.add(new Edges(i,j,(Math.sqrt(Math.pow(width, 2)+Math.pow(height, 2)))));
			}
			
		}
		
		Collections.sort(graph);
		
		
		int cnt=0;
		double cost=0;
		for (Edges e : graph) {
			if(union(e.from, e.to)) {
				cost+=e.weight;
				cnt++;
				if(cnt==N-cnt1-1) {
					break;
				}
			}
		}
		System.out.printf("%.2f",Math.round(cost*100)/100.00);
	}
	
	public static void makeSet() {
		for (int i = 0; i < N; i++) {
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
	
	static class V{
		double r, c;

		public V(double r, double c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}