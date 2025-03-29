import java.util.*;

class Solution {
    ArrayList<Integer> tree[];
    int[] infos;
    int answer = 0;

    public int solution(int[] info, int[][] edges) {
        infos = info;
        init(edges);

        // ✅ 방문한 노드 목록을 저장할 리스트
        List<Integer> visited = new ArrayList<>();

        // ✅ DFS 실행
        dfs(0, new HashSet<>(tree[0]), 1, 0, visited);

        return answer;
    }

    public void dfs(int start, HashSet<Integer> unvisited, int sheep, int wolf, List<Integer> visited) {
        // ✅ 방문한 노드 추가
        visited.add(start);

        // ✅ 방문한 노드 목록 출력
//        System.out.println("Visited nodes so far: " + visited);

        if (sheep <= wolf) {
//        	System.out.println("Visited nodes so far: " + visited);
//            System.out.println("🛑 Stopping at node " + start + " (wolves >= sheep)");
            return;
        }

        answer = Math.max(answer, sheep);

        if (unvisited.isEmpty()) return;

        unvisited.remove(start);

        for (int nxt : tree[start]) {
            unvisited.add(nxt);
        }

        for (int num : new HashSet<>(unvisited)) {
            HashSet<Integer> newHashSet = new HashSet<>(unvisited);
            List<Integer> newVisited = new ArrayList<>(visited); // ✅ 현재 방문 경로를 새로운 리스트로 복사
            dfs(num, newHashSet, sheep + (infos[num] == 0 ? 1 : 0), wolf + (infos[num] == 1 ? 1 : 0), newVisited);
        }
    }

    public void init(int[][] edges) {
        int sz = edges.length + 1;
        tree = new ArrayList[sz];

        for (int i = 0; i < sz; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int par = edge[0];
            int child = edge[1];
            tree[par].add(child);
        }
    }
}
