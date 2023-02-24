#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, x;
    vector<int> v;
    int ans=0;

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> x;
        v.push_back(x);
    }
    sort(v.begin(), v.end(),greater<int>());


    for (int i = 0; i < n - 2; i++) {
        if (v[i] < v[i + 1] + v[i + 2]) {
            ans = v[i] + v[i + 1] + v[i + 2];
            break;
        }
    }

    if (ans == 0) {
        cout << -1 << '\n';
    }
    else {
        cout << ans << '\n';
    }
}
