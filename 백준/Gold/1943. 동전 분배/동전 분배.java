import java.io.*;
import java.util.*;

public class Main {

    static int N, sum;
    static ArrayList<int[]> arr;
    static boolean[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        for (int t = 0; t < 3; t++) {
            if (solve(br)) sb.append("1\n");
            else sb.append("0\n");
        }
        System.out.print(sb);
    }

    static boolean solve(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        sum = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            arr.add(new int[]{price, cnt});
            sum += price * cnt;
        }

        if (sum % 2 != 0) return false;

        int target = sum / 2;
        dp = new boolean[target + 1];
        dp[0] = true;

        List<Integer> coins = new ArrayList<>();
        for (int[] a : arr) {
            int price = a[0];
            int cnt = a[1];
            int mul = 1;
            while (cnt - mul > 0) {
                coins.add(price * mul);
                cnt -= mul;
                mul *= 2;
            }
            if (cnt > 0) {
                coins.add(price * cnt);
            }
        }

        for (int coin : coins) {
            for (int j = target; j >= coin; j--) {
                if (dp[j - coin]) dp[j] = true;
            }
        }

        return dp[target];
    }
}
