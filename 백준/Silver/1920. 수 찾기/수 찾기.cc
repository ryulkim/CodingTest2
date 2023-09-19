#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, x;
    vector<int> v1, v2;

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> x;
        v1.push_back(x);
    }

    sort(v1.begin(), v1.end());

    cin >> m;

    for (int i = 0; i < m; i++) {
        cin >> x;
        auto check = [&](int i) {
            if (i == -1) return false;
            if (i == n)return true;
            if (v1[i] < x) return false;
            return true;
        };

        int lo = -1, hi = n;
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (check(mid) == check(lo))lo = mid;
            else hi = mid;
        }

        if (hi<n&&v1[hi] == x)cout << 1 << '\n';
        else cout << 0 << '\n';
    }
    
}