#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, l, h;
    vector<int> v;

    cin >> n >> l;

    for (int i = 0; i < n; i++) {
        cin >> h;
        v.push_back(h);
    }

    sort(v.begin(), v.end());

    for (int i = 0; i < n; i++) {
        if (l < v[i]) break;
        l++;
    }

    cout << l << '\n';
}