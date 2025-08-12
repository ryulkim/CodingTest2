import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M;
	static long[] dp;
	static ArrayList<int[]>[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
		proc();
    }

	public static void init() throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		dp=new long[N+1];
		arr=new ArrayList[N+1];
		
		Arrays.fill(dp, 1000_000_000_000L);
		
		for (int i = 0; i <= N; i++) {
			arr[i]=new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int A=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
			arr[A].add(new int[] {B,i});
			arr[B].add(new int[] {A,i});
		}
	}
	
	public static void proc() {
		PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->Long.compare(a.time, b.time)); // 시간, 현재 지점
		dp[1]=0;
		pq.add(new Node(0,1));
		
		while(!pq.isEmpty()) {
			Node info=pq.poll();
			
			if(info.time>dp[info.pos]) continue;
			if(info.pos==N) break;
			
			for (int i = 0; i < arr[info.pos].size(); i++) {
				int[] nxt=arr[info.pos].get(i); // 다음 지점, 신호 바뀌는 시점
				long wait=(nxt[1]+M-(info.time%M))%M;
				long nextTime=info.time+wait+1;
				
				if(dp[nxt[0]]>nextTime) {
					dp[nxt[0]]=nextTime;
					pq.add(new Node(nextTime, nxt[0]));
				}
			}
		}
		
		System.out.println(dp[N]);
	}
	
	static class Node {
		long time;
		int pos;

		public Node(long time, int pos) {
			super();
			this.time = time;
			this.pos = pos;
		}
	}
}
