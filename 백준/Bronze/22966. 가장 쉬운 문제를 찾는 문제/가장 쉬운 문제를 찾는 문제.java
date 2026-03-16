import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문제의 개수 N
        int n = sc.nextInt();
        
        String easiestProblem = "";
        int minDifficulty = 5; // 문제 조건상 난이도는 1~4이므로 5로 초기화

        for (int i = 0; i < n; i++) {
            String title = sc.next();
            int difficulty = sc.nextInt();

            // 현재 저장된 난이도보다 낮으면 갱신
            if (difficulty < minDifficulty) {
                minDifficulty = difficulty;
                easiestProblem = title;
            }
        }

        System.out.println(easiestProblem);
        sc.close();
    }
}