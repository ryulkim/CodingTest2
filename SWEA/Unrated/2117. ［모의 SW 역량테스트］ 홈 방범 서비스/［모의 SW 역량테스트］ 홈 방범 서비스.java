import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 시간: 210ms	메모리: 50,888KB */


class Solution
{
	public static int T, N, M, C, ans, benefit, cost;
	public static int[][] graph;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			graph=new int[N][N];
			ans=0;
			
			
			for (int i = 0; i < N; i++) {
				st=new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					graph[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 1; k <= N+1; k++) {
						int num=proc(i,j,k);
						benefit=num*M;
						cost=k*k+(k-1)*(k-1);
						if(benefit<cost) continue;
						ans=Math.max(ans, num);
					}
				}
			}
			
			System.out.println("#"+testCase+" "+ans);
			
		}
		
	}
	
	public static int proc(int r, int c, int k) {
		int sum=0;
		for (int i = r-k+1; i < r+k; i++) {
			for (int j = c-k+1; j < c+k; j++) {
				if(!valid(i,j)) continue;
				int width=Math.abs(i-r);
				int height=Math.abs(j-c);
				if(width+height>=k) continue;
				if(graph[i][j]==1) {
					sum++;
				}
			}
		}
		return sum;
	}
	
	public static boolean valid(int i, int j) {
		return i>=0&&i<N&&j>=0&&j<N;
	}
}