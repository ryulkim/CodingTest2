import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M;
	static int[] inBound;
	static PriorityQueue<Integer> pq;
	static HashMap<Integer, ArrayList<Integer>> next;
	
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
		inBound=new int[N+1];
		pq=new PriorityQueue<>((a,b)->Integer.compare(a, b));
		next=new HashMap<>();
		
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int A=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
			inBound[B]++;
			ArrayList<Integer> arr=next.getOrDefault(A, new ArrayList<>());
			arr.add(B);
			next.put(A, arr);
		}
		
		for (int i = 1; i <= N; i++) {
			if(inBound[i]==0) {
				pq.add(i);
			}
		}
	}

	public static void proc() {
		StringBuilder sb=new StringBuilder();
		
		while(!pq.isEmpty()) {
			int num=pq.poll();
			ArrayList<Integer> arr=next.getOrDefault(num, new ArrayList<>());
			sb.append(num+" ");
			
			for (int i = 0; i < arr.size(); i++) {
				int nxt=arr.get(i);
				if(--inBound[nxt]==0) {
					pq.add(nxt);
				}
			}
		}
		
		System.out.println(sb);
	}
	
}
