import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] g = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) g[i][j] = line.charAt(j);
        }

        int emptyRow = 0;
        for (int i = 0; i < N; i++) {
            boolean hasX = false;
            for (int j = 0; j < M; j++) {
                if (g[i][j] == 'X') { hasX = true; break; }
            }
            if (!hasX) emptyRow++;
        }

        int emptyCol = 0;
        for (int j = 0; j < M; j++) {
            boolean hasX = false;
            for (int i = 0; i < N; i++) {
                if (g[i][j] == 'X') { hasX = true; break; }
            }
            if (!hasX) emptyCol++;
        }

        System.out.println(Math.max(emptyRow, emptyCol));
    }
}
