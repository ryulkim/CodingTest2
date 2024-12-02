import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static boolean[][] isPalindrome;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        isPalindrome = new boolean[N][N];
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 팰린드롬 초기화
        for (int i = 0; i < N; i++) {
            isPalindrome[i][i] = true; // 길이 1
            if (i + 1 < N && arr[i] == arr[i + 1]) {
                isPalindrome[i][i + 1] = true; // 길이 2
            }
        }

        // 다이나믹 프로그래밍으로 팰린드롬 여부 계산
        for (int len = 2; len < N; len++) { // 길이 3 이상
            for (int start = 0; start + len < N; start++) {
                int end = start + len;
                if (arr[start] == arr[end] && isPalindrome[start + 1][end - 1]) {
                    isPalindrome[start][end] = true;
                }
            }
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;

            sb.append(isPalindrome[s][e] ? 1 : 0).append("\n");
        }

        System.out.print(sb.toString());
    }
}
