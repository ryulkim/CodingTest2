import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static ArrayList<Integer>[] arr;
	static int[] dp, inbound, times;

    public static void main(String[] args) throws IOException {
    	init();
    	proc();
    	print();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	arr=new ArrayList[N];
    	dp=new int[N];
    	inbound=new int[N];
    	times=new int[N];
    	
    	for (int i = 0; i < N; i++) {
			arr[i]=new ArrayList<>();
		}
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		int time=Integer.parseInt(st.nextToken());
    		times[i]=time;
    		
    		while(true) {
    			int num=Integer.parseInt(st.nextToken())-1;
    			
    			if(num<0) {
    				break;
    			}
    			
    			arr[num].add(i);
    			inbound[i]++;
    		}
		}
    }
    
    public static void proc() {
    	ArrayDeque<Integer> q=new ArrayDeque<>();
    	
    	for (int i = 0; i < N; i++) {
			if(inbound[i]==0) {
				q.add(i);
			}
		}
    	
    	while(!q.isEmpty()) {
    		int num=q.poll();
    		dp[num]+=times[num];
    		
    		for(int next : arr[num]) {
    			inbound[next]--;
    			if(inbound[next]==0) {
    				q.add(next);
    			}
    			dp[next]=Math.max(dp[next], dp[num]);
    		}
    	}
    }
    
    public static void print() {
    	for (int i = 0; i < N; i++) {
			System.out.println(dp[i]);
		}
    }
}