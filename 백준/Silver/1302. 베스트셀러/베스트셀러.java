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
	
	static class Node{
		String s;
		int cnt;

		public Node(String s, int cnt) {
			super();
			this.s = s;
			this.cnt = cnt;
		}
		
		public String getString() {
			return this.s;
		}
		
		public int getCnt() {
			return this.cnt;
		}
	}
	
	static int N;
	static HashMap<String, Integer> hs;
	static PriorityQueue<Node> pq;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
//		proc();
    }
    
	public static void init() throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		hs=new HashMap<>();
		pq=new PriorityQueue<>((a,b)->{
			if(a.getCnt()==b.getCnt()) {
				return a.getString().compareTo(b.getString());
			}
			return Integer.compare(b.getCnt(), a.getCnt());
		});
		
		for (int i = 0; i < N; i++) {
			String s=br.readLine();
			hs.put(s, hs.getOrDefault(s, 0)+1);
		}
		
		for (String key : hs.keySet()) {
			int num=hs.get(key);
			pq.add(new Node(key, num));
		}
		
		System.out.println(pq.poll().getString());
	}

	public static void proc() {
	}
	
}
