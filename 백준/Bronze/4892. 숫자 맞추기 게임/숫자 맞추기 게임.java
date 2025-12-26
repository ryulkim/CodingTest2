import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int idx = 1;
        while (true) {
            String line = br.readLine();
            if (line == null) break;

            long n0 = Long.parseLong(line.trim());
            if (n0 == 0) break;

            long n1 = 3 * n0;

            String parity;
            long n2;
            if (n1 % 2 == 0) {
                parity = "even";
                n2 = n1 / 2;
            } else {
                parity = "odd";
                n2 = (n1 + 1) / 2;
            }

            long n3 = 3 * n2;
            long n4 = n3 / 9;

            sb.append(idx).append(". ").append(parity).append(" ").append(n4).append("\n");
            idx++;
        }

        System.out.print(sb.toString());
    }
}
