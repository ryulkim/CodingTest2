#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k, w, ans;
    vector<int> v;

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> w;
        v.push_back(w);
    }

    sort(v.begin(), v.end(), greater<>());

    ans = v[0];

    for (int i = 1; i < n; i++) {
        v[i]=v[i] * (i + 1);
    }

    sort(v.begin(), v.end(), greater<>());

    cout << v[0] << '\n';
}