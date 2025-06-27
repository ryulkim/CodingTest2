import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M, ans=2000_000_000;
	static int[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    	System.out.println(ans);
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	arr=new int[N];
    	
    	for (int i = 0; i < N; i++) {
			int num=Integer.parseInt(br.readLine());
			arr[i]=num;
		}
    	
    	Arrays.sort(arr);
    }

    public static void proc() {
    	int start=0, end=start+1;
    	
    	if(M==0) {
    		ans=0;
    	}
    	
    	while(end<N){
    		int diff=arr[end]-arr[start];
    		if(diff>=M) {
    			ans=Math.min(ans, diff);
    			start++;
    		}
    		else {
    			end++;
    		}
    		if(start==end) {
    			end++;
    		}
    	}
    }
    
}