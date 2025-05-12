import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static int N;
	static int[][] arr;
	static int[][] ans;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    	chk();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N][N];
    	ans=new int[N][N];
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    }
    
    public static void proc() {
    	for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][k]==1&&arr[k][j]==1) {
						arr[i][j]=1;
					}
				}
			}
		}
    }
    
    public static void chk() {
    	StringBuilder sb=new StringBuilder();
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append('\n');
		}
    	
    	System.out.println(sb);
    }
    
    
}