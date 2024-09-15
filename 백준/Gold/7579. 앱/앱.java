import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

/*
 * 시간: 952ms	메모리: 178,016KB
 */
public class Main {
	
	static int N, K, V, W, ans=Integer.MAX_VALUE;
	static ArrayList<Node> prod;
	static ArrayList<Integer> app, cost;
//	static int[] dp;
	static Map<Integer, Integer> dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		app=new ArrayList<>();
		cost=new ArrayList<>();
		
		dp=new TreeMap<Integer, Integer>(Collections.reverseOrder());
		prod=new ArrayList<>();
		
		st=new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			app.add(Integer.parseInt(st.nextToken()));
		}
		
		st=new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			cost.add(Integer.parseInt(st.nextToken()));
		}
		
		
		for (int i = 0; i < N; i++) {
			prod.add(new Node(cost.get(i),app.get(i)));
		}
		
		for (Node node: prod) {
			Set<Integer> entries=new TreeSet<>(Collections.reverseOrder());
			entries.addAll(dp.keySet());
			
			int nc=node.cost;
			int nm=node.memory;
			
			if(ans<=nc) {
				continue;
			}
			
			for(Integer key: entries) {
				Integer num=dp.get(key);
				int tc=key+nc;
				int tm=num+nm;
				
				if(ans<=tc) continue;
				if(tm>=K) {
					ans=Math.min(ans, tc);
				}
				
				if(dp.get(tc)==null) dp.put(tc, tm);
				else {
					if(dp.get(tc)<tm) {
						dp.put(tc, tm);
					}
				}
			}
			
			if((dp.get(nc)==null||dp.get(nc)<nm)) {
				dp.put(nc, nm);
				if(nm>=K) ans=Math.min(ans, nc);
			}
		}
		
		System.out.println(ans);
		
	}
	
	public static class Node{
		int cost, memory;
		
		public Node(int cost, int memory) {
			super();
			this.cost = cost;
			this.memory = memory;
		}
	}
}

