import java.io.*;
import java.util.*;

public class Main {
	static int N, M, cheeseCnt;
	static Queue<Pos> cheeseQ;
	static int[][] board;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		cheeseQ = new ArrayDeque<>();

		board = new int[N][M];

		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j]==1) cheeseQ.add(new Pos(i, j));
			}
		}

		cheeseCnt = cheeseQ.size();

		int answer = 0;
		while (cheeseCnt != 0) {
			visited = new boolean[N][M];
			checkEdge(0,0);
			melt();
			cheeseCnt = cheeseQ.size();
			answer ++;
		}
		System.out.println(answer);
	}

	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static private void checkEdge(int x, int y) {
		visited[x][y] = true;
		board[x][y] = 2;

		for (int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx<0 || nx>=N || ny<0 || ny>=M) continue;
			if (visited[nx][ny] || board[nx][ny]==1) continue;

			checkEdge(nx, ny);
		}
	}

	static private void melt() {
		int size = cheeseQ.size(); // 현재 라운드 기준 고정
		for (int i = 0; i < size; i++) {
			Pos now = cheeseQ.poll();
			int x = now.x, y = now.y;

			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (board[nx][ny] == 2) cnt++; // 외부공기와 접촉
			}

			if (cnt >= 2) {
				board[x][y] = 0; // 녹음
			} else {
				cheeseQ.add(now);
			}
		}
	}

	static private class Pos {
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}