import java.util.*;

class Solution {
    int seq = 1;
    Map<String, Integer> dict;
    List<Integer> out;

    public int[] solution(String msg) {
        init();
        compress(msg);
        int[] answer = new int[out.size()];
        for (int i = 0; i < out.size(); i++) answer[i] = out.get(i);
        return answer;
    }

    void init() {
        dict = new HashMap<>(512);
        out = new ArrayList<>(msgCapacityHint(1000)); // 선택: 대략적 용량 힌트
        for (char c = 'A'; c <= 'Z'; c++) {
            dict.put(String.valueOf(c), seq++);
        }
    }

    void compress(String msg) {
        int n = msg.length();
        int i = 0;
        while (i < n) {
            int j = i + 1;
            int lastIdx = -1;      // 가장 긴 일치의 인덱스
            int lastEnd = i;       // 가장 긴 일치의 끝 위치(미포함)

            // 가장 긴 일치 w 찾기
            while (j <= n) {
                String s = msg.substring(i, j);
                Integer idx = dict.get(s);
                if (idx == null) break; // 여기서 처음 미스
                lastIdx = idx;
                lastEnd = j;
                j++;
            }

            // w 출력
            out.add(lastIdx);

            // w 다음 글자 c가 존재하면 w+c 사전에 추가
            if (lastEnd < n) { // 아직 남은 글자가 있다면
                String wPlusC = msg.substring(i, lastEnd + 1); // w + c
                if (!dict.containsKey(wPlusC)) {
                    dict.put(wPlusC, seq++);
                }
            }

            // 다음 탐색 시작 지점 = w 바로 뒤
            i = lastEnd;
        }
    }

    // 선택: 대략적인 크기 힌트 (없어도 됩니다)
    int msgCapacityHint(int fallback) { return fallback; }
}
