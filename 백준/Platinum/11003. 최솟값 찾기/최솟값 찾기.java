import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int N, L;
	static ArrayDeque<Integer> dq;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
		proc();
    }

	public static void init() throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		dq=new ArrayDeque<>();
		arr=new int[N];
		
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int x=Integer.parseInt(st.nextToken());
			arr[i]=x;
		}
		
		for (int i = 0; i < N; i++) {
			if(!dq.isEmpty()&&dq.peek()<=i-L) {
				dq.poll();
			}
			
			while (!dq.isEmpty() && arr[dq.peekLast()] >= arr[i]) {
				dq.pollLast();
			}
			
			dq.add(i);
			
			sb.append(arr[dq.peek()]+" ");
		}
			
		System.out.println(sb);
	}
	
	public static void proc() {
		
	}
}
