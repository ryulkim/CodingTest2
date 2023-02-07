#include <iostream>
#include <vector>

using namespace std;

int check[13][13];
int arr[13][13];
int n;

int ans(int level) {
    int m = n - 1;
    int min = 10e9;

    for (int i = 1; i < m; i++) {
        for (int j = 1; j < m; j++) {
            if (check[i][j] == 1) {
                continue;
            }

            if (check[i - 1][j] == 1 || check[i + 1][j] == 1 || check[i][j - 1] == 1 || check[i][j + 1] == 1) {
                continue;
            }

            check[i - 1][j] = 1;
            check[i + 1][j] = 1;
            check[i][j - 1] = 1;
            check[i][j + 1] = 1;
            check[i][j] = 1;

            int price = arr[i - 1][j] + arr[i + 1][j] + arr[i][j - 1] + arr[i][j + 1] + arr[i][j];

            //다음 씨앗을 심었을 때 최소 비용을 구함
            if (level+1 < 3) {
                int a=ans(level+1);
                if (price + a < min) {
                    min = price + a;
                }
            }
            else {
                if (price < min) {
                    min = price;
                }
            }

            check[i - 1][j] = 0;
            check[i + 1][j] = 0;
            check[i][j - 1] = 0;
            check[i][j + 1] = 0;
            check[i][j] = 0;
        }
    }

    return min;
}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int g;
    
    cin >> n;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> g;

            arr[i][j] = g;
        }
    }
    
    cout << ans(0) << '\n';

}
