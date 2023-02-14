#include <iostream>
#include <vector>

using namespace std;

unsigned int dp[203][202];//i번째 줄은 더한 개수, j번째 줄은 합, 값은 개수

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k;
    
    cin >> n >> k;

    for (int i = 0; i <= n; i++) {
        dp[1][i] = 1;
    }

    for (int i = 2; i <= k; i++) {
        for (int j = 0; j <= n; j++) { //0부터 n까지 더하기
            for (int x = 0; x <= n; x++) { //n보다 큰 합은 구할 필요가 없다.
                if (dp[i - 1][x] != 0 && n >= x + j) {
                    dp[i][x + j] += dp[i - 1][x];
                    dp[i][x + j] %= 1000000000;
                }
            }
        }
    }
    
    cout << dp[k][n] << '\n';
}
