#include <iostream>
using namespace std;

int arr[10];

int fun(int n) {
    if (n == 0) {
        return 0;
    }
    if (n == 1)return 1;

    return fun(n - 1) + fun(n - 2);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;

    cin >> n;

    cout << fun(n);
}