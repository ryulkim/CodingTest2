import java.io.*;
import java.util.*;

public class Main {
	
	static int T, K;
	static int[] arr;
	static PriorityQueue<Long> pq;
	
    public static void main(String[] args) throws IOException {
    	init();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	T=Integer.parseInt(br.readLine());
    	pq=new PriorityQueue<>();
    	
    	for (int testCase = 0; testCase < T; testCase++) {
			K=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine());

			pq.clear();
			
			for (int i = 0; i < K; i++) {
				pq.add((long) Integer.parseInt(st.nextToken()));
			}
			
			System.out.println(proc());
		}
    }
    
    public static long proc() {
    	long ans=0;
    	
    	while(pq.size()>=2) {
    		long num1=pq.poll();
    		long num2=pq.poll();
    		long sum=num1+num2;
    		ans+=sum;
    		
    		pq.add(sum);
    	}
    	
    	return ans;
    }
   
  
}