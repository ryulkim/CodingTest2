#include <iostream>
#include <deque>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, x;

    deque<pair<int, int>> dq;

    cin >> n;

    for (int i = 1; i <= n; i++) {
        cin >> x;
        dq.push_back({ i,x });
    }

    while (!dq.empty()) {
        int a = dq.front().first;
        int b = dq.front().second;
        dq.pop_front();

        cout << a << " ";

        if (dq.empty()) break;

        if (b > 0) {
            for (int i = 1; i < b; i++) {
                pair<int, int> num = dq.front();
                dq.pop_front();
                dq.push_back(num);
            }
        }
        else {
            b *= -1;

            for (int i = 1; i <= b; i++) {
                pair<int, int> num = dq.back();
                dq.pop_back();
                dq.push_front(num);
            }
        }
    }
}