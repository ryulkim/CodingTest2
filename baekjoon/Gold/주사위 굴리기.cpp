#include <iostream>
#include <vector>


using namespace std;

int n, m, x, y, k, a;

bool valid(int x, int y) {
    return x >= 0 && x < m && y >= 0 && y < n;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    vector<int> dice(7); //위, 아래, 동, 서, 남, 북   
    vector<int> map[25];

    cin >> n >> m >> y >> x >> k;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> a;
            map[i].push_back(a);
        }
    }
    
    for (int i = 0; i < k; i++) {
        bool ch = 0;
        cin >> a;
        if (a == 1) {
            if (valid(x+1, y)) {
                x += 1;
                ch = 1;

                dice = { dice[3] ,dice[2] ,dice[0] ,dice[1] ,dice[4] ,dice[5] };
            }
        }
        else if (a == 2) {
            if (valid(x - 1, y)) {
                x -= 1;
                ch = 1;

                dice = { dice[2] ,dice[3] ,dice[1] ,dice[0] ,dice[4] ,dice[5] };
              
            }
        }
        else if (a == 3) {
            if (valid(x, y-1)) {
                y -= 1;
                ch = 1;

                dice = { dice[4] ,dice[5] ,dice[2] ,dice[3] ,dice[1] ,dice[0] };

            }
        }
        else if (a == 4) {
            if (valid(x, y+1)) {
                y += 1;
                ch = 1;

                dice = { dice[5] ,dice[4] ,dice[2] ,dice[3] ,dice[0] ,dice[1] };

            }
        }

        if (ch == 1) {
            if (map[y][x]==0) {
                map[y][x] = dice[1];
            }
            else {
                dice[1] = map[y][x];
                map[y][x] = 0;
            }
            cout << dice[0] << '\n';
        }
    }
    
    
}
