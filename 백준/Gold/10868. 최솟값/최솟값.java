import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M;
	static int[] arr, tree;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
    }
    
	public static void init() throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N];
		tree=new int[4*N];

		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		rmq(0,N-1,0);
		
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			sb.append(query(0, N-1, a-1, b-1, 0)+"\n");
		}
		
		System.out.println(sb);
	}

	public static void rmq(int s, int e, int idx) {
		if(s==e) {
			tree[idx]=arr[s];
			return;
		}
		int mid=(s+e)/2;
		rmq(s, mid, idx*2+1);
		rmq(mid+1, e, idx*2+2);
		tree[idx]=Math.min(tree[idx*2+1], tree[idx*2+2]);
	}
	
	public static int query(int s, int e, int ts, int te, int idx) {
		if(e<ts||te<s) return 1000_000_000;
		if(s==e) {
			return tree[idx];
		}
		if(ts<=s&&e<=te) {
			return tree[idx];
		}
		
		int mid=(s+e)/2;
		return Math.min(query(s, mid, ts, te, idx*2+1), query(mid+1, e, ts, te, idx*2+2));
	}
	
	public static void square() {
		
	}
	
}
