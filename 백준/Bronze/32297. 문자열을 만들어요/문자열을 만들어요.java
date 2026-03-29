import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫째 줄: 문자열의 길이 N (이 문제에서는 사실 N을 직접 쓰지 않아도 무방합니다)
        int n = Integer.parseInt(br.readLine());
        
        // 둘째 줄: 문자열 S
        String s = br.readLine();
        
        // "gori"가 포함되어 있는지 확인
        if (s.contains("gori")) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}