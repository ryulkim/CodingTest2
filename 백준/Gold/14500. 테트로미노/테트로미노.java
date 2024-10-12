import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N, M, ans;
	public static int[][] graph;
	public static int[] dr= {0,1,0,-1};
	public static int[] dc= {-1,0,1,0};
	public static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		graph=new int[N][M];
		ans=0;
		visited=new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j]=true;
//				System.out.println(i+" "+j+": "+graph[i][j]);
				dfs(i,j,0,graph[i][j]);
				visited[i][j]=false;
				Tshape(i, j);
//				System.out.println("----------------------");
			}
		}
		
		System.out.println(ans);
	}
	
	public static void Tshape(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int sum=graph[r][c];
			for (int k = 0; k < 3; k++) {
				int nr=r+dr[(i+k)%4];
				int nc=c+dc[(i+k)%4];
				if(!valid(nr,nc)) {
					sum=0;
					break;
				}
				sum+=graph[nr][nc];
			}
//			System.out.println(sum);
			ans=Math.max(ans, sum);
		}
	}
	
	public static void dfs(int i, int j, int cnt, int sum) {
		if(cnt==3) {
			ans=Math.max(ans, sum);
//			System.out.println(i+" "+j+": "+sum);
			return;
		}
		for (int k = 0; k < 4; k++) {
			int nr=i+dr[k];
			int nc=j+dc[k];
			
			if(!valid(nr,nc)||visited[nr][nc]) continue;
			
			visited[nr][nc]=true;
			dfs(nr,nc,cnt+1,sum+graph[nr][nc]);
			visited[nr][nc]=false;
		}
	}
	
	public static boolean valid(int i, int j) {
		return i>=0&&i<N&&j>=0&&j<M;
	}

}
