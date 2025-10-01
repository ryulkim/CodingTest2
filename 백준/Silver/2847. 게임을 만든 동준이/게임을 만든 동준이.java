import java.io.*;
import java.util.*;

public class Main {

	static int N, ans=0;
	static int[] arr;
	
    public static void main(String[] args) throws Exception {
    	init();
    }
        
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N+1];

    	for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
    	
    	int num=arr[N-1]-1;
    	for (int i = N-2; i >= 0; i--) {
    		num=Math.min(num, arr[i]);
			ans+=arr[i]-num;
			num--;
		}
    	
    	System.out.println(ans);
    	
    }
    
}
