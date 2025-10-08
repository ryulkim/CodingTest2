import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int sum;

    public static void main(String[] args) throws Exception {
        System.out.println(init());
    }
        
    public static int init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        // --- 1) 1~9 구간: 실제 개수로 처리 ---
        int firstCnt = Math.min(N, 9);
        if (K <= firstCnt) {
            // "123456789"의 K번째 → 그대로 K
            return K;
        }
        sum = firstCnt;     // 누적 길이를 실제 개수로 설정
        // K는 그대로 두고, 아래에서 sum과 비교(sum >= K)로 판정

        // --- 2) 10단위 블록: i=1 -> 10..19, i=2 -> 20..29, ...
        for (int i = 1; i <= N / 10; i++) {
            int start = i * 10;                 // 블록 시작
            int len = (int) Math.log10(i) + 2;  // 이 블록의 자리수 (i*10의 자리수)
            int cnt = Math.min(10, N - start + 1); // ★ 실제 개수 (마지막 블록 보정)
            sum += cnt * len;                   // ★ 과거의 10*len 대신 cnt*len

            if (sum >= K) {
                int delta = sum - K;            // 블록의 '끝'에서 K까지 남은 문자 수
                int q = delta / len;            // K 뒤에 있는 "숫자 개수"
                int r = delta % len;            // 그 다음 숫자 내부에서 남은 자리 수

                int end = start + cnt - 1;      // ★ 이 블록의 실제 끝값
                int value = end - q;            // 끝에서 q개 뒤로 이동

                if (r == 0) {
                    return value % 10;          // 마지막 자리
                } else {
                    String s = Integer.toString(value);
                    int pos = len - r - 1;      // ★ 교정된 자리 인덱스 (왼쪽 기준)
                    return s.charAt(pos) - '0';
                }
            }
        }

        // 총 길이가 K보다 짧으면
        return -1;
    }
}
