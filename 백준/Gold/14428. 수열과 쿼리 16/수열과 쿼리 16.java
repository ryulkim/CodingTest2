import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr, tree;

    public static void main(String[] args) throws IOException {
        init();
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tree = new int[4 * N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        build(0, N - 1, 1); // 세그먼트 트리 초기화

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                update(0, N - 1, a - 1, b, 1);
            } else {
                int result = query(0, N - 1, a - 1, b - 1, 1);
                sb.append(result + 1).append("\n"); // 1-based index 출력
            }
        }

        System.out.println(sb);
    }

    // 트리 초기화: 구간 [s, e]에서 최소값의 인덱스를 저장
    public static void build(int s, int e, int idx) {
        if (s == e) {
            tree[idx] = s;
            return;
        }

        int mid = (s + e) / 2;
        build(s, mid, idx * 2);
        build(mid + 1, e, idx * 2 + 1);

        int l = tree[idx * 2];
        int r = tree[idx * 2 + 1];
        tree[idx] = compareIndex(l, r);
    }

    // 쿼리: [ts, te] 범위의 최소값 인덱스를 반환
    public static int query(int s, int e, int ts, int te, int idx) {
        if (e < ts || te < s) return -1; // 범위 밖

        if (ts <= s && e <= te) {
            return tree[idx];
        }

        int mid = (s + e) / 2;
        int l = query(s, mid, ts, te, idx * 2);
        int r = query(mid + 1, e, ts, te, idx * 2 + 1);

        if (l == -1) return r;
        if (r == -1) return l;
        return compareIndex(l, r);
    }

    // 업데이트: arr[target] = value, 그리고 트리 갱신
    public static int update(int s, int e, int target, int value, int idx) {
        if (target < s || target > e) return tree[idx];

        if (s == e) {
            arr[target] = value;
            return tree[idx] = target;
        }

        int mid = (s + e) / 2;
        int l = update(s, mid, target, value, idx * 2);
        int r = update(mid + 1, e, target, value, idx * 2 + 1);

        return tree[idx] = compareIndex(l, r);
    }

    // 두 인덱스 중 arr값이 더 작은 쪽을 반환, 같으면 인덱스가 더 작은 쪽
    public static int compareIndex(int a, int b) {
        if (arr[a] == arr[b]) return Math.min(a, b);
        return arr[a] < arr[b] ? a : b;
    }
}
