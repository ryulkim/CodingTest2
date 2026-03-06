import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 상금 N 입력 (상금은 1,000의 배수이므로 int 범위 내)
        int n = sc.nextInt();
        
        // 케이스 1: 전체의 22%를 세금으로 제외 (78% 수령)
        int case1 = (int)(n * 0.78);
        
        // 케이스 2: 80%는 경비 인정, 나머지 20%의 22%만 세금으로 제외
        // 즉, 전체의 4.4% (0.2 * 0.22)가 세금임
        int case2 = (int)(n - (n * 0.2 * 0.22));
        
        System.out.println(case1 + " " + case2);
        
        sc.close();
    }
}