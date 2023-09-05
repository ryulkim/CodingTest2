#include <iostream>
#include <queue>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k;

    queue<int> q;

    cin >> n >> k;

    for (int i = 1; i <= n; i++) {
        q.push(i);
    }

    cout << '<';

    while (q.size() > 1) {
        for (int i = 1; i < k; i++) {
            int num = q.front();
            q.pop();
            q.push(num);
        }
        int a = q.front();
        cout << a << ", ";
        q.pop();
    }

    cout << q.front() << '>';
}