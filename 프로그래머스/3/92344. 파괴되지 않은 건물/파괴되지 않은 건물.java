class Solution {

    public int solution(int[][] board, int[][] skill) {
        int R = board.length, C = board[0].length;

        // 누적용 차분 배열 (경계 처리를 위해 +2)
        long[][] acc = new long[R + 2][C + 2];

        // 1) 사분점(모서리)만 갱신
        // type=1(공격) -> 음수, type=2(회복) -> 양수
        for (int[] s : skill) {
            int type = s[0], r1 = s[1], c1 = s[2], r2 = s[3], c2 = s[4], d = s[5];
            long val = (type == 1) ? - (long) d : (long) d;

            acc[r1][c1]       += val;
            acc[r1][c2 + 1]   -= val;
            acc[r2 + 1][c1]   -= val;
            acc[r2 + 1][c2 + 1] += val;
        }

        // 2) 행 누적
        for (int i = 0; i <= R; i++) {
            long run = 0;
            for (int j = 0; j <= C; j++) {
                run += acc[i][j];
                acc[i][j] = run;
            }
        }

        // 3) 열 누적
        for (int j = 0; j <= C; j++) {
            long run = 0;
            for (int i = 0; i <= R; i++) {
                run += acc[i][j];
                acc[i][j] = run;
            }
        }

        // 4) 최종 합산 후 양수 카운트
        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                long val = board[i][j] + acc[i][j];
                if (val > 0) answer++;
            }
        }

        return answer;
    }
}
