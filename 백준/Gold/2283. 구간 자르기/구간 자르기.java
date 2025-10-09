import java.io.*;
import java.util.*;

public class Main {

	static int N, K;
	static int sum;
	static int[] arr, cnt;

	public static void main(String[] args) throws Exception {
    	init();
    	proc();
    }
        
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	K=Integer.parseInt(st.nextToken());
    	arr=new int[1000_002];
    	cnt=new int[1000_002];
    	sum=0;
    	
    	for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			arr[a+1]++;
			arr[b+1]--;
//			sum+=(b-a);
		}
    	
    	cnt[0]=arr[0];
    	
    	for (int i = 1; i <= 1000_000; i++) {
			cnt[i]=cnt[i-1]+arr[i];
		}
    }
    
    public static void proc() {
    	int f=0,l=0;
    	
    	while(l<=1000_000) {
    		if(sum==K) {
    			System.out.println(f+" "+l);
    			return;
    		}
    		else if(sum>K) {
    			sum-=cnt[++f];
    		}
    		else {
    			l++;
    			sum+=cnt[l];
    		}
    	}
    	
    	System.out.println("0 0");
    }
}

/* 7 6 6 6 = 25 */