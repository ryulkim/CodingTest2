#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

long long dp[103][12];
int mod = 1000000000;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;

    cin >> n;

    for (int i = 1; i <= 9; i++) {
        dp[1][i] = 1;
    }

    for (int i = 1; i < n; i++) {
        for (int j = 0; j < 10; j++) {
            if (j == 0) {
                dp[i + 1][1] += dp[i][0];
                dp[i + 1][1] %= mod;
            }
            else if (j == 9) {
                dp[i + 1][8] += dp[i][9];
                dp[i + 1][8] %= mod;
            }
            else {
                dp[i + 1][j - 1] += dp[i][j];
                dp[i + 1][j + 1] += dp[i][j];
                dp[i + 1][j - 1] %= mod;
                dp[i + 1][j + 1] %= mod;
            }
        }
    }

    long long ans = 0;

    for (int i = 0; i <= 9; i++) {
        ans += dp[n][i];
        ans %= mod;
    }

    cout << ans << '\n';
}