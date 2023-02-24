#include <iostream>
#include <queue>

using namespace std;

int arr[1002][1002] = { 0, };
int dis[1002][1002] = { 0, };
bool check[1002][1002] = { 0, };
int directX[6] = { 0,0,1,-1 };
int directY[6] = { -1,1,0,0 };
int n, m;

bool valid(int i, int j) {
    return i >= 0 && i < n&& j >= 0 && j < m;
}

void bfs(int si, int sj) {
    queue<pair<int,int>> q;
    q.push({ si,sj });

    while (!q.empty()) {
        int a = q.front().first;
        int b = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++) {
            int y = a + directY[i];
            int x = b + directX[i];

            if (valid(y, x) == 1 && arr[y][x] == 1&&check[y][x]==0) {
                dis[y][x] = dis[a][b] + 1;
                q.push({ y,x });
                check[y][x] = 1;
            }

        }
    }
    
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    
    cin >> n >> m;

    
    int si, sj;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> arr[i][j];

            if (arr[i][j] == 2) {
                si = i;
                sj = j;
            }
        }
    }

    bfs(si, sj);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (dis[i][j] == 0 && arr[i][j] == 1) {
                cout << -1 << ' ';
            }
            else {
                cout << dis[i][j] << ' ';
            }
        }
        cout << '\n';
    }
}
