import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] count = new int[2][7]; // [성별][학년]

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); // 0: 여, 1: 남
            int Y = Integer.parseInt(st.nextToken()); // 1 ~ 6

            count[S][Y]++;
        }

        int rooms = 0;

        for (int s = 0; s <= 1; s++) {
            for (int y = 1; y <= 6; y++) {
                if (count[s][y] == 0) continue;
                rooms += (count[s][y] + K - 1) / K; // 올림 나눗셈
            }
        }

        System.out.println(rooms);
    }
}
