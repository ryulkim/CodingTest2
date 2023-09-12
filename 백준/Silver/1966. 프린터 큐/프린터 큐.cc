#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int t, n, m, x;

    cin >> t;

    for (int i = 0; i < t; i++) {
        queue<pair<int, int>> q;
        vector<int> v;
        cin >> n >> m;
        for (int j = 0; j < n; j++) {
            cin >> x;
            v.push_back(x);
            q.push({ x,j });
        }

        sort(v.begin(), v.end(), greater<int>());

        int ans = 1;
        while (!q.empty()) {
            if (q.front().first == v[ans - 1]) {
                if (q.front().second == m) break;
                else ans++;
            }
            else q.push(q.front());

            q.pop();
        }
        cout << ans << '\n';
    }

    
}