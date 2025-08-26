import java.io.*;
import java.util.*;

public class Main {

	static int N, K, MOD=1_000_000_007;
	static long[] P, rP;

    public static void main(String[] args) throws Exception {
    	init();
    	proc();
    }

    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	K=Integer.parseInt(st.nextToken());
    	StringBuilder sb=new StringBuilder();
    	P=new long[N+1];
    	rP=new long[N+1];
    	
    }
    
    public static void proc() {
    	fact();
    	rP[N]=pow(P[N],MOD-2);
    	rFact();
    	
    	long ans=P[N]*rP[K];
    	ans%=MOD;
    	ans*=rP[N-K];
    	ans%=MOD;
    	System.out.println(ans);
    }
    
    public static void fact() {
    	P[0]=1;
    	
    	for (int i = 1; i <= N; i++) {
			P[i]=P[i-1]*i;
			P[i]%=MOD;
		}
    }
    
    public static void rFact() {
    	for (int i = N; i > 0; i--) {
			rP[i-1]=rP[i]*i;
			rP[i-1]%=MOD;
		}
    }
    
    public static long pow(long a, int exp) {
    	if(exp==0) {
    		return 1;
    	}
    	if(exp==1) {
    		return a;
    	}
    	
    	long v=pow(a, exp/2);
    	long ans=v*v;
    	ans%=MOD;
    	if(exp%2==1) {
    		return (ans*a)%MOD;
    	}
    	return ans;
    }
    
}
