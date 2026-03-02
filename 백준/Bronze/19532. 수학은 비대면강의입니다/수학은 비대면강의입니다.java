import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        // 완전 탐색 (Brute Force)
        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                // 두 식을 모두 만족하는지 확인
                if (a * x + b * y == c && d * x + e * y == f) {
                    System.out.println(x + " " + y);
                    return; // 답을 찾으면 즉시 종료
                }
            }
        }
    }
}