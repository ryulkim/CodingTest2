#include <iostream>
#include <vector>


using namespace std;

int dp[100003][3];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;

    cin >> n;

    dp[0][0] = 1; //아무것도 놓지 않는 경우
    dp[0][1] = 1; //1번
    dp[0][2] = 1; //2번

    for (int i = 1; i < n; i++) {
        dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
        dp[i][1] = dp[i - 1][0] +  dp[i - 1][2];
        dp[i][2] = dp[i - 1][0] + dp[i - 1][1];

        dp[i][0] %= 9901;
        dp[i][1] %= 9901;
        dp[i][2] %= 9901;
    }

    cout << (dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2])%9901 << '\n';
}
