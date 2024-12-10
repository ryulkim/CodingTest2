import java.io.*;
import java.util.*;

public class Main {

    static int[] tree;
    static int[] skills;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 선수 수 입력
        N = Integer.parseInt(br.readLine());
        skills = new int[N];
        int[] originalSkills = new int[N];

        // 실력값 입력
        for (int i = 0; i < N; i++) {
            originalSkills[i] = Integer.parseInt(br.readLine());
            skills[i] = originalSkills[i];
        }

        // 1. 좌표 압축
        Arrays.sort(skills);
        Map<Integer, Integer> compressionMap = new HashMap<>();
        int rank = 1; // Fenwick Tree는 1-based indexing
        for (int skill : skills) {
            if (!compressionMap.containsKey(skill)) {
                compressionMap.put(skill, rank++);
            }
        }

        // 2. Fenwick Tree 준비
        tree = new int[rank]; // 좌표 압축된 범위 크기만큼

        // 3. 최선 등수 계산
        for (int i = 0; i < N; i++) {
            int compressedSkill = compressionMap.get(originalSkills[i]);

            // 1. 현재 값보다 낮은 값의 개수 구하기
            int betterRank = query(compressedSkill - 1);

            // 2. 최선 등수 계산
            sb.append(i - betterRank + 1).append("\n");

            // 3. Fenwick Tree 업데이트
            update(compressedSkill, 1);
        }

        // 결과 출력
        System.out.print(sb.toString());
    }

    // Fenwick Tree에서 1 ~ idx까지의 합을 계산
    static int query(int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += tree[idx];
            idx -= (idx & -idx); // LSB 제거
        }
        return sum;
    }

    // Fenwick Tree에서 idx 위치에 value를 추가
    static void update(int idx, int value) {
        while (idx < tree.length) {
            tree[idx] += value;
            idx += (idx & -idx); // LSB 추가
        }
    }
}
