#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, x;
    cin >> n >> m;
    
    queue<int> a;
    queue<int> b;
    vector<int> v;

    for (int i = 0; i < n; i++) {
        cin >> x;
        a.push(x);
    }

    for (int i = 0; i < m; i++) {
        cin >> x;
        b.push(x);
    }

    for (int i = 0; i < n + m; i++) {
        if (a.empty()) {
            cout << b.front() << ' ';
            b.pop();
            continue;
        }
        else if (b.empty()) {
            cout << a.front() << ' ';
            a.pop();
            continue;
        }

        int temp1 = a.front();
        int temp2 = b.front();

        if (temp1 < temp2) {
            cout << temp1 << ' ';
            a.pop();
        }
        else {
            cout << temp2 << ' ';
            b.pop();
        }

    }
    cout << '\n';
}
