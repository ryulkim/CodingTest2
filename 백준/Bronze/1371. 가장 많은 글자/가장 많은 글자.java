import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] counts = new int[26]; // a-z 빈도수 저장용
        int maxCount = 0;

        // 1. EOF(입력 끝)까지 읽기
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                // 소문자인 경우만 체크
                if (ch >= 'a' && ch <= 'z') {
                    counts[ch - 'a']++;
                    // 실시간으로 최대 빈도수 갱신
                    maxCount = Math.max(maxCount, counts[ch - 'a']);
                }
            }
        }

        // 2. 최대 빈도수를 가진 알파벳들 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (counts[i] == maxCount) {
                sb.append((char) (i + 'a'));
            }
        }
        
        System.out.println(sb.toString());
        sc.close();
    }
}