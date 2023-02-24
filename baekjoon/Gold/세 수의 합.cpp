#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, x;
    vector<int> v;
    vector<int> sum;
    
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> x;
        v.push_back(x);
    }

    sort(v.begin(), v.end());

    for (int i = 0; i < n - 1; i++) {
        for (int j = i; j < n; j++) {
            sum.push_back(v[i] + v[j]);
        }
    }

    sort(sum.begin(), sum.end());

    int sz = sum.size();
    int ans=0;

    for (int i = 0; i < n; i++) {
        for (int j = i+1; j < n; j++) {
            if (binary_search(sum.begin(), sum.end(), v[j] - v[i]) == 1) {
                ans = max(ans, v[j]);
            }
        }
    }

    cout << ans << '\n';
}
