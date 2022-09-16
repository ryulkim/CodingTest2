#include <iostream>
#include <queue>
using namespace std;

int main() {
    int t, x, m;
    cin >> t;

    for (int i = 0; i < t; i++) {
        cin >> m;

        priority_queue<int> d;
        priority_queue<int, vector<int>, greater<int>> u;
        vector<int> v;
        int mid;
        cin >> x;
        mid = x;
        v.push_back(x);
        d.push(x);

        for (int j = 1; j < m; j++) {
            cin >> x;

            if (mid > x) {
                d.push(x);
            }
            else {
                u.push(x);
            }

            if (j % 2 == 0) {
                if (d.size() > u.size() + 1) {
                    u.push(d.top());
                    d.pop();
                }
                else if (u.size() > d.size()) {
                    d.push(u.top());
                    u.pop();
                }
                v.push_back(d.top());
                mid = d.top();
            }
        }
        int sz = v.size();
        cout << sz << '\n';
        for (int j = 0; j < sz; j++) {
            cout << v[j];
            if (j % 10 == 9) {
                cout << '\n';
            }
            else {
                cout << ' ';
            }
        }
        cout << '\n';
    }
}
