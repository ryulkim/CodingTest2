import java.io.*;
import java.util.*;

public class Main {

	static int N, ans=0;
	static PriorityQueue<Integer> left, right;

    public static void main(String[] args) throws Exception {
    	init();
//    	proc();
    }

    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	StringBuilder sb=new StringBuilder();
    	left=new PriorityQueue<>((a,b)->Integer.compare(b, a));
    	right=new PriorityQueue<>((a,b)->Integer.compare(a, b));
    	
    	for (int i = 1; i <= N; i++) {
			int x=Integer.parseInt(br.readLine());
			if(left.isEmpty()||left.peek()>=x) {
				left.add(x);
				if(left.size()>(i+1)/2) {
					right.add(left.poll());
				}
			}
			else {
				right.add(x);
				if(right.size()>i/2) {
					left.add(right.poll());
				}
			}
			
			sb.append(left.peek())
				.append("\n");
		}
    	
    	System.out.println(sb);
    }
    
    public static void proc() {
    }
    
}
