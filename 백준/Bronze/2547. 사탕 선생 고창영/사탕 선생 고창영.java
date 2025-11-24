import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            String line;
            
            while ((line = br.readLine()).trim().isEmpty());

            int N = Integer.parseInt(line);
            long sum = 0;

            for (int i = 0; i < N; i++) {
                long candy = Long.parseLong(br.readLine().trim());
                sum = (sum + candy % N) % N;
            }

            if (sum % N == 0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}