import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static int N, ans=Integer.MAX_VALUE;
	public static int[][] W;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		W=new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			
			for (int j = 0; j < N; j++) {
				W[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0,0);
		
		System.out.println(ans);
	}
	
	public static void dfs(int num, int flag, int cnt) {
		if(flag==((1<<N)-1)&&ans>cnt&&num==0) {
			ans=cnt;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(W[num][i]==0) continue;
			if((flag&1<<i)!=0) continue;
			
			dfs(i, flag|1<<i, cnt+W[num][i]);
		}
	}


}
