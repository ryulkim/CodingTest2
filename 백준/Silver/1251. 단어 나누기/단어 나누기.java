import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String reverse(String x) {
        return new StringBuilder(x).reverse().toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        int n = s.length();

        String best = null;

        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                String a = s.substring(0, i);
                String b = s.substring(i, j);
                String c = s.substring(j);

                String cand = reverse(a) + reverse(b) + reverse(c);

                if (best == null || cand.compareTo(best) < 0) {
                    best = cand;
                }
            }
        }

        System.out.println(best);
    }
}
