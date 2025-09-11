import java.io.*;
import java.util.*;

public class Main {

	static int R, C, Q;
	static int[][] arr, sum;
	
    public static void main(String[] args) throws Exception {
    	init();	
    }
    
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	R=Integer.parseInt(st.nextToken());
    	C=Integer.parseInt(st.nextToken());
    	Q=Integer.parseInt(st.nextToken());
    	arr=new int[R+1][C+1];
    	sum=new int[R+1][C+1];
    	
    	for (int i = 1; i <= R; i++) {
    		st=new StringTokenizer(br.readLine());
			for (int j = 1; j <= C; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    	
    	proc();
    	
    	for (int i = 0; i < Q; i++) {
    		st=new StringTokenizer(br.readLine());
			int r1=Integer.parseInt(st.nextToken());
			int c1=Integer.parseInt(st.nextToken());
			int r2=Integer.parseInt(st.nextToken());
			int c2=Integer.parseInt(st.nextToken());
			int value=sum[r2][c2]-sum[r2][c1-1]-sum[r1-1][c2]+sum[r1-1][c1-1];
			sb.append(value/((r2-r1+1)*(c2-c1+1)))
			.append('\n');
		}
    	
    	System.out.println(sb);
    }
    
    public static void proc() {
    	for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				sum[i][j]=sum[i][j-1]+sum[i-1][j]-sum[i-1][j-1]+arr[i][j];
			}
		}
    }
    
}
