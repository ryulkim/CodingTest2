import java.io.*;
import java.util.*;

public class Main {

    static int R, C, K;
    static int[][] arr = new int[101][101];
    static int rowSize = 3, colSize = 3;  // 현재 사용하는 행/열 길이
    static int[] cnt = new int[101];      // 수는 1~100만 나온다고 가정

    public static void main(String[] args) throws Exception {
        init();
        System.out.println(proc());
    }

    public static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static int proc() {
        for (int t = 0; t <= 100; t++) {
            if (R - 1 < 101 && C - 1 < 101 && arr[R - 1][C - 1] == K) {
                return t;
            }

            if (t == 100) break; // 100초까지 확인했는데도 못만들면 -1

            if (rowSize >= colSize) {
                R_operation();
            } else {
                C_operation();
            }
        }
        return -1;
    }

    // R 연산
    public static void R_operation() {
        int[][] tmp = new int[101][101];
        int newColSize = 0;

        for (int i = 0; i < rowSize; i++) {
            Arrays.fill(cnt, 0);

            // 현재 행(i)의 숫자 빈도 계산
            for (int j = 0; j < colSize; j++) {
                int num = arr[i][j];
                if (num == 0) continue;
                if (num > 100) num = 100; // 혹시 몰라서 방어, 안 써도 되는 경우 많음
                cnt[num]++;
            }

            // (숫자, 등장횟수) 리스트 생성
            List<int[]> list = new ArrayList<>();
            for (int num = 1; num <= 100; num++) {
                if (cnt[num] > 0) {
                    list.add(new int[]{num, cnt[num]});
                }
            }

            // 등장횟수 오름차순, 숫자 오름차순
            list.sort((a, b) -> {
                if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            });

            // tmp에 채우기 (최대 100까지만)
            int colIdx = 0;
            for (int[] p : list) {
                if (colIdx >= 100) break;   // 길이 제한
                tmp[i][colIdx++] = p[0];    // 숫자
                if (colIdx >= 100) break;
                tmp[i][colIdx++] = p[1];    // 등장 횟수
            }

            newColSize = Math.max(newColSize, colIdx);
        }

        arr = tmp;
        colSize = newColSize;
        if (colSize > 100) colSize = 100;
    }

    // C 연산
    public static void C_operation() {
        int[][] tmp = new int[101][101];
        int newRowSize = 0;

        for (int j = 0; j < colSize; j++) {
            Arrays.fill(cnt, 0);

            // 현재 열(j)의 숫자 빈도 계산
            for (int i = 0; i < rowSize; i++) {
                int num = arr[i][j];
                if (num == 0) continue;
                if (num > 100) num = 100;
                cnt[num]++;
            }

            // (숫자, 등장횟수) 리스트 생성
            List<int[]> list = new ArrayList<>();
            for (int num = 1; num <= 100; num++) {
                if (cnt[num] > 0) {
                    list.add(new int[]{num, cnt[num]});
                }
            }

            // 등장횟수 오름차순, 숫자 오름차순
            list.sort((a, b) -> {
                if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            });

            // tmp에 채우기 (최대 100까지만)
            int rowIdx = 0;
            for (int[] p : list) {
                if (rowIdx >= 100) break;
                tmp[rowIdx++][j] = p[0];
                if (rowIdx >= 100) break;
                tmp[rowIdx++][j] = p[1];
            }

            newRowSize = Math.max(newRowSize, rowIdx);
        }

        arr = tmp;
        rowSize = newRowSize;
        if (rowSize > 100) rowSize = 100;
    }
}
