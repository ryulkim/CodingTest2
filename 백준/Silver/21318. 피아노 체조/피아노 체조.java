import java.io.*;
import java.util.*;

public class Main {

	static int N, Q;
	static int[] arr, cnt;
	
    public static void main(String[] args) throws Exception {
    	init();	
    }
    
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N];
    	cnt=new int[N];
    	
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
    	
    	proc();
    	
    	Q=Integer.parseInt(br.readLine());
    	for (int i = 0; i < Q; i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			sb.append(cnt[y-1]-cnt[x-1]).append('\n');
		}
    	
    	System.out.println(sb);
    	
    }
    
    public static void proc() {
    	for (int i = 0; i < N-1; i++) {
			if(arr[i+1]<arr[i]) {
				cnt[i+1]=cnt[i]+1;
			}
			else {
				cnt[i+1]=cnt[i];
			}
		}
    	
//    	cnt[N-1]=cnt[N-2];
    }
    
}
