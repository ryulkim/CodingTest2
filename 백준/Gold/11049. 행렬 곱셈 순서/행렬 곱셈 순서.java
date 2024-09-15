import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 시간: 100ms	메모리: 14,356KB
 */
public class Main {
	
	static int N, R, C;
	static long dp[][];
	static ArrayList<V> arr;
	static Long INF=Long.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		dp=new long[N][N];
		arr=new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			R=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			
			arr.add(new V(R,C));
		}
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], INF);
			dp[i][i]=0;
		}
		
		for (int i = 0; i < N-1; i++) {
			dp[i][i+1]=arr.get(i).r*arr.get(i).c*arr.get(i+1).c;
		}
		
		int num=2;
		for (int i = N-3; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				int r=i-j;
				int c=r+num;
				for (int k = r+1; k < c; k++) {
					dp[r][c]=Math.min(dp[r][c], dp[r][k]+dp[k+1][c]+arr.get(r).r*arr.get(k).c*arr.get(c).c);
					dp[r][c]=Math.min(dp[r][c], dp[r][k-1]+dp[k][c]+arr.get(r).r*arr.get(k-1).c*arr.get(c).c);
				}
			}
			num++;
		}
		
		System.out.println(dp[0][N-1]);
	}
	
	static class V{
		int r,c;

		public V(int r, int c) {
			super();
			this.r = r;
			this.c = c;
			
		}
		
		
	}
}

