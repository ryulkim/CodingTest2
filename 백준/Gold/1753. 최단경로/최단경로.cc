#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#define SZ 20002
#define INF 200005
using namespace std;

vector<pair<int, int>> graph[SZ];
vector<int> dist(SZ, INF);

void dijk(int start) {
    priority_queue<pair<int, int>> pq;

    dist[start] = 0;
    pq.push({ 0, start });

    while (!pq.empty()) {
        int w = -pq.top().first;
        int v = pq.top().second;
        pq.pop();

        if (dist[v] < w) continue;
        
        int sz = graph[v].size();

        for (int i = 0; i < sz; i++) {
            int ncost = graph[v][i].second;
            int nxt= graph[v][i].first;
            int cost = dist[v] + ncost;
            
            if (dist[nxt] > cost) {
                dist[nxt] = cost;
                pq.push({ -cost, nxt });
            }
        }
    }
}



int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int V, E, k, u, v, w;
    
    

    cin >> V >> E >> k;

    for (int i = 0; i < E; i++) {
        cin >> u >> v >> w;
        
        graph[u].push_back({ v,w });
    }

    dijk(k);

    for (int i = 1; i <= V; i++) {
        if (dist[i] == INF) {
            cout << "INF\n";
        }
        else cout << dist[i] << '\n';
    }

}

/*
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
*/