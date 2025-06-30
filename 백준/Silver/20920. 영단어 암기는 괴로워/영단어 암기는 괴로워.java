import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node {
	String s;
	int cnt;
	
	public Node(String s, int cnt) {
		super();
		this.s = s;
		this.cnt = cnt;
	}
}

public class Main {

	static int N, M;
	static Map<String, Integer> m;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	m=new HashMap<>();
    	
    	for (int i = 0; i < N; i++) {
			String s=br.readLine();
			m.put(s, m.getOrDefault(s, 0)+1);
		}
    }
    
    public static void proc() {
    	PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->{
    		if(a.cnt==b.cnt&&a.s.length()==b.s.length()) return a.s.compareTo(b.s);
    		if(a.cnt==b.cnt) return Integer.compare(b.s.length(), a.s.length());
    		return Integer.compare(b.cnt, a.cnt);
    	});
    	StringBuilder sb=new StringBuilder();
    	
    	for (String s : m.keySet()) {
    		if(s.length()<M) continue;
			pq.add(new Node(s,m.get(s)));
		}
    	
    	while(!pq.isEmpty()) {
    		Node n=pq.poll();
    		sb.append(n.s);
    		sb.append("\n");
    	}
    	
    	System.out.println(sb);
    }

}