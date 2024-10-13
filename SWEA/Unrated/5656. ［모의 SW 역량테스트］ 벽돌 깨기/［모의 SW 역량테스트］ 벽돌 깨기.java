import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static List<Integer>[] map;
    static List<Integer>[] cloneMap;
    static int N, W, H;
    static boolean[] visited;
    static int[] numbers;
    static int min;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            min = 120_000;
            cloneMap = new ArrayList[W];
            map = new ArrayList[W];

            for (int i = 0; i < W; i++) {
                cloneMap[i] = new ArrayList<>();
                map[i] = new ArrayList<>();
            }

            int[][] tempMap = new int[H][W];
            visited = new boolean[W];
            numbers = new int[N];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    tempMap[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < W; i++) {
                for (int j = H - 1; j >= 0; j--) {
                    cloneMap[i].add(tempMap[j][i]);
                }
            }

            for (int i = 0; i < W; i++) {
                map[i] = new ArrayList<>(cloneMap[i]);
            }

            bt(0);
            System.out.printf("#%d %d\n", t, min);
        }
    }

    static void bt(int depth) {
        if (depth == N) {
            List<Integer>[] tempMap = new ArrayList[W];
            for (int i = 0; i < W; i++) {
                tempMap[i] = new ArrayList<>(cloneMap[i]);
            }

            for (int i : numbers) {
                shoot(i);
                down();
            }

            int count = 0;
            for (int i = 0; i < W; i++) {
                for (int j : cloneMap[i]) {
                    if (j != 0) {
                        count++;
                    }
                }
            }

            min = Math.min(min, count);

            for (int i = 0; i < W; i++) {
                cloneMap[i] = new ArrayList<>(tempMap[i]);
            }
            return;
        }

        for (int i = 0; i < W; i++) {
            numbers[depth] = i;
            bt(depth + 1);
        }
    }

    public static void down() {
        for (int i = 0; i < W; i++) {
            List<Integer> column = cloneMap[i];
            column.removeIf(c -> c == 0);

            while (column.size() < H) {
                column.add(0);
            }
        }
    }

    public static void shoot(int x) {
        Queue<Position> q = new LinkedList<>();

        for (int i = cloneMap[x].size() - 1; i >= 0; i--) {
            if (cloneMap[x].get(i) != 0) {
                q.add(new Position(x, i));
                break;
            }
        }

        while (!q.isEmpty()) {
            Position p = q.poll();
            int n = cloneMap[p.x].get(p.y);
            if (n != 0) {
                cloneMap[p.x].set(p.y, 0);
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 1; j < n; j++) {
                    int nextX = p.x + dx[i] * j;
                    int nextY = p.y + dy[i] * j;
                    if (nextX < 0 || nextX >= W || nextY < 0 || nextY >= H) {
                        continue;
                    }
                    if (cloneMap[nextX].get(nextY) != 0) {
                        q.add(new Position(nextX, nextY));
                    }
                }
            }
        }
    }

    public static class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}