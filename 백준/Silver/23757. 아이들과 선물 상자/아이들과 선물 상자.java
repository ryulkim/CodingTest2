import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] child;
	static PriorityQueue<Integer> arr;
	
    public static void main(String[] args) throws IOException {
    	init();
    	System.out.println(proc()?1:0);
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	arr=new PriorityQueue<>((a,b)->Integer.compare(b, a));
    	child=new int[M];
    	
    	st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		int num=Integer.parseInt(st.nextToken());
    		arr.add(num);
		}
    	
    	st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < M; i++) {
			int num=Integer.parseInt(st.nextToken());
			child[i]=num;
		}
    }
    
    public static boolean proc() {
    	for(int i=0;i<M;i++) {
    		int num=child[i];
    		int num1=arr.poll();
    		if(num1>=num){
    			arr.add(num1-num);
    		}
    		else {
    			return false;
    		}
    	}
    	
    	return true;
    }   
  
}