import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        // 홀수 너비는 불가능
        if ((n & 1) == 1) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[Math.max(n + 1, 3)];
        dp[0] = 1;   // 빈 보드 1가지
        dp[1] = 0;   // 참고용
        dp[2] = 3;   // 3x2는 3가지

        // acc = dp[0] + dp[2] + ... 를 한 스텝 늦게 누적
        int acc = 0; 
        for (int i = 4; i <= n; i += 2) {
            acc += dp[i - 4];                // i=4일 때 acc = dp[0]
            dp[i] = dp[i - 2] * 3 + acc * 2; // 점화식
        }

        System.out.println(dp[n]);
    }
}
