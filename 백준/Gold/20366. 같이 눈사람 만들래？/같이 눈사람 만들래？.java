import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] arr;
	static long min=Long.MAX_VALUE;
	
    public static void main(String[] args) throws Exception {
    	init();
    	proc();
    }
        
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N];
    	
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
    	
    	Arrays.sort(arr);
    }
    
    public static void proc() {
    	for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				long sum=arr[i]+arr[j];
				pointer(sum, i, j);
			}
		}
    	
    	System.out.println(min);
    }
    
    public static void pointer(long target, int i, int j) {
    	int f=0,l=N-1;
    	
    	while(f<l) {
    		if(f==i || f==j) {
    			f++; continue;
    		}
    		if(l==i || l==j) {
    			l--; continue;
    		}
    		
    		long sum=arr[f]+arr[l];
    		min=Math.min(min, Math.abs(target-sum));
    		
    		if(sum==target) {
    			return;
    		}
    		else if(sum<target) {
    			f++;
    		}
    		else {
    			l--;
    		}
    	}
    }
}
