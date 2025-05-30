import java.io.*;
import java.util.*;

public class Main {

    static int K, N;
    static int[] dp, cnt;

    public static void main(String[] args) throws IOException {
        init();
        proc();
        System.out.println(dp[K]);
        System.out.println(cnt[K]);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[200_001];
        cnt = new int[200_001];
        Arrays.fill(dp, Integer.MAX_VALUE);
    }

    public static void proc() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{N, 0});
        dp[N] = 0;
        cnt[N] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int time = cur[1];

            for (int next : new int[]{x - 1, x + 1, x * 2}) {
                if (next < 0 || next > 200000) continue;

                if (dp[next] == time + 1) {
                    cnt[next] += cnt[x];  // 같은 시간에 도달하는 경우 (다른 경로)
                } else if (dp[next] > time + 1) {
                    dp[next] = time + 1;
                    cnt[next] = cnt[x];
                    q.add(new int[]{next, time + 1});
                }
            }
        }
    }
}
