import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;


public class Main {

	static int N, M;
	static int[][] arr;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	kadane();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	arr=new int[N+1][M+1];
    	
    	for (int i = 1; i <= N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    	
    	
    }
    
    
    public static void kadane() {
    	int ans=-1000_000_000;
    	
    	for (int top = 1; top <= N; top++) {
    		int[] temp=new int[M+1];
			for (int bottom = top; bottom <= N; bottom++) {
				for (int k = 1; k <= M; k++) {
					temp[k]+=arr[bottom][k];
				}
				
				int cur=0;
				for (int i = 1; i <= M; i++) {
					cur=Math.max(cur+temp[i], temp[i]);
					ans=Math.max(cur, ans);
				}
			}
		}
    	
    	System.out.println(ans);
    }
  
}