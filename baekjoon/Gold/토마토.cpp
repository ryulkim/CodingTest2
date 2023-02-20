#include <iostream>
#include <queue>

using namespace std;

int arr[1002][1002];
int grow = 0;
int total = 0;
int m, n;
int dX[5] = { -1,0,1,0 };
int dY[5] = { 0,-1,0,1 };
queue<pair<int, int>> q;

bool validate(int x, int y) {
    if (x >= 0 && x < m && y >= 0 && y < n) {
        return 1;
    }
    return 0;
}

int ans() {
    int i, j;
    
    while (!q.empty()) {

        i = q.front().first;
        j = q.front().second;
        q.pop();

        for (int k = 0; k < 4; k++) {
            if (validate(j + dX[k], i + dY[k]) && arr[i + dY[k]][j + dX[k]] == 0) {
                arr[i + dY[k]][j + dX[k]] = arr[i][j] + 1;
                q.push({ i + dY[k], j + dX[k] });
                grow++;
            }
        }
    }

    if (grow == total) {
        return arr[i][j] - 1;
    }
    else {
        return -1;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int x;
    
    cin >> m >> n;

    total = n * m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> x;
            arr[i][j] = x;

            if (x == 1) {
                grow++;
                q.push({ i,j });
            }
            else if (x == -1) {
                total--;
            }
        }
    }

    cout << ans() << '\n';

}
