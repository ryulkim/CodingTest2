import java.io.*;
import java.util.*;

public class Main {

    static long N;
    static int M;
    static int[] t;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        t = new int[M];
        st = new StringTokenizer(br.readLine());
        int maxT = 0;
        for (int i = 0; i < M; i++) {
            t[i] = Integer.parseInt(st.nextToken());
            maxT = Math.max(maxT, t[i]);
        }

        // time 0에 M명이 바로 탐
        if (N <= M) {
            System.out.println(N);
            return;
        }

        // 이분탐색: count(time) >= N 만족하는 최소 time 찾기
        long lo = 0;
        long hi = (long) maxT * N; // 충분히 큰 상한
        while (lo < hi) {
            long mid = (lo + hi) >>> 1;
            if (count(mid) >= N) hi = mid;
            else lo = mid + 1;
        }
        long time = lo;

        // time-1까지 탑승한 사람 수
        long before = count(time - 1);

        // time에 비는(=time % t[i] == 0) 기구를 번호순으로 채우며 N번째 찾기
        for (int i = 0; i < M; i++) {
            if (time % t[i] == 0) {
                before++;
                if (before == N) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }
    }

    // time까지 총 탑승 인원 (time 0에 M명 포함)
    static long count(long time) {
        if (time < 0) return 0;
        long sum = M;
        for (int i = 0; i < M; i++) {
            sum += time / t[i];
            // (선택) 오버플로/불필요 큰 값 방지: N 이상이면 더 볼 필요 없음
            if (sum >= N) return sum;
        }
        return sum;
    }
}
