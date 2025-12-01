import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, R;
	static int[][] arr;
	
    public static void main(String[] args) throws IOException {
    	init();
    	proc();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	R=Integer.parseInt(st.nextToken());
    	arr=new int[N][M];
    	
    	for (int i = 0; i < N; i++) {
    		st=new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    }
    
    public static void proc() {
    	for (int i = 0; i < R; i++) {
			rotate();
		}
    	
    	StringBuilder sb=new StringBuilder();
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append('\n');
		}
    	
    	System.out.println(sb);
    }
    
    public static void rotate() {
    	int[][] temp=new int[N][M];
    	int u=0,d=N,l=0,r=M;
    	
    	while(u<d-1&&l<r-1) {
			step(temp, u++, d--, l++, r--);
		}
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j]=temp[i][j];
			}
		}
    }
    
    public static void step(int[][] temp, int u, int d, int l, int r) {
    	for (int i = l; i < r-1; i++) {
			temp[u][i]=arr[u][i+1];
			temp[d-1][i+1]=arr[d-1][i];
		}
    	
    	for (int i = u; i < d-1; i++) {
			temp[i+1][l]=arr[i][l];
			temp[i][r-1]=arr[i+1][r-1];
		}
    }
}