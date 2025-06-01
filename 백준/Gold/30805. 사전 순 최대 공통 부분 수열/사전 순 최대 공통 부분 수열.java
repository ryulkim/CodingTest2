import java.io.*;
import java.util.*;

public class Main {

    static class Num implements Comparable<Num> {
        int value;
        int idx;

        public Num(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        // 숫자를 내림차 순으로
        // 같다면 인덱스 오름차순으로
        @Override
        public int compareTo(Num o) {
            return this.value == o.value ? this.idx - o.idx : o.value - this.value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int m = Integer.parseInt(br.readLine());
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        // 값이 더 큰 것 대로, 같다면 인덱스가 더 앞인 것으로
        // A 수열의 최대값 순으로 우선순위큐에 저장
        PriorityQueue<Num> Apq = new PriorityQueue<>();

        // B 수열의 최댓값 순으로 우선순위큐에 저장
        PriorityQueue<Num> Bpq = new PriorityQueue<>();

        // 큰 값 순으로 정렬해서 Apq에 담음
        for (int i = 0; i < n; i++) {
            Apq.add(new Num(A[i], i));
        }

        int start = 0; // B 배열에서 탐색 시작 위치
        int limitIdx = -1; // 이미 선택된 A 값들의 인덱스보다 앞선 값은 무시하기 위한 기준

        // A의 큰 값부터 B에서 순차적으로 대응되는 값 찾기
        while (!Apq.isEmpty() ) {
            Num nextMax = Apq.poll();

            for (int i = start; i < m; i++) {
                // 다음 큰 값이 B[i] 와 같고, 이전 선택된 최댓값의 인덱스 값보다 크다면
                if (nextMax.value == B[i] && limitIdx < nextMax.idx) {
                    Bpq.add(new Num(nextMax.value, i));

                    start = i + 1; // 탐색 범위를 다음으로 지정
                    limitIdx = nextMax.idx; // 큰 값의 인덱스를 현재 맥스값으로 갱신
                    break;
                }
            }
        }

        // 정답 작성
        StringBuilder sb = new StringBuilder();
        sb.append(Bpq.size()).append("\n");

        while (!Bpq.isEmpty()) {
            sb.append(Bpq.poll().value).append(" ");
        }

        System.out.println(sb.toString());

    }




}