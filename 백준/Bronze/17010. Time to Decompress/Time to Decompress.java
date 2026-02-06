import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            for (int j = 0; j < k; j++) {
                sb.append(c);
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
