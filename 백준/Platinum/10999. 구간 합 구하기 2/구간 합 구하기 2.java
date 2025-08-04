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
	
	static int N, M, K;
	static long[] tree, lazy, arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
    }

	public static void init() throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		arr=new long[N];
		tree=new long[4*N];
		lazy=new long[4*N];
		
		
		for (int i = 0; i < N; i++) {
			arr[i]=Long.parseLong(br.readLine());
		}
		
		build(0, N-1, 1);
		
		for (int i = 0; i < M+K; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			if(a==1) {
				long d=Long.parseLong(st.nextToken());
				update(0, N-1, b-1, c-1, d, 1);
			}
			else {
				sb.append(query(0, N-1, b-1, c-1, 1));
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	public static void build(int s, int e, int idx) {
		if(s==e) {
			tree[idx]=arr[s];
			return;
		}
		int mid=(s+e)/2;
		build(s, mid, idx*2);
		build(mid+1, e, idx*2+1);
		tree[idx]=tree[idx*2]+tree[idx*2+1];
	}
	
	public static void update(int s, int e, int ts, int te, long v, int idx) {
		propagate(idx, s, e);
		if(te<s||e<ts) {
			return;
		}
		else if(ts<=s&&e<=te) {
			lazy[idx]+=v;
			propagate(idx, s, e);
			return;
		}
		
		int mid=(s+e)/2;
		update(s, mid, ts, te, v, idx*2);
		update(mid+1, e, ts, te, v, idx*2+1);
		tree[idx]=tree[idx*2]+tree[idx*2+1];
	}

	public static long query(int s, int e, int ts, int te, int idx) {
		propagate(idx, s, e);
		if(te<s||e<ts) {
			return 0;
		}
		else if(ts<=s&&e<=te) {
			return tree[idx];
		}
		
		int mid=(s+e)/2;
		return query(s, mid, ts, te, idx*2)+query(mid+1, e, ts, te, idx*2+1);
	}
	
	public static void propagate(int idx, int s, int e) {
		if(lazy[idx]!=0) {
			tree[idx]+=(e-s+1)*lazy[idx];
			
			if(s!=e) {
				lazy[idx*2]+=lazy[idx];
				lazy[idx*2+1]+=lazy[idx];
			}
			
			lazy[idx]=0;
		}
	}
	
}
