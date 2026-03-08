import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // "/"를 기준으로 문자열을 분리하여 입력받음
        String input = sc.next();
        String[] kda = input.split("/");
        
        int k = Integer.parseInt(kda[0]);
        int d = Integer.parseInt(kda[1]);
        int a = Integer.parseInt(kda[2]);
        
        // 문제의 조건에 따라 판별
        if (k + a < d || d == 0) {
            System.out.println("hasu");
        } else {
            System.out.println("gosu");
        }
        
        sc.close();
    }
}