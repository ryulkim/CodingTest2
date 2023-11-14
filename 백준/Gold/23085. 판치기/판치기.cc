#include <iostream>
#include <algorithm>
#include <vector>
#include <iostream>
#include <queue>
using namespace std;

bool chk[3002] = { 0, }; //idex가 H의 개수
int cnt[3002];


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k, hcnt=0;
    string s;
    queue<int> q; //H의 개수

    cin >> n >> k;
    cin >> s;

    for (int i = 0; i < n; i++) {
        if (s[i] == 'H') hcnt++;
    }

    q.push(hcnt);
    chk[hcnt] = 1;

    while (!q.empty()) {
        int h = q.front();

        q.pop();

        for (int i = 0, j = k; i <= h && j >= 0; i++, j--) { //i는 뒤집을 앞면 개수, j는 뒤집을 뒷면 개수
            if (h >= i && n - h >= j) {
                if (!chk[h - i + j]) {
                    q.push(h - i + j);
                    cnt[h - i + j] = cnt[h] + 1;
                    chk[h - i + j] = 1;
                }

            }
        }
    }
    if (chk[0] == 0) cout << "-1";
    else cout << cnt[0];



}

/*
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
*/