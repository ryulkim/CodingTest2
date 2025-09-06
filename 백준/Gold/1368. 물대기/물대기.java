import java.io.*;
import java.util.*;

public class Main {

    static class DSU {
        int[] p, r;
        DSU(int n){ p=new int[n]; r=new int[n]; for(int i=0;i<n;i++) p[i]=i; }
        int find(int x){ return p[x]==x? x:(p[x]=find(p[x])); }
        boolean union(int a,int b){
            a=find(a); b=find(b);
            if(a==b) return false;
            if(r[a]<r[b]) { int t=a; a=b; b=t; }
            p[b]=a;
            if(r[a]==r[b]) r[a]++;
            return true;
        }
    }

    static class Edge {
        int u,v,w;
        Edge(int u,int v,int w){ this.u=u; this.v=v; this.w=w; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cost = new int[N+1]; // 1..N (0은 가상노드)
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }

        ArrayList<Edge> edges = new ArrayList<>();

        // 파이프 비용 인접행렬 입력: i<j만 간선 추가 (중복 방지)
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int c = Integer.parseInt(st.nextToken());
                if (j > i && c != 0) edges.add(new Edge(i, j, c));
            }
        }

        // 가상 정점(0)에서 각 정점으로 우물 간선 추가
        for (int i = 1; i <= N; i++) {
            edges.add(new Edge(0, i, cost[i]));
        }

        // 크루스칼 MST
        edges.sort(Comparator.comparingInt(e -> e.w));
        DSU dsu = new DSU(N+1);
        long ans = 0;
        int used = 0;
        for (Edge e : edges) {
            if (dsu.union(e.u, e.v)) {
                ans += e.w;
                used++;
                if (used == N) break; // N+1개의 정점 → MST 간선 N개면 종료
            }
        }

        System.out.println(ans);
    }
}
