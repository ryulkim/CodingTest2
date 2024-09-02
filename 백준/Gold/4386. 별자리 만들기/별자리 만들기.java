import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 시간: 560ms	메모리: 50,176KB */


class Main {
	public static int N;
	public static double X, Y;
	public static int[] parents;
	public static Edges[] graph; 
	public static V[] vertexs;
	
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
		
		N=Integer.parseInt(br.readLine());
		parents=new int[N+1];
		vertexs=new V[N];
		graph=new Edges[(N-1)*(N)/2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			X=Double.parseDouble(st.nextToken());
			Y=Double.parseDouble(st.nextToken());
			
			vertexs[i]=new V(X,Y);
		}
		int num=0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				double width=Math.abs(vertexs[i].c-vertexs[j].c);
				double height=Math.abs(vertexs[i].r-vertexs[j].r);
				
				graph[num++]=new Edges(i,j,(Math.sqrt(Math.pow(width, 2)+Math.pow(height, 2))));
			}
			
		}
		
		Arrays.sort(graph);
		
		makeSet();
		
		int cnt=0;
		double cost=0;
		for (Edges e : graph) {
			if(union(e.from, e.to)) {
				cost+=e.weight;
				cnt++;
				if(cnt==N-1) {
					break;
				}
			}
		}
		System.out.println(Math.round(cost*100)/100.0);
	}
	
	public static void makeSet() {
		for (int i = 1; i <= N; i++) {
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