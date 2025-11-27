import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static long[] arr;
	static long ans=0;
	
    public static void main(String[] args) throws IOException {
    	init();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	arr=new long[N];
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	for (int i = 0; i < N; i++) {
			arr[i]=Long.parseLong(st.nextToken());
		}
    	
    	Arrays.sort(arr);
    	
    	if(N%2==0) {
    		for (int i = 0; i < N/2; i++) {
				ans=Math.max(ans, arr[i]+arr[N-i-1]);
			}
    	}
    	else {
    		ans=arr[N-1];
    		for (int i = 0; i < (N-1)/2; i++) {
				ans=Math.max(ans, arr[i]+arr[N-i-2]);
			}
    	}
    	
    	System.out.println(ans);
    }
    
}