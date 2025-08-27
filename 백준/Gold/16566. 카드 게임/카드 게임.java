import java.io.*;
import java.util.*;

public class Main {

	static int N, M, K;
	static int[] arr;
	static boolean[] chk;
	
    public static void main(String[] args) throws Exception {
    	init();
    }

    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	StringBuilder sb=new StringBuilder();
    	
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	K=Integer.parseInt(st.nextToken());
    	arr=new int[N];
    	chk=new boolean[N];
    	
    	st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < M; i++) {
    		arr[i]=Integer.parseInt(st.nextToken());
		}
    	
    	Arrays.sort(arr);
    	
    	st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < K; i++) {
			int x=Integer.parseInt(st.nextToken());
			int num=binary(x);
			chk[num]=true;
			sb.append(num).append("\n");
		}
    	
    	System.out.println(sb);
    }
    
    public static int binary(int target) {
    	int f=0, l=N-1;
    	int ans=0;
    	
    	while(f<=l) {
    		int mid=(f+l)/2;
    		
    		if(arr[mid]<=target) {
    			f=mid+1;
    		}
    		else {
    			l=mid-1;
    			ans=mid;
    		}
    	}
    	
    	for (int i = ans; i < N; i++) {
			if(!chk[arr[i]]) return arr[i];
		}
    	
    	return ans;
    }
    
    
}
