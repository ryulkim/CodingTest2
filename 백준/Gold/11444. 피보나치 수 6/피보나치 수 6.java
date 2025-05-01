import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final long[][] BASIC = {{1, 1}, {1, 0}};
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long[][] result = power(N);
        System.out.println(result[0][1]);
    }

    public static long[][] power(long n) {
        if (n == 1) return BASIC;

        long[][] half = power(n / 2);
        long[][] result = multiply(half, half);

        if (n % 2 == 1) {
            result = multiply(result, BASIC);
        }

        return result;
    }

    public static long[][] multiply(long[][] a, long[][] b) {
        long[][] res = new long[2][2];

        res[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD;
        res[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
        res[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
        res[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;

        return res;
    }
}
