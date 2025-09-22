import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] arr, cnt;
	
    public static void main(String[] args) throws Exception {
    	init();
    	proc();
    }
        
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	arr=new int[N+2];
    	cnt=new int[N+2];
    	
    	st=new StringTokenizer(br.readLine());
    	for (int i = 1; i <= N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
    	
    	for (int i = 0; i < M; i++) {
    		st=new StringTokenizer(br.readLine());
    		int a=Integer.parseInt(st.nextToken());
    		int b=Integer.parseInt(st.nextToken());
    		int h=Integer.parseInt(st.nextToken());
    		
    		cnt[a]+=h;
    		cnt[b+1]-=h;
		}
    }
    
    public static void proc() {
    	for (int i = 1; i <= N; i++) {
			cnt[i]+=cnt[i-1];
			arr[i]+=cnt[i];
		}
    	
    	StringBuilder sb=new StringBuilder();
    	for (int i = 1; i <= N; i++) {
    		sb.append(arr[i]+" ");
		}
    	sb.append('\n');
    	
    	System.out.println(sb);
    }
    
}
