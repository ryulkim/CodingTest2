import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static int T, N, X, ans;
	public static int[][] graph;
	public static int[] dr= {0,0,-1,1};
	public static int[] dc= {-1,1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for (int testCase = 0; testCase < T; testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			X=Integer.parseInt(st.nextToken());
			graph=new int[N+1][N+1]; //끝 부분들은 가장 큰 수 저장
			ans=0;
			
			for (int i = 0; i < N; i++) {
				st=new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					graph[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					graph[i][N]=Math.max(graph[i][j], graph[i][N]);
					graph[N][i]=Math.max(graph[j][i], graph[N][i]);
				}
			}
			
			//왼->오 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(graph[i][j]==graph[i][N]) {
						boolean left=bfs(i,j,0);
						boolean right=bfs(i,j,1);
						
						if(left&&right) {
							ans++;
						}
						
						break;
					}
				}
			}
			
			//상->하 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(graph[j][i]==graph[N][i]) {
						boolean up=bfs(j,i,2);
						boolean down=bfs(j,i,3);
						
						if(up&&down) {
							ans++;
						}
						
						break;
					}
				}
			}
			
			System.out.println("#"+(testCase+1)+" "+ans);
			
		}
	}
	
	public static boolean bfs(int i, int j, int dir) { //dir 0: 왼쪽, 1: 오른쪽, 2: 상, 3: 하
		Queue<Point> q=new ArrayDeque<Point>();
		int num=graph[i][j];
		int cnt=X;
		q.add(new Point(i,j));
		
		while(!q.isEmpty()) {
			Point p=q.poll();
			int pNum=graph[p.r][p.c];
			//num이 같은 경우, cnt 증가
			if(num==pNum) {
				cnt++;
			}
			//num이 작아지는 경우(차이가 1), cnt 비교
			else if(num==pNum+1) {
				if(cnt>=X) {//경사로 길이 만큼 됐는지
					cnt=1;
					num=pNum;
				}
				else return false;
			}
			//num이 다시 커지는 경우(차이가 1), cnt가 x*2인지 본다.
			else if(num==pNum-1){
				if(cnt>=X*2) {//경사로를 설치할 수 있는지(V자로)
					cnt=X;
					num=pNum;
				}
				else return false;
			}
			else { // 경사로를 세울 수 없는 경우
				return false;
			}
			int nr=p.r+dr[dir];
			int nc=p.c+dc[dir];
			if(valid(nr,nc)) {
				q.add(new Point(nr, nc));
			}
		}
		
		if(cnt>=X) {
			return true;
		}
		return false;
	}
	
	public static boolean valid(int i, int j) {
		return i>=0&&i<N&&j>=0&&j<N;
	}
}

class Point{
	int r, c;

	public Point(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}