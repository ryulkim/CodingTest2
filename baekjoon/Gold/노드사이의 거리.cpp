#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<pair<int,int>> v[1002];

int bfs(int start, int goal) {
    queue<pair<int, int>> q;
    bool check[1002] = { 0, };

    q.push({ start, 0 });
    
    while (!q.empty()&&q.front().first != goal) {
        int a = q.front().first;
        int b = q.front().second;
        int sz = v[a].size();
        q.pop();

        for (int i = 0; i < sz; i++) {
            int x = v[a][i].first;
            int y = v[a][i].second;

            if (check[x] == 0) {
                q.push({ x,b + y });
                check[x] = 1;
            }
        }
    }

    return q.front().second;
}



int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, a, b, c;
      
    cin >> n >> m;
    
    for (int i = 0; i < n-1; i++) {
        cin >> a >> b >> c;

        v[a].push_back({ b,c });
        v[b].push_back({ a,c });
    }

    for (int i = 0; i < m; i++) {
        cin >> a >> b;
        cout << bfs(a, b) << '\n';
    }
}
