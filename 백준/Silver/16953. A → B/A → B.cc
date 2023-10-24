#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int a, b;
    long long ans = 0;

    cin >> a >> b;

    while (b>a) {
        if (b % 2 == 1) {
            if (b % 10 == 1) {
                b /= 10;
            }
            else {
                break;
            }
        }

        else {
            b /= 2;
        }
        ans++;
    }

    if (b == a) {
        cout << ans+1 << '\n';
    }
    else {
        cout << -1 << '\n';
    }
}