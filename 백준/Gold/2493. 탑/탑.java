import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Main {
	
	static int N;
	static int[] arr, ans;
	static ArrayDeque<Integer> stack;
		
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    	print();
    }

	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N];
    	ans=new int[N];
    	stack=new ArrayDeque<>();
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
    }
	
	
    public static void proc() {
    	for (int i = 0; i < N; i++) {
			while(!stack.isEmpty()&&arr[stack.peek()]<arr[i]) {
				int top=stack.poll();
			}
			
			if(stack.isEmpty()) {
				ans[i]=0;
			}
			else {
				ans[i]=stack.peek()+1;
			}
			stack.push(i);
			
		}
    }
    
    public static void print() {
    	StringBuilder sb=new StringBuilder();
    	
    	for (int i = 0; i < N; i++) {
			sb.append(ans[i]+" ");
		}
    	System.out.println(sb);
    }
 
}