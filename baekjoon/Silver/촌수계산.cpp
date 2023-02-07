#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int arr[103];
vector<int> v[103];

void bfs(int start, int end) {
    queue<int> q;
    
    q.push(start);
    arr[start] = 0;

    while (!q.empty()) {
        int a = q.front();
        q.pop();
        int sz = v[a].size();

        for (int i = 0; i < sz; i++) {
            if (arr[v[a][i]] == 0&&v[a][i]!=start) {
                arr[v[a][i]] = arr[a] + 1;
                q.push(v[a][i]);
            }
        }
    }
}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, a, b, x, y;
    
    cin >> n;
    cin >> a >> b;
    cin >> m;

    for (int i = 0; i < m; i++) {
        cin >> x >> y;
        v[x].push_back(y);
        v[y].push_back(x);
    }

    bfs(a,b);

    if (arr[b] == 0) {
        cout << -1 << '\n';
    }
    else {
        cout << arr[b] << '\n';
    }
}
