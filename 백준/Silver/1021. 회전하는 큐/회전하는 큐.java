import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            int idx = deque.indexOf(target);
            int left = idx;
            int right = deque.size() - idx;

            if (left <= right) {
                // 왼쪽 회전
                for (int j = 0; j < left; j++) {
                    deque.addLast(deque.pollFirst());
                    count++;
                }
            } else {
                // 오른쪽 회전
                for (int j = 0; j < right; j++) {
                    deque.addFirst(deque.pollLast());
                    count++;
                }
            }
            deque.pollFirst(); // 뽑기
        }

        System.out.println(count);
    }
}
