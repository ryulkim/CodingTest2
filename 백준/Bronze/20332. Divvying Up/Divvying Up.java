import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        long sum = 0;
        int cnt = 0;

        // n개의 정수가 한 줄에만 온다는 보장이 없어도 되게 처리
        while (cnt < n) {
            String line = br.readLine();
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens() && cnt < n) {
                sum += Long.parseLong(st.nextToken());
                cnt++;
            }
        }

        System.out.println(sum % 3 == 0 ? "yes" : "no");
    }
}