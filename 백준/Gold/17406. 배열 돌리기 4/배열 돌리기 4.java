import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, K, ans=Integer.MAX_VALUE;
	static int[][] A;
	static ArrayList<int[]> ways;
	static int[] method;
	static boolean[] chk;
	
    public static void main(String[] args) throws IOException {
    	init();
    	proc();
    	System.out.println(ans);
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	K=Integer.parseInt(st.nextToken());
    	A=new int[N][M];
    	ways=new ArrayList<>();
    	method=new int[K];
    	chk=new boolean[K];
    	
    	for (int i = 0; i < N; i++) {
    		st=new StringTokenizer(br.readLine());
    		for (int j = 0; j < M; j++) {
				A[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    	
    	for (int i = 0; i < K; i++) {
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			
			ways.add(new int[] {r,c,s});
		}
    	
    }
    
    public static void proc() {
    	permutation(0);
    }
    
    private static void permutation(int depth) {
    	if(depth==K) {
    		totalRotate();
    		return;
    	}
    	for (int i = 0; i < K; i++) {
			if(chk[i]) continue;
			chk[i]=true;
			method[depth]=i;
			permutation(depth+1);
			chk[i]=false;
		}
    }
    
    private static void totalRotate() {
    	int[][] temp=cloneFrom(A);
    	
//    	printMethod();
//    	print(temp);
    	
    	
    	for (int i = 0; i < K; i++) {
    		int[] info=ways.get(method[i]);
    		int r=info[0];
    		int c=info[1];
    		int s=info[2];
    		int sr=r-s-1;
    		int sc=c-s-1;
    		int er=r+s-1;
    		int ec=c+s-1;
			rotate(temp, sr, sc, er, ec);
//			System.out.println(i+" "+r+" "+c+" "+s);
//			print(temp);
		}
    	ans=Math.min(ans, sum(temp));
    }
    
    private static void rotate(int[][] arr, int sr, int sc, int er, int ec) {
    	while(sr<=er&&sc<=ec) {
    		
    		int next=arr[sr][sc];
    		for (int i = sc; i < ec; i++) {
    			int cur=arr[sr][i+1];
				arr[sr][i+1]=next;
				next=cur;
			}
    		for (int i = sr; i < er; i++) {
    			int cur=arr[i+1][ec];
    			arr[i+1][ec]=next;
    			next=cur;
    		}
    		for (int i = ec; i > sc; i--) {
    			int cur=arr[er][i-1];
				arr[er][i-1]=next;
				next=cur;
			}
    		for (int i = er; i > sr; i--) {
    			int cur=arr[i-1][sc];
				arr[i-1][sc]=next;
				next=cur;
			}
    		sr++;er--;sc++;ec--;
    	}
    }
    
    private static void printMethod() {
    	for (int i = 0; i < K; i++) {
			System.out.print(method[i]+" ");
		}
    	System.out.println();
    }
    
    private static void print(int[][] arr) {
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
    	System.out.println();
    	
    }
    
    private static int sum(int[][] arr) {
    	int min=Integer.MAX_VALUE;
    	for (int i = 0; i < N; i++) {
    		int sum=0;
			for (int j = 0; j < M; j++) {
				sum+=arr[i][j];
			}
			min=Math.min(min, sum);
		}
//    	System.out.println(min);
    	return min;
    }
    
    private static int[][] cloneFrom(int[][] arr) {
    	int[][] temp=new int[N][M];
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j]=arr[i][j];
			}
		}
    	return temp;
    }
    
}


