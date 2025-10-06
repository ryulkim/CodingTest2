import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] board;

    // 좌, 우, 하, 상 (문제 관례 맞춰도 되고 임의여도 OK)
    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {-1, 1, 0, 0};

    static class Pos {
        int r, c;
        Pos(int r, int c) { this.r = r; this.c = c; }
    }

    static class MoveResult {
        int r, c, dist;
        boolean inHole;
        MoveResult(int r, int c, int dist, boolean inHole) {
            this.r = r; this.c = c; this.dist = dist; this.inHole = inHole;
        }
    }

    static class State {
        int rr, rc, br, bc, depth;
        State(int rr, int rc, int br, int bc, int depth) {
            this.rr = rr; this.rc = rc; this.br = br; this.bc = bc; this.depth = depth;
        }
    }

    static Pos R, B;

    public static void main(String[] args) throws Exception {
        init();
        System.out.println(bfs());
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = row.charAt(j);
                board[i][j] = c;
                if (c == 'R') {
                    R = new Pos(i, j);
                    board[i][j] = '.'; // 내용물만 기록
                } else if (c == 'B') {
                    B = new Pos(i, j);
                    board[i][j] = '.';
                }
            }
        }
    }

    static int bfs() {
        boolean[][][][] visited = new boolean[N][M][N][M];
        ArrayDeque<State> q = new ArrayDeque<>();
        q.add(new State(R.r, R.c, B.r, B.c, 0));
        visited[R.r][R.c][B.r][B.c] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            if (cur.depth >= 10) continue; // 10회 초과 금지

            for (int dir = 0; dir < 4; dir++) {
                MoveResult rRes = move(cur.rr, cur.rc, dir);
                MoveResult bRes = move(cur.br, cur.bc, dir);

                // 파란 구슬이 구멍에 빠지면 실패 상태 -> skip
                if (bRes.inHole) continue;

                // 빨간 구슬만 구멍에 빠졌다면 성공
                if (rRes.inHole) return cur.depth + 1;

                int nrr = rRes.r, nrc = rRes.c;
                int nbr = bRes.r, nbc = bRes.c;

                // 같은 칸에 멈췄다면(구멍은 아님) 충돌 처리
                if (nrr == nbr && nrc == nbc) {
                    // 더 멀리 이동한 구슬을 한 칸 뒤로
                    if (rRes.dist > bRes.dist) {
                        nrr -= dr[dir];
                        nrc -= dc[dir];
                    } else {
                        nbr -= dr[dir];
                        nbc -= dc[dir];
                    }
                }

                // 움직임이 전혀 없었다면 큐에 넣지 않음 (가지치기)
                if (nrr == cur.rr && nrc == cur.rc && nbr == cur.br && nbc == cur.bc) continue;

                if (!visited[nrr][nrc][nbr][nbc]) {
                    visited[nrr][nrc][nbr][nbc] = true;
                    q.add(new State(nrr, nrc, nbr, nbc, cur.depth + 1));
                }
            }
        }
        return -1;
    }

    // dir 방향으로 (r,c) 구슬을 굴림
    static MoveResult move(int r, int c, int dir) {
        int nr = r, nc = c, dist = 0;
        while (true) {
            int tr = nr + dr[dir];
            int tc = nc + dc[dir];

            if (board[tr][tc] == '#') break;          // 벽이면 직전 위치가 최종
            nr = tr; nc = tc; dist++;

            if (board[nr][nc] == 'O') {               // 구멍에 빠짐
                return new MoveResult(nr, nc, dist, true);
            }
        }
        return new MoveResult(nr, nc, dist, false);
    }
}
