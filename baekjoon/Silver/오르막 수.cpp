#include <iostream>
#include <algorithm>

using namespace std;

int dp[12];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, ans = 0;
    cin >> n;

    for (int i = 0; i < 10; i++) {
        dp[i] = 1;
    }

    for (int i = 1; i < n; i++) {
        for (int j = 1; j < 10; j++) {
            dp[j] += dp[j-1];
            dp[j] = dp[j] % 10007;
        }
    }

    for (int i = 0; i < 10; i++) {
        ans += dp[i];
    }

    cout << ans % 10007 << '\n';
}
