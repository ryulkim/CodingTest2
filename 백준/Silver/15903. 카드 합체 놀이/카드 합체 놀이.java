import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static PriorityQueue<Long> pq;
	static long ans=0;
	
    public static void main(String[] args) throws IOException {
    	init();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	pq=new PriorityQueue<>();
    	
    	st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}
    	
    	for (int i = 0; i < M; i++) {
			long num1=pq.poll();
			long num2=pq.poll();
			long value=num1+num2;
			pq.add(value);
			pq.add(value);
		}
    	
    	while(!pq.isEmpty()) {
    		ans+=pq.poll();
    	}
    	
    	System.out.println(ans);
    }
    
}