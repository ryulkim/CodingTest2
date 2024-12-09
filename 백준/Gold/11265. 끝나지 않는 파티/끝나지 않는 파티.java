import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N,M,A,B,C;
    public static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        graph=new int[N][N];
        
        for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
			}
		}
        
        for (int k = 0; k < N; k++) {
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < N; j++) {
        			graph[i][j]=Math.min(graph[i][j], graph[i][k]+graph[k][j]);
        		}
        	}
		}
        
        for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			A=Integer.parseInt(st.nextToken())-1;
			B=Integer.parseInt(st.nextToken())-1;
			C=Integer.parseInt(st.nextToken());
			
			if(graph[A][B]<=C) {
				System.out.println("Enjoy other party");
			}
			else {
				System.out.println("Stay here");
			}
		}
    }
}