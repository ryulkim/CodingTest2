import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 시간: 560ms	메모리: 50,176KB */


class Solution
{
	public static int T, N, M, C, ans;
	public static int[][] graph;
	
	static class V implements Comparable<V>{
		int sum, value;

		public V(int sum, int value) {
			super();
			this.sum = sum;
			this.value = value;
		}

		@Override
		public int compareTo(V o) {
			if(this.value==o.value) return o.sum-this.sum;
			return o.value-this.value;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			graph=new int[N][N];
			ans=0;
			
			for (int i = 0; i < N; i++) {
				st=new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					graph[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			proc(0,0,0,0);
			
			System.out.println("#"+testCase+" "+ans);
			
		}
		
	}
	
	public static void proc(int depth, int si, int sj, int sum) {
		if(depth==2) {
			if(ans<sum) ans=sum;
			return;
		}
		for (int i = si; i < N; i++) {
			for (int j = sj; j <= N-M; j++) {
				ArrayList<V> temp=new ArrayList<>();
				
				for (int k = 0; k < M; k++) {
					int sz=temp.size();
					for (int idx = 0; idx < sz; idx++) {
						int v=(int) (temp.get(idx).value+Math.pow(graph[i][j+k],2));
						int s=temp.get(idx).sum+graph[i][j+k];
						if(s<=C) {
							temp.add(new V(s,v));
						}
					}
					temp.add(new V(graph[i][j+k],(int) Math.pow(graph[i][j+k],2)));
				}
				
				Collections.sort(temp);
				
				proc(depth+1, i, j+M, sum+temp.get(0).value);
			}
			sj=0;
		}
	}
}