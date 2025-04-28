import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	static int N, M; 
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
        
    	long ans=proc();
        
        System.out.println(ans);
        
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	arr=new int[N];
    	
    	st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		arr[i]=Integer.parseInt(st.nextToken());
		}
    }
    
    public static long proc() {
    	long first=0;
    	long last=1000_000_000;
    	long mid=(first+last)/2;
    	long ans=0;
    	
    	while(first<=last) {
    		mid=(first+last)/2;
    		long sum=0;
    		
    		for (int i = 0; i < N; i++) {
    			if(arr[i]<mid) continue;
				sum+=arr[i]-mid;
			}
    		
    		if(sum==M) {
    			ans=Math.max(ans, mid);
    			break;
    		}
    		if(sum>M) {
    			ans=Math.max(ans, mid);
    			first=ans+1;
    		}
    		else {
    			last=mid-1;
    		}
    	}
    	
    	return ans;
    }
    
    
}