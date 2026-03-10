import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 노트북 가로(wc), 세로(hc), 스티커 가로(ws), 세로(hs) 입력
        int wc = sc.nextInt();
        int hc = sc.nextInt();
        int ws = sc.nextInt();
        int hs = sc.nextInt();

        // 양옆, 위아래 1cm씩 총 2cm 이상의 여유가 있는지 확인
        if (ws <= wc - 2 && hs <= hc - 2) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        sc.close();
    }
}