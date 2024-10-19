import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 시간: 568ms  메모리: 34888kb */

public class Main {

	public static int N, M, K;
	public static long[] arr, tree;
	public static long MOD=1000000007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		arr=new long[N];
		tree=new long[4*N];
		
		for (int i = 0; i < N; i++) {
			arr[i]=Long.parseLong(br.readLine());
		}
		
		init(0,N-1,0);
		
		for (int i = 0; i < M+K; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			
			if(a==1) { // 정보 업데이트
				int b=Integer.parseInt(st.nextToken());
				long c=Long.parseLong(st.nextToken());
				
				arr[b-1]=c;
				update(0,N-1,b-1, arr[b-1], c, 0);
//				
//				if(arr[b-1]==0) {
//					arr[b-1]=c;
//					init(0,N-1,0);
//				}
//				else {
//					update(0,N-1,b-1, arr[b-1], c, 0);
//					arr[b-1]=c;
//				}
			}
			else { // 구간곱 출력
				int b=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
//				System.out.println(sum(0,N-1,b-1,c-1,0));
				sb.append(sum(0,N-1,b-1,c-1,0)+"\n");
			}
		}
		
		System.out.println(sb);
	}
	
	public static long init(int start, int end, int index) {
		if(start==end) {
			return tree[index]=arr[start];
		}
		int mid=(start+end)/2;
		return tree[index]=(init(start, mid, index*2+1)*init(mid+1, end, index*2+2))%MOD;
	}
	
	public static long update(int start, int end, int index, long prev, long update, int treeIndex) {
		if(index<start||end<index) return tree[treeIndex];
		
//		tree[treeIndex]/=prev;
//		tree[treeIndex]*=update;
//		tree[treeIndex]%=MOD;
		
		if(start==end) return tree[treeIndex]=arr[index];
		int mid=(start+end)/2;
		return tree[treeIndex]=(update(start, mid, index, prev, update, treeIndex*2+1)*update(mid+1, end, index, prev, update, treeIndex*2+2))%MOD;
	}
	
	public static long sum(int start, int end, int findLeft, int findRight, int index) {
		if(findRight<start||end<findLeft) return 1;
		if(findLeft<=start&&end<=findRight) return tree[index];
		
		int mid=(start+end)/2;
		return ((long) sum(start, mid, findLeft, findRight, index*2+1)* (long) sum(mid+1, end, findLeft, findRight, index*2+2))%MOD;
	}

}
