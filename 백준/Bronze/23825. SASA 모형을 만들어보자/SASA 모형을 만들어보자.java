import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // S 블록의 개수 N, A 블록의 개수 M 입력
        long n = sc.nextLong();
        long m = sc.nextLong();
        
        // 각 블록을 2로 나눈 몫 중 더 작은 값이 만들 수 있는 최대 세트 수
        long sPairs = n / 2;
        long aPairs = m / 2;
        
        System.out.println(Math.min(sPairs, aPairs));
        
        sc.close();
    }
}