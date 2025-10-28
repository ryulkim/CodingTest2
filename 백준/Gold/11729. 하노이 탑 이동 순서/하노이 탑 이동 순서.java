import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K, num=0;
	static int[] arr;

    public static void main(String[] args) throws IOException {
    	StringBuilder sb=new StringBuilder();
    	
    	init();
    	proc(N,1,3,sb);
    	
    	System.out.println(num);
    	System.out.println(sb);
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    }
    
    // 1->2,1->3, 2->1,2->3, 
    public static void proc(int n, int cur, int target, StringBuilder sb) {
    	if(n==0) return;
    	
    	num++;
    	proc(n-1,cur,6-cur-target,sb);
    	sb.append(cur).append(" ").append(target).append("\n");
    	proc(n-1,6-cur-target,target,sb);
    }
    
}
