import java.io.*;
import java.util.*;

public class Main {
	
	static int N, cnt=0, MAX=10_000_000;
	static int[] arr, dp;

    public static void main(String[] args) throws IOException {
    	init();
    	proc();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    }
    
    public static void proc() {
    	int f=1,l=1;
    	int sum=1;
    	
    	while(l<=MAX) {
    		if(sum==N) {
    			cnt++;
    			sum-=f++;
    		}
    		else if(sum>N) {
    			sum-=f++;
    		}
    		else {
    			sum+=++l;
    		}
    	}
    	
    	System.out.println(cnt);
    }
    
}
