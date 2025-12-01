import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, R;
	static int[][] arr;
	static ArrayList<Integer>[] pre;
	
    public static void main(String[] args) throws IOException {
    	init();
    	proc();
    	finish();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	R=Integer.parseInt(st.nextToken());
    	arr=new int[N][M];
    	pre=new ArrayList[N/2+1];
    	
    	for (int i = 0; i <= N/2; i++) {
			pre[i]=new ArrayList<>();
		}
    	
    	for (int i = 0; i < N; i++) {
    		st=new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    }
    
    public static void extract(int u, int d, int l, int r) {
    	for (int i = l; i < r; i++) {
    		pre[u].add(arr[u][i]);
		}
    	
    	for (int i = u+1; i < d; i++) {
			pre[u].add(arr[i][r-1]);
		}
    	
    	for (int i = r-2; i >= l; i--) {
			pre[u].add(arr[d-1][i]);
		}
    	
    	for (int i = d-2; i > u; i--) {
			pre[u].add(arr[i][l]);
		}
    }
    
    public static void proc() {
    	int u=0,d=N,l=0,r=M;
    	while(u<d-1&&l<r-1) {
    		extract(u++, d--, l++, r--);
    	}
    	
    	if(u==d-1) {
    		for (int i = l; i < r; i++) {
				pre[u].add(arr[u][i]);
			}
    	}
    	else if(l==r-1) {
    		for (int i = u; i < d; i++) {
				pre[u].add(arr[i][l]);
			}
    	}
    }
    
    public static void finish() {
    	int[][] ans=new int[N][M];
    	int u=0,d=N,l=0,r=M;
    	for (int i = 0; i <= N/2; i++) {
    		if(pre[i].size()==0) break;
			step(ans, i, R%pre[i].size(), u++, d--, l++, r--);
		}
    	
    	StringBuilder sb=new StringBuilder();
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(ans[i][j]).append(" ");
			}
			sb.append('\n');
		}
    	
    	System.out.println(sb);
    }
    
    public static void step(int[][] ans, int startR, int startC, int u, int d, int l, int r) {
    	int temp=startC;
    	int sz=pre[startR].size();
    	for (int i = l; i < r; i++) {
			ans[u][i]=pre[startR].get(temp);
			temp=(temp+1)%sz;
		}
		
		for (int i = u+1; i < d; i++) {
			ans[i][r-1]=pre[startR].get(temp);
			temp=(temp+1)%sz;
		}
		
		for (int i = r-2; i >= l; i--) {
			ans[d-1][i]=pre[startR].get(temp);
			temp=(temp+1)%sz;
		}
		
		for (int i = d-2; i > u; i--) {
			ans[i][l]=pre[startR].get(temp);
			temp=(temp+1)%sz;
		}
    }

}