import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static long N;
	static long[][] BASIC={{1,1},{1,0}};
	static final int MOD=1000_000_007;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	
    	init();
    	
    	long[][] ans=proc(N);
    	System.out.println(ans[0][1]);
        
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Long.parseLong(br.readLine());
    }
    
    public static long[][] proc(long n) {
    	if(n==1) return BASIC;
    	
    	long[][] half=proc(n/2);
    	long[][] ret=multiply(half, half);
    	
    	if(n%2==1) {
    		ret=multiply(ret, BASIC);
    	}
    	
    	return ret;
    }
    
    public static long[][] multiply(long[][] a, long[][] b) {
    	long[][] res = new long[2][2];

        res[0][0] = (a[0][0]*b[0][0] + a[0][1]*b[1][0]) % MOD;
        res[0][1] = (a[0][0]*b[0][1] + a[0][1]*b[1][1]) % MOD;
        res[1][0] = (a[1][0]*b[0][0] + a[1][1]*b[1][0]) % MOD;
        res[1][1] = (a[1][0]*b[0][1] + a[1][1]*b[1][1]) % MOD;

        return res;
    }
   
}