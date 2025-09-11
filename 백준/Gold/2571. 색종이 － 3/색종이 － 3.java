import java.io.*;
import java.util.*;

public class Main {

	static int T;
	static boolean[][] arr;
	static int[][] sum;
	static HashMap<Character, Integer> hm;
	
    public static void main(String[] args) throws Exception {
    	init();	
    }
    
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	T=Integer.parseInt(br.readLine());
    	arr=new boolean[101][101];
    	sum=new int[102][102];

    	for (int i = 0; i < T; i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		int l=Integer.parseInt(st.nextToken());
    		int d=Integer.parseInt(st.nextToken());
    		
    		for (int r = l; r < l+10; r++) {
				for (int c = d; c < d+10; c++) {
					arr[r][c]=true;
				}
			}
		}
    	
    	proc();
    	
//    	System.out.println(sb);
    }
    
    public static void proc() {
    	for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				int value=arr[i-1][j-1]?1:0;
				sum[i][j]=sum[i][j-1]+sum[i-1][j]-sum[i-1][j-1]+value;
			}
		}
    	
    	int max=0;
    	for (int r1 = 1; r1 <= 100; r1++) {
			for (int r2 = r1; r2 <= 100; r2++) {
				for (int c1 = 1; c1 <= 100; c1++) {
					for (int c2 = c1; c2 <= 100; c2++) {
						int col=c2-c1+1;
						int row=r2-r1+1;
						int value=sum[r2][c2]-sum[r1-1][c2]-sum[r2][c1-1]+sum[r1-1][c1-1];
						if(value==row*col) {
							max=Math.max(max, value);
						}
					}
				}
			}
		}
    	
    	System.out.println(max);
    }
    
}
