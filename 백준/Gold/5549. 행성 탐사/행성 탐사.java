import java.io.*;
import java.util.*;

public class Main {

	static int R, C, Q;
	static char[][] arr;
	static int[][][] sum;
	static HashMap<Character, Integer> hm;
	
    public static void main(String[] args) throws Exception {
    	init();	
    }
    
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	R=Integer.parseInt(st.nextToken());
    	C=Integer.parseInt(st.nextToken());
    	Q=Integer.parseInt(br.readLine());
    	arr=new char[R+1][C+1];
    	sum=new int[R+1][C+1][3];
    	hm=new HashMap<>();
    	hm.put('J', 0);
    	hm.put('O', 1);
    	hm.put('I', 2);
    	
    	for (int i = 1; i <= R; i++) {
    		String s=br.readLine();
			for (int j = 1; j <= C; j++) {
				arr[i][j]=s.charAt(j-1);
			}
		}
    	
    	proc();
    	
    	for (int i = 0; i < Q; i++) {
    		st=new StringTokenizer(br.readLine());
			int r1=Integer.parseInt(st.nextToken());
			int c1=Integer.parseInt(st.nextToken());
			int r2=Integer.parseInt(st.nextToken());
			int c2=Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < 3; j++) {
				int value=sum[r2][c2][j]-sum[r2][c1-1][j]-sum[r1-1][c2][j]+sum[r1-1][c1-1][j];
				sb.append(value).append(' ');
			}
			sb.append('\n');
		}
    	
    	System.out.println(sb);
    }
    
    public static void proc() {
    	for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				for (int k = 0; k < 3; k++) {
					int value=hm.get(arr[i][j])==k?1:0;
					sum[i][j][k]=sum[i][j-1][k]+sum[i-1][j][k]-sum[i-1][j-1][k]+value;
				}
			}
		}
    }
    
}
