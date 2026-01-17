import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;

        for (int i = 0; i < 5; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x == T) cnt++;
        }

        System.out.println(cnt);
    }
}
