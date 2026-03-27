import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        
        // A는 항상 110의 배수이므로 나누기 1.1 연산
        System.out.println((a / 11) * 10);
    }
}