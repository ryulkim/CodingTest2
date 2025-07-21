import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	static int N;
	static ArrayDeque<int[]> stack;
	static int[] arr, cnt, value;

	public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    }
    
	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	N=Integer.parseInt(br.readLine());
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	stack=new ArrayDeque<>();
    	arr=new int[N];
    	cnt=new int[N];
    	value=new int[N];
    	Arrays.fill(value, -1);
    	
    	for (int i = 0; i < N; i++) {
			int x=Integer.parseInt(st.nextToken());
			arr[i]=x;
		}
    	
    	proc();
    	
    	for (int i = 0; i < N; i++) {
			if(cnt[i]==0) {
				sb.append(0);
			}
			else {
				sb.append(cnt[i]+" "+(value[i]+1));
			}
			sb.append("\n");
		}
    	
    	System.out.println(sb);
    	
	}
	
	public static void proc() {
		for (int i = 0; i < N; i++) {
			if(stack.isEmpty()) {
				stack.add(new int[] {i, arr[i]});
				continue;
			}
			while(!stack.isEmpty()&&stack.peek()[1]<=arr[i]) {
				stack.poll();
			}
			if(!stack.isEmpty()&&stack.peek()[1]>arr[i]) {
				cnt[i]+=stack.size();
				value[i]=stack.peek()[0];
			}
			stack.push(new int[] {i, arr[i]});
		}
		
		stack.clear();
		
		for (int i = N-1; i >= 0; i--) {
			if(stack.isEmpty()) {
				stack.add(new int[] {i, arr[i]});
				continue;
			}
			while(!stack.isEmpty()&&stack.peek()[1]<=arr[i]) {
				stack.poll();
			}
			if(!stack.isEmpty()&&stack.peek()[1]>arr[i]) {
				cnt[i]+=stack.size();
				
				if(value[i]==-1||stack.peek()[0]-i<i-value[i]) {
					value[i]=stack.peek()[0];					
				}
			}
			stack.push(new int[] {i, arr[i]});
		}
	}
	
}
