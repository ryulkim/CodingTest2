#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

long long dp[200005];


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, x;
    long long ans = 1;
    vector<int> v;

    cin >> n;
    v.push_back(0);

    for (int i = 0; i < n; i++) {
        cin >> x;
        v.push_back(x);
    }

    dp[n] = 1;

    for (int i = n-1; i > 0; i--) {
        if (i + v[i] > n) {
            dp[i] = 1;
        }
        else {
            dp[i] = dp[i + v[i]+1] + 1;
        }
    }

    for (int i = 1; i <= n; i++) {
        cout << dp[i] << ' ';
    }
}