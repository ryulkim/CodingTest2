import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int N, Q;
	static int[] arr;
	static long[] tree;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
    }

	public static void init() throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		Q=Integer.parseInt(st.nextToken());
		arr=new int[N];
		tree=new long[4*N];
		
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num=Integer.parseInt(st.nextToken());
			arr[i]=num;
		}
		
		build(1, 0, N-1);
		
		for (int i = 0; i < Q; i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			if(x<y) sb.append(query(1, 0, N-1, x-1, y-1));
			else sb.append(query(1, 0, N-1, y-1, x-1));
			sb.append("\n");
			
			update(1, 0, N-1, a-1, b);
		}
		
		System.out.println(sb);
	}
	
	public static void build(int idx, int s, int e) {
		if(s==e) {
			tree[idx]=arr[s];
			return;
		}
		int mid=(s+e)/2;
		build(idx*2, s, mid);
		build(idx*2+1, mid+1, e);
		tree[idx]=tree[idx*2]+tree[idx*2+1];
	}
	
	public static void update(int idx, int s, int e, int target, int v) {
		if(target<s||e<target) {
			return;
		}
		if(s==e) {
			tree[idx]=v;
			return;
		}
		int mid=(s+e)/2;
		update(idx*2, s, mid, target, v);
		update(idx*2+1, mid+1, e, target, v);
		tree[idx]=tree[idx*2]+tree[idx*2+1];
	}
	
	public static long query(int idx, int s, int e, int ts, int te) {
		if(te<s||e<ts) {
			return 0;
		}
		if(ts<=s&&e<=te) {
			return tree[idx];
		}
		int mid=(s+e)/2;
		return query(idx*2, s, mid, ts, te)+query(idx*2+1, mid+1, e, ts, te);
	}
}
