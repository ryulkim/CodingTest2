import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 준비된 치킨의 양 N
        int n = sc.nextInt();
        
        // 각 치킨을 선호하는 인원 A, B, C
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        // 결과 계산: 각 종류별로 N명까지만 배부 가능
        int total = 0;
        total += Math.min(a, n);
        total += Math.min(b, n);
        total += Math.min(c, n);
        
        System.out.println(total);
        
        sc.close();
    }
}