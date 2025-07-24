import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, sum;
	static boolean[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < 3; t++) {
			N = Integer.parseInt(br.readLine());
			int[] price = new int[N];
			int[] count = new int[N];
			sum = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				price[i] = Integer.parseInt(st.nextToken());
				count[i] = Integer.parseInt(st.nextToken());
				sum += price[i] * count[i];
			}

			if (sum % 2 == 1) {
				sb.append(0).append("\n");
				continue;
			}

			int target = sum / 2;
			dp = new boolean[target + 1];
			dp[0] = true;

			for (int i = 0; i < N; i++) {
				int p = price[i];
				int c = count[i];

				// 동전 개수를 이진 분할하여 0-1 knapsack으로 처리
				for (int k = 1; c > 0; k <<= 1) {
					int use = Math.min(k, c);
					int cost = use * p;

					for (int j = target; j >= cost; j--) {
						if (dp[j - cost]) dp[j] = true;
					}
					c -= use;
				}
			}

			sb.append(dp[target] ? 1 : 0).append("\n");
		}
		System.out.println(sb);
	}
}
