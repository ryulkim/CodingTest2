#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<pair<int,int>> g[10002];
int node;

int bfs(int start) {
    queue<pair<int,int>> q;
    q.push({ start,0 });
    int max = 0;
    bool visited[10002] = { 0, };
    visited[start] = 1;

    while (!q.empty()) {
        int f = q.front().first;
        int w = q.front().second;
        if (w > max) {
            max = w;
            node = f;
        }
        q.pop();

        for (int i = 0; i < g[f].size(); i++) {
            if (visited[g[f][i].first] == 0) {
                q.push({ g[f][i].first,g[f][i].second + w });
                visited[g[f][i].first] = 1;
            }
        }
    }
    
    return max;
}


int main() {
    int n, p, c, w;
    int max = 0;
    cin >> n;

    for (int i = 0; i < n-1; i++) {
        cin >> p >> c >> w;

        g[p].push_back({ c,w });
        g[c].push_back({ p,w });
    }

    bfs(1);
    max=bfs(node);

    
    cout << max << '\n';
}
