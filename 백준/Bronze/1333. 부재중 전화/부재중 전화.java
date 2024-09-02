import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static int N, L, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        // 앨범의 전체 재생 시간 계산
        int totalTime = N * L + (N - 1) * 5;
        int ringTime = 0;

        // 전화벨이 울리는 시간을 찾아본다.
        while (ringTime <= totalTime) {
            // 노래가 재생 중인 구간이면 넘어간다.
            boolean isSilentPeriod = true;
            for (int i = 0; i < N; i++) {
                int songStart = i * (L + 5);
                int songEnd = songStart + L;
                if (ringTime >= songStart && ringTime < songEnd) {
                    isSilentPeriod = false;
                    break;
                }
            }

            // 전화벨이 울리는 시간에 노래가 재생 중이지 않다면 그 시간 출력
            if (isSilentPeriod) {
                System.out.println(ringTime);
                return;
            }

            // 다음 전화벨이 울릴 시간을 계산
            ringTime += D;
        }

        // 앨범이 끝나고 나서 전화벨이 울리는 경우
        System.out.println(ringTime);
    }
}
