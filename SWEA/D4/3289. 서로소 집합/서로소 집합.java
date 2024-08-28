import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 시간: 195ms	메모리: 29,532KB
 */
public class Solution {
	
	public static int T, N, M, A, B;
	public static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		T=Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			parents=new int[N+1];
			makeSet();
			sb.append("#"+testCase+" ");
			
			for (int i = 0; i < M; i++) {
				st=new StringTokenizer(br.readLine()," ");
				int oper=Integer.parseInt(st.nextToken());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				
				if(oper==0) {
					union(a,b);
				}
				else {
					sb.append(include(a,b));
				}
			}
			
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	public static void makeSet() {
		for (int i = 1; i <= N; i++) {
			parents[i]=i;
		}
	}
	
	public static void union(int a, int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		
		if(aRoot==bRoot) return;
		
		parents[bRoot]=aRoot;
	}
	
	public static int include(int a, int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		
		if(aRoot==bRoot) return 1;
		return 0;
	}
	
	
	
	public static int find(int num) {
		if(parents[num]==num) {
			return num;
		}
		return parents[num]=find(parents[num]);
	}
	
	
}


