import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

/*
 * 시간: 952ms	메모리: 178,016KB
 */
public class Main {
	
	static int N, K, V, ans=0;
	static int[] dp; //dp[i]: i 가격일 때 가능한 동전 최소 개수
	static int INF=Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		dp=new int[K+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0]=0;
		
		
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			V=Integer.parseInt(st.nextToken());
			
			for (int j = 0; j <= K; j++) {
				if(dp[j]==INF) continue;
				int price=j+V;
				
				if(price>K) continue;
				
				int count=dp[j];
				dp[price]=Math.min(dp[price], count+1);
			}
		}
		
		System.out.println(dp[K]==INF?-1:dp[K]);
		
		
	}
	
	public static class Node{
		int weight, value;

		public Node(int weight, int value) {
			super();
			this.weight = weight;
			this.value = value;
		}
	}
}

