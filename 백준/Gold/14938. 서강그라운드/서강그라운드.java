import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static int N, M, R, T, A, B, L, ans=0;
	static int[][] graph;
	static int[] dist;
	

    public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	R=Integer.parseInt(st.nextToken());
    	dist=new int[N];
    	graph=new int[N][N];
    	
    	st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		dist[i]=Integer.parseInt(st.nextToken());
    		Arrays.fill(graph[i], 1000000);
    		graph[i][i]=0;
		}
    	
    	for (int i = 0; i < R; i++) {
    		st=new StringTokenizer(br.readLine());
    		A=Integer.parseInt(st.nextToken())-1;
    		B=Integer.parseInt(st.nextToken())-1;
    		L=Integer.parseInt(st.nextToken());
    		
			graph[A][B]=L;
			graph[B][A]=L;
		}
    	
    	for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					graph[i][j]=Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
		}
    	
    	for (int i = 0; i < N; i++) {
    		int sum=0;
			for (int j = 0; j < N; j++) {
				if(graph[i][j]<=M) {
					sum+=dist[j];
				}
			}
			ans=Math.max(ans, sum);
		}
    	
    	System.out.println(ans);
    }
}
