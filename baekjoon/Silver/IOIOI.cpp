#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    string s;
    
    cin >> n >> m;
    cin >> s;

    int cnt = 0;//연속한 O의 개수
    int ans = 0;
    int l=-1;

    for (int i = 0; i < m; i++) {
        if (s[i] == 'O' && i > 0 && i < m - 1) {
            if (s[i - 1] == 'I' && s[i + 1] == 'I') {
                if (l + 2 == i) {
                    cnt++;
                }
                else {
                    cnt = 1;
                }

                l = i;

                if (cnt >= n) {
                    ans++;
                }
            }
        }

    }

    cout << ans << '\n';
}
