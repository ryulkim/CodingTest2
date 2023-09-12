#include <iostream>
using namespace std;

string s;

bool fun(int i, int j) {
    if (i >= j) return true;
    if (s[i] == s[j]) return fun(i + 1, j - 1);
    else return false;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k, ans=0;
    cin >> n >> k;

    for (int i = 1; i <= n; i++) {
        if (n % i == 0) {
            ans++;
            if (k == ans) {
                cout << i;
                return 0;
            }
        }
    }

    cout << 0;
}

