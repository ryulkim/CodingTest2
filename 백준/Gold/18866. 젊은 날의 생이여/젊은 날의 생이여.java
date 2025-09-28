import java.io.*;
import java.util.*;

public class Main {
    static final long INF = (long)4e18;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] h = new int[N+1];
        int[] t = new int[N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h[i] = Integer.parseInt(st.nextToken()); // 행복
            t[i] = Integer.parseInt(st.nextToken()); // 피로
        }

        long[] LminH = new long[N+1];
        long[] LmaxT = new long[N+1];
        long[] RmaxH = new long[N+2];
        long[] RminT = new long[N+2];

        // 초기값
        LminH[0] = INF;
        LmaxT[0] = -INF;
        RmaxH[N+1] = -INF;
        RminT[N+1] = INF;

        // 왼쪽 누적(1..i)
        for (int i = 1; i <= N; i++) {
            LminH[i] = LminH[i-1];
            if (h[i] != 0) LminH[i] = Math.min(LminH[i], h[i]);

            LmaxT[i] = LmaxT[i-1];
            if (t[i] != 0) LmaxT[i] = Math.max(LmaxT[i], t[i]);
        }
        // 오른쪽 누적(i..N)
        for (int i = N; i >= 1; i--) {
            RmaxH[i] = RmaxH[i+1];
            if (h[i] != 0) RmaxH[i] = Math.max(RmaxH[i], h[i]);

            RminT[i] = RminT[i+1];
            if (t[i] != 0) RminT[i] = Math.min(RminT[i], t[i]);
        }

        int ans = -1;
        for (int k = N-1; k >= 1; k--) {
            if (LminH[k] > RmaxH[k+1] && LmaxT[k] <= RminT[k+1]) {
                ans = k;
                break; // 가장 큰 k부터 보니 바로 종료
            }
        }
        System.out.println(ans);
    }
}
