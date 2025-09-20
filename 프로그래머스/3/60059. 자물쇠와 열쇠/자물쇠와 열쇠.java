import java.util.*;

class Solution {

    int[][] key, lock;
    int[] kBit, lBit;
    int N, M;
    int FULL; // 자물쇠 한 줄이 모두 1인 상태

    public boolean solution(int[][] key, int[][] lock) {
        this.key = key;
        this.lock = lock;
        this.N = lock.length;
        this.M = key.length;
        this.FULL = (1 << N) - 1;

        this.kBit = new int[M];
        this.lBit = new int[N];

        buildLockBits(); // 자물쇠: 돌기=1, 홈=0 기준
        for (int rot = 0; rot < 4; rot++) {
            buildKeyBits();          // 현재 회전 상태의 열쇠 비트화
            if (canUnlock()) return true;
            rotateKey90();           // 시계방향 90°
        }
        return false;
    }

    // 배치 가능 여부 검사 (패딩 없이 비트 시프트로 전 범위 시도)
    private boolean canUnlock() {
        for (int sRow = -M + 1; sRow <= N - 1; sRow++) {
            for (int col = -M + 1; col <= N - 1; col++) {
                if (fitsAt(sRow, col)) return true;
            }
        }
        return false;
    }

    // (sRow, col) 오프셋에 열쇠를 뒀을 때 자물쇠를 정확히 채우는지 검사
    private boolean fitsAt(int sRow, int col) {
        for (int r = 0; r < N; r++) {
            int kRow = r - sRow;
            int x = 0; // 이 줄에서 열쇠가 기여하는 비트들(N폭으로 잘라 사용)

            if (0 <= kRow && kRow < M) {
                if (col >= 0) x = (kBit[kRow] >> col);
                else          x = (kBit[kRow] << (-col));
                x &= FULL; // N비트 마스킹

                // 1과 1이 겹치면 실패 (돌기 충돌)
                if ((lBit[r] & x) != 0) return false;

                // 합쳐서 이 줄이 전부 1이어야 함(홈이 모두 채워짐)
                if ((lBit[r] | x) != FULL) return false;
            } else {
                // 이 줄에 열쇠가 닿지 않으면 애초에 자물쇠가 모두 1이어야 함
                if (lBit[r] != FULL) return false;
            }
        }
        return true;
    }

    private void buildKeyBits() {
        for (int i = 0; i < M; i++) {
            int x = 0;
            for (int j = 0; j < M; j++) {
                x <<= 1;
                if (key[i][j] == 1) x |= 1; // 열쇠 돌기=1
            }
            kBit[i] = x;
        }
    }

    private void buildLockBits() {
        for (int i = 0; i < N; i++) {
            int x = 0;
            for (int j = 0; j < N; j++) {
                x <<= 1;
                if (lock[i][j] == 1) x |= 1; // 자물쇠 돌기=1, 홈=0
            }
            lBit[i] = x;
        }
    }

    private void rotateKey90() {
        int[][] t = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                t[j][M - 1 - i] = key[i][j];
            }
        }
        key = t;
    }
}
