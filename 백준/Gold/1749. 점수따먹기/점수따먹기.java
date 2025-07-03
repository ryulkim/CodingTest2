import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;


public class Main {

	static int N, M;
	static int[][] sum;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	sum=new int[N+1][M+1];
    	
    	for (int i = 1; i <= N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				int x=Integer.parseInt(st.nextToken());
				sum[i][j]=sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+x;
			}
		}
    	
    	
    }
    
    public static void proc() {
    	int ans=-1000_000_000;
    	
    	for (int d = 1; d <= N; d++) {
			for (int r = 1; r <= M; r++) {
				for (int u = 1; u <= d; u++) {
					for (int l = 1; l <= r; l++) {
						int value=sum[d][r]-sum[u-1][r]-sum[d][l-1]+sum[u-1][l-1];
						ans=Math.max(ans, value);
					}
				}
			}
		}
    	
    	System.out.println(ans);
    }
  
}