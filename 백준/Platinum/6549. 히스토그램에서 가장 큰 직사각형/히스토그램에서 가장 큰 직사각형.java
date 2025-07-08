import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {

	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	
    	while(true) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		int N=Integer.parseInt(st.nextToken());
    		int[] arr=new int[N];
    		
    		if(N==0) break;
    		
    		for (int i = 0; i < N; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
    		
    		System.out.println(proc(arr, N));
    	}
    	
    }
    
    public static long proc(int[] arr, int N) {
    	ArrayDeque<Integer> st=new ArrayDeque<>();
    	long ans=0;
    	
    	for (int i = 0; i < N; i++) {
			if(st.isEmpty()||arr[st.peek()]<arr[i]) {
				st.push(i);
			}
			else {
				int idx=-1;
				while(!st.isEmpty()&&arr[st.peek()]>arr[i]){
					idx=st.pop();
					long value=(long) arr[idx]*(i-idx);
					ans=Math.max(ans, value);
//					System.out.println(i+" "+idx+" "+value);
				}
				if(idx!=-1) {
					st.push(idx);
					arr[idx]=arr[i];
				}
			}
		}
    	
    	while(!st.isEmpty()) {
    		int idx=st.pop();
    		long value=(long) arr[idx]*(N-idx);
    		ans=Math.max(ans, value);
//    		System.out.println(idx+" "+value);
    	}
    	
    	return ans;
    }
}