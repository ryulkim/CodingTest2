import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < T; i++) {
            long n = Long.parseLong(br.readLine().trim());
            sb.append(n * n).append('\n');
        }

        System.out.print(sb.toString());
    }
}
