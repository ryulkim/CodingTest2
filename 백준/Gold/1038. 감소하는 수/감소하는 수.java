import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static PriorityQueue<Long> pq;

    public static void main(String[] args) throws IOException {
    	init();
    	System.out.println(proc());
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	pq=new PriorityQueue<>();
    }
    
    public static long proc() {
    	if(N>=1023) return -1;
    	for (int i = 0; i <= 9; i++) {
			dfs(i);
		}
    	
    	int num=0;
    	while(!pq.isEmpty()) {
    		long value=pq.poll();
    		if(num==N) {
    			return value;
    		}
    		num++;
    	}
    	
    	return -1;
    }
    
    public static void dfs(long num) {
    	long value=num*10;
    	int idx=(int) num%10;
    	pq.add(num);
    	
    	for (int i = 0; i < idx; i++) {
			dfs(value+i);
		}
    }
}
