#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, x;
    vector<int> v;

    cin >> n;
    
    for (int i = 0; i < n; i++) {
        cin >> x;
        v.push_back(x);
    }
    
    sort(v.begin(), v.end());

    for (int i = 0; i < n; i++) {
        cout << v[i] << '\n';
    }
}