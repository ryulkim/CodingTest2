import java.io.*;
import java.util.*;

public class Main {

    static class Town {
        long x;   // 위치
        long a;   // 인구

        Town(long x, long a) {
            this.x = x;
            this.a = a;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Town[] arr = new Town[N];
        long total = 0; // 전체 인구 수

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            arr[i] = new Town(x, a);
            total += a;
        }

        // 위치 기준 오름차순 정렬
        Arrays.sort(arr, Comparator.comparingLong(t -> t.x));

        long target = (total + 1) / 2; // 절반 이상
        long sum = 0;

        // 누적 인구가 절반 이상 되는 첫 위치 출력
        for (int i = 0; i < N; i++) {
            sum += arr[i].a;
            if (sum >= target) {
                System.out.println(arr[i].x);
                break;
            }
        }
    }
}
