import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<long[]> arr;

    public static void main(String[] args) throws Exception {
        init();
        double area = proc();
        System.out.printf("%.1f%n", area); // 소수 첫째 자리
    }

    public static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            arr.add(new long[]{x, y});
        }
    }

    public static double proc() {
        long crossSum = 0L;
        for (int i = 0; i < N; i++) {
            int j = (i + 1) % N; // 마지막과 첫 점 연결
            long[] a = arr.get(i);
            long[] b = arr.get(j);
            crossSum += a[0] * b[1] - a[1] * b[0]; // long*long -> long
        }
        return Math.abs(crossSum) / 2.0; // 절댓값 + 실수 나눗셈
    }
}
