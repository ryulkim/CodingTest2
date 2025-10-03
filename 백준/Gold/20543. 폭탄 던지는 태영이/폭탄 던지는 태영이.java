import java.io.*;
import java.util.*;

public class Main {

	static int N, M, a;
	static long[][] arr, cnt, ans;
	
    public static void main(String[] args) throws Exception {
    	init();
    }
        
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	arr=new long[N+2][N+2];
    	cnt=new long[N+2][N+2];
    	ans=new long[N+2][N+2];
    	a=M/2;
    	
    	for (int i = 1; i <= N; i++) {
    		st=new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    	
    	proc();
    	
    	for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sb.append(ans[i][j]+" ");
			}
			sb.append('\n');
		}
    	
    	System.out.println(sb);
    }
    
    
    public static void proc() {
    	for (int i = 1; i <= N-M+1; i++) {
			for (int j = 1; j <= N-M+1; j++) {
				cnt[i][j]+=cnt[i][j-1];
				long value=arr[i][j]+cnt[i][j]+cnt[i-1][j];
				if(value<0) {
					ans[i+a][j+a]=-value;
					cnt[i][j]-=value;
					cnt[i+M][j]+=value;
					cnt[i][j+M]+=value;					
					cnt[i+M][j+M]-=value;
				}
			}
			
			for (int j = 1; j <= N-M+1; j++) {
				cnt[i][j]+=cnt[i-1][j];
			}
		}
    	
    	
    }
    
}
