import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            sb.append("Pairs for ").append(n).append(":");

            boolean first = true; // 처음 쌍인지 표시

            for (int a = 1; a < n; a++) {
                int b = n - a;

                // a < b 조건을 만족하는 쌍만 사용
                if (a < b) {
                    if (first) {
                        sb.append(" ");
                        first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(a).append(" ").append(b);
                }
            }

            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
