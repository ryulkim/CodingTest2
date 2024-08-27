import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 시간: 162ms	메모리: 25,428KB
 */
public class Main {
	
	public static int A, B, N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] graph=new ArrayList[N+1];
		int[] indeg=new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i]=new ArrayList<>();
		}
		
		for (int i = 1; i <= M; i++) {
			st=new StringTokenizer(br.readLine());
			A=Integer.parseInt(st.nextToken());
			B=Integer.parseInt(st.nextToken());
			graph[A].add(B);
			indeg[B]++;
		}
			
		ArrayDeque<Integer> q=new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++) {
			if(indeg[i]==0) q.add(i);
		}
			
		while (!q.isEmpty()){
			int num=q.poll();
			System.out.print(num+" ");
			int sz=graph[num].size();
			
			for (int i = 0; i < sz; i++) {
				int idx=graph[num].get(i);
				indeg[idx]--;
				if(indeg[idx]==0) q.add(idx);
			}
		}	
		
		
		
		
		
	}

}

