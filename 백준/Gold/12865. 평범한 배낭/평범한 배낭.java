import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

/*
 * 시간: 1000ms	메모리: 144,204KB
 */
public class Main {
	
	static int N, K, V, W, ans=0;
	static ArrayList<Node> prod;
//	static int[] dp;
	static Map<Integer, Integer> dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		dp=new TreeMap<Integer, Integer>(Collections.reverseOrder());
		prod=new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			V=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			prod.add(new Node(V,W));
		}
		
		for (Node node: prod) {
			Set<Integer> entries=new TreeSet<>(Collections.reverseOrder());
			entries.addAll(dp.keySet());
			
			int nw=node.weight;
			int nv=node.value;
			
			if(nw>K) continue;
			
			for(Integer key: entries) {
				Integer num=dp.get(key);
				int tw=key+node.weight;
				int tv=num+node.value;
				
				if(tw>K) continue;
				ans=Math.max(ans, tv);
				if(dp.get(tw)==null) dp.put(tw, tv);
				else {
					if(dp.get(tw)<tv) {
						dp.put(tw, tv);
					}
				}
			}
			
			if((dp.get(nw)==null||dp.get(nw)<nv)) {
				dp.put(nw, nv);
				ans=Math.max(ans, nv);
			}
		}
		
		System.out.println(ans);
		
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

