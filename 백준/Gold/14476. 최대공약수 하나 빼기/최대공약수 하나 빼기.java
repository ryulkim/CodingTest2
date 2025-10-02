import java.io.*;
import java.util.*;

public class Main {

	static int N, ans=-1, ans_s;
	static int[] arr;
	static int[] L, R;
	
    public static void main(String[] args) throws Exception {
    	init();
    }
        
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N+1];
    	L=new int[N+1];
    	R=new int[N+1];
    	L[0]=1;

    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 1; i <= N; i++) {
    		int x=Integer.parseInt(st.nextToken());
    		arr[i]=x;
		}
    	
    	L[1]=arr[1];
    	for (int i = 2; i <= N; i++) {
    		int a=Math.max(L[i-1], arr[i]);
    		int b=Math.min(L[i-1], arr[i]);
			L[i]=gcd(a, b);
		}
    	
    	R[N]=arr[N];
    	for (int i = N-1; i > 0; i--) {
    		int a=Math.max(R[i+1], arr[i]);
    		int b=Math.min(R[i+1], arr[i]);
			R[i]=gcd(a, b);
		}
    	
    	proc();
    	
    	if(ans==-1) {
    		System.out.println(ans);    		
    	}
    	else {
    		System.out.println(ans+" "+ans_s);
    	}
    }
    
    
    public static void proc() {
    	for (int i = 2; i < N; i++) {
    		int a=Math.max(L[i-1], R[i+1]);
    		int b=Math.min(L[i-1], R[i+1]);
			int value=gcd(a,b);
			if(arr[i]%value!=0) {
				ans=Math.max(ans, value);
				ans_s=arr[i];
			}
		}
    	
    	int value=R[2];
    	if(arr[1]%value!=0) {
			ans=Math.max(ans, value);
			ans_s=arr[1];
		}
    	
    	value=L[N-1];
    	if(arr[N]%value!=0) {
			ans=Math.max(ans, value);
			ans_s=arr[N];
		}
    }
    
    public static int gcd(int a, int b) {
    	while(b!=0) {
    		int temp=a%b;
    		a=b;
    		b=temp;
    	}
    	return a;
    }
    
}
