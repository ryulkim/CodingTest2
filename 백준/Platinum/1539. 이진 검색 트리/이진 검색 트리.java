import java.io.*;
import java.util.*;

public class Main {
    static TreeMap<Integer, Integer> map = new TreeMap<>();
    static long sum = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            Integer lower = map.lowerKey(x);
            Integer higher = map.higherKey(x);

            int depth = 1;
            if (lower != null && higher != null) {
                depth = Math.max(map.get(lower), map.get(higher)) + 1;
            } else if (lower != null) {
                depth = map.get(lower) + 1;
            } else if (higher != null) {
                depth = map.get(higher) + 1;
            }

            map.put(x, depth);
            sum += depth;
        }

        System.out.println(sum);
    }
}
