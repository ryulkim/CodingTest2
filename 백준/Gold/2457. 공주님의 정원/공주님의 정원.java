import java.io.*;
import java.util.*;

public class Main {
    static class Flower implements Comparable<Flower> {
        int start;
        int end;

        public Flower(int sm, int sd, int em, int ed) {
            this.start = sm * 100 + sd;
            this.end = em * 100 + ed;
        }

        @Override
        public int compareTo(Flower o) {
            if (this.start == o.start) return o.end - this.end;
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            flowers[i] = new Flower(sm, sd, em, ed);
        }

        Arrays.sort(flowers);

        int today = 301;
        int end = 1201;
        int idx = 0;
        int maxEnd = 0;
        int count = 0;

        while (today < end) {
            boolean found = false;

            while (idx < N && flowers[idx].start <= today) {
                if (flowers[idx].end > maxEnd) {
                    maxEnd = flowers[idx].end;
                    found = true;
                }
                idx++;
            }

            if (!found) {
                System.out.println(0);
                return;
            }

            today = maxEnd;
            count++;
        }

        System.out.println(count);
    }
}
