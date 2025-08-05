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
	
	static int N, M;
	static int[] arr;
	static long[] tree, lazy;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
    }

	public static void init() throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		N=Integer.parseInt(br.readLine());
		arr=new int[N];
		tree=new long[4*N];
		lazy=new long[4*N];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		build(1, 0, N-1);
		
		M=Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int cmd=Integer.parseInt(st.nextToken());
			
			if(cmd==1) {
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				update(1, 0, N-1, a, b, c);
			}
			else {
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				sb.append(query(1, 0, N-1, a, b));
				sb.append("\n");
			}
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
		tree[idx]=tree[idx*2]^tree[idx*2+1];
	}
	
	public static void update(int idx, int s, int e, int ts, int te, int v) {
		propagate(idx, s, e);
		if(te<s||e<ts) {
			return;
		}
		if(ts<=s&&e<=te) {
			lazy[idx]^=v;
			propagate(idx, s, e);
			return;
		}
		int mid=(s+e)/2;
		update(idx*2, s, mid, ts, te, v);
		update(idx*2+1, mid+1, e, ts, te, v);
		tree[idx]=tree[idx*2]^tree[idx*2+1];
	}
	
	public static long query(int idx, int s, int e, int ts, int te) {
		propagate(idx, s, e);
		if(te<s||e<ts) {
			return 0;
		}
		if(ts<=s&&e<=te) {
			return tree[idx];
		}
		int mid=(s+e)/2;
		return query(idx*2, s, mid, ts, te)^query(idx*2+1, mid+1, e, ts, te);
	}
	
	public static void propagate(int idx, int s, int e) {
		if(lazy[idx]!=0) {
			if((e-s+1)%2==1) {
				tree[idx]^=lazy[idx];
			}
			
			if(s!=e) {
				lazy[idx*2]^=lazy[idx];
				lazy[idx*2+1]^=lazy[idx];
			}
			
			lazy[idx]=0;
		}
	}
}
