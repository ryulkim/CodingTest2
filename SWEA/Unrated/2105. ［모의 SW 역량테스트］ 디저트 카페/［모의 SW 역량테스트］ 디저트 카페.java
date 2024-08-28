import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 시간: 348ms	메모리: 27,620KB
 */
public class Solution {
	
	public static int T, N, SR, SC, ans;
	public static int[][] graph;
	public static boolean[][] visited;
	public static boolean[] visitedType;
	public static int[] dr= {1,1,-1,-1};
	public static int[] dc= {1,-1,-1,1};
	public static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		T=Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			N=Integer.parseInt(br.readLine());
			graph=new int[N][N];
			ans=0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					graph[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited=new boolean[N][N];
					visitedType=new boolean[101];
					SR=i;SC=j;
					list.clear();
					dfs(i,j,0,0);
				}
			}
			sb.append("#"+testCase+" ");
//			System.out.print("#"+testCase+" ");
			if(ans==0) {
				sb.append(-1);
				sb.append('\n');
			}
			else {
				sb.append(ans);
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}
	
	public static void dfs(int r, int c, int dir, int cnt) {
		if(r==SR&&c==SC&&dir==3) {
			if(ans<cnt) {
				ans=cnt;
			}
//			System.out.println(list);
			return;
		}
//		if(r!=SR&&c!=SC&&dir==0) return;
		
		// 같은 방향으로 나아갈 때
		int nr=r+dr[dir];
		int nc=c+dc[dir];
		if(valid(nr,nc)&&!visited[nr][nc]&&!visitedType[graph[nr][nc]]) {
			visited[nr][nc]=true;
			visitedType[graph[nr][nc]]=true;
//			list.add(graph[nr][nc]);
			dfs(nr,nc,dir,cnt+1);
			visited[nr][nc]=false;
			visitedType[graph[nr][nc]]=false;
//			list.remove(list.size() - 1);
		}
		
		// 다른 방향으로 갈 때
		dir=(dir+1)%4;
		nr=r+dr[dir];
		nc=c+dc[dir];
		if(valid(nr,nc)&&!visited[nr][nc]&&!visitedType[graph[nr][nc]]) {
			visited[nr][nc]=true;
			visitedType[graph[nr][nc]]=true;
//			list.add(graph[nr][nc]);
			dfs(nr,nc,dir,cnt+1);
			visited[nr][nc]=false;
			visitedType[graph[nr][nc]]=false;
//			list.remove(list.size() - 1);
		}
	}
	
	public static boolean valid(int i, int j) {
		return i>=0&&i<N&&j>=0&&j<N;
	}
	
}


