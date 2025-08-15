import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static ArrayDeque<Integer> q;

    public static void main(String[] args) throws Exception {
        init();
        proc();
    }

    public static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());        
        q = new ArrayDeque<>();
        
        for (int i = 1; i <= N; i++) {
			q.add(i);
		}
    }

    public static void proc() {
    	StringBuilder sb=new StringBuilder();
    	sb.append("<");
		
    	while(q.size()>1) {
    		for (int i = 1; i < K; i++) {
    			q.addLast(q.pollFirst());
    		}
    		sb.append(q.poll());
    		sb.append(", ");
    	}
    	sb.append(q.poll());
    	sb.append(">");
    	
    	System.out.println(sb);
	}

}
