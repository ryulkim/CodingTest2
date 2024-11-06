import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 시간: 568ms  메모리: 34888kb */

public class Main {

	public static int N, M=1000000, A, C, ans;
	public static long B;
	public static long[] arr, tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		N=Integer.parseInt(st.nextToken());
		
		arr=new long[M];
		tree=new long[4*M+1];
		
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			A=Integer.parseInt(st.nextToken());
			if(A==1) {
				B=Long.parseLong(st.nextToken());
				find(1, M, B, 1);
				System.out.println(ans);
			}
			else {
				A=Integer.parseInt(st.nextToken());
				C=Integer.parseInt(st.nextToken());
				
				update(1, M, A, C, 1);
			}
//			arr[i]=Integer.parseInt(br.readLine());
		}
		
//		init(0,N-1,0);
		
//		for (int i = 0; i < M; i++) {
//			st=new StringTokenizer(br.readLine());
//			int a=Integer.parseInt(st.nextToken());
//			
//			if(a==1) { // 정보 업데이트
//				int b=Integer.parseInt(st.nextToken());
//				long c=Long.parseLong(st.nextToken());
//				long diff=c-arr[b-1];
//				arr[b-1]=c;
//				update(0,N-1,b-1,diff,0);
//			}
//			else { // 구간합 출력
//				int b=Integer.parseInt(st.nextToken());
//				int c=Integer.parseInt(st.nextToken());
////				System.out.println(sum(0,N-1,b-1,c-1,0));
//				sb.append(find(0,N-1,b-1,c-1,0)+"\n");
//			}
//		}
//		
//		System.out.println(sb);
	}
	
	public static long init(int start, int end, int index) {
		if(start==end) {
			return tree[index]=arr[start];
		}
		int mid=(start+end)/2;
		return tree[index]=init(start, mid, index*2)+init(mid+1, end, index*2+1);
	}
	
	public static void update(int start, int end, int index, long diff, int treeIndex) {
		if(index<start||end<index) return;
		
		tree[treeIndex]+=diff;
		
		if(start==end) return;
		int mid=(start+end)/2;
		update(start, mid, index, diff, treeIndex*2);
		update(mid+1, end, index, diff, treeIndex*2+1);
		
		return;
	}
	
	public static void find(int start, int end, long find, int index) {
		int mid=(start+end)/2;
		tree[index]--;
		if(start==end) {
			ans=end;
			return;
		}
			
		
		if(tree[index*2]>=find) { //왼쪽 탐색	
			find(start, mid, find, index*2);
		}
		else { //오른쪽 탐색
			find(mid+1, end, find-tree[index*2], index*2+1);
		}
	}

}
