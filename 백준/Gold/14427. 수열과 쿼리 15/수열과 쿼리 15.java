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
		N=Integer.parseInt(br.readLine());
		arr=new int[N+1];
		tree=new int[4*N];
		arr[N]=1000_000_000;

		StringTokenizer st=new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		rmq(0,N-1,1);
		M=Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int cmd=Integer.parseInt(st.nextToken());
			
			if(cmd==1) {
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				update(0, N-1, a-1, b, 1);
			}
			else {
				sb.append(tree[1]+1+"\n");
			}
			
		}
		
		System.out.println(sb);
	}

	public static void rmq(int s, int e, int idx) {
		if(s==e) {
			tree[idx]=s;
			return;
		}
		int mid=(s+e)/2;
		rmq(s, mid, idx*2);
		rmq(mid+1, e, idx*2+1);
		
		int a=arr[tree[idx*2]];
		int b=arr[tree[idx*2+1]];
		
		if(a==b) {
			tree[idx]=tree[idx*2];
		}
		else if(a>b) {
			tree[idx]=tree[idx*2+1];
		}
		else {
			tree[idx]=tree[idx*2];
		}
	}
	
	public static int query(int s, int e, int ts, int te, int idx) {
		if(e<ts||te<s) return N;
		if(ts<=s&&e<=te) {
			return tree[idx];
		}
		
		int mid=(s+e)/2;
		int a=query(s, mid, ts, te, idx*2);
		int b=query(mid+1, e, ts, te, idx*2+1);
		
		if(arr[a]==arr[b]) {
			return Math.min(a, b);
		}
		else if(arr[a]>arr[b]) {
			return b;
		}
		else {
			return a;
		}
	}
	
	public static int update(int s, int e, int target, int value, int idx) {
		if(s>target||e<target) {
			return tree[idx];
		}
		if(s==e) {
			arr[target] = value;
			return tree[idx];
		}
		int mid=(s+e)/2;
		int left = update(s, mid, target, value, idx * 2);
		int right = update(mid + 1, e, target, value, idx * 2 + 1);

		if (arr[left] == arr[right]) {
			return tree[idx] = Math.min(left, right);
		} else if (arr[left] < arr[right]) {
			return tree[idx] = left;
		} else {
			return tree[idx] = right;
		}

	}
	
}
