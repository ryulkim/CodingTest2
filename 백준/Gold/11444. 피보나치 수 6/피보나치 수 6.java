import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static long N;
	static long[][] basic;
	static final int MOD=1000_000_007;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	
    	init();
    	
    	long[][] ans=proc(N);
    	System.out.println(ans[0][1]);
        
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Long.parseLong(br.readLine());
    	basic=new long[][] {{1,1},{1,0}};
    }
    
    public static long[][] proc(long n) {
    	if(n==1) return basic;
    	
    	long[][] half=proc(n/2);
    	long[][] ret=multiply(half, half);
    	
    	if(n%2==1) {
    		ret=multiply(ret, basic);
    	}
    	
    	return ret;
    }
    
    public static long[][] multiply(long[][] a, long[][] b) {
    	long[][] ans=new long[2][2];
    	
    	ans[0][0]=mod(a[0][0]*b[0][0]+a[1][0]*b[0][1]);
    	ans[0][1]=mod(a[0][0]*b[0][1]+a[1][0]*b[1][1]);
    	ans[1][0]=mod(a[1][0]*b[0][0]+a[1][1]*b[1][0]);
    	ans[1][1]=mod(a[1][0]*b[0][1]+a[1][1]*b[1][1]);
    	
    	return ans;
    }
    
    public static long mod(long value) {
    	return value%MOD;
    }
    
}