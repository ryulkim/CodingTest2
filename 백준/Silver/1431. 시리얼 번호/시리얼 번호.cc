#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    string s;
    vector<string> v;

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> s;
        v.push_back(s);
    }
    sort(v.begin(), v.end(), [&](string a, string b) {
        if (a.size() != b.size()) {
            return a.size() < b.size();
        }
        else {
            int sa = 0, sb = 0;
            for (int i = 0; i < a.size(); i++) {
                if (a[i] >= '0' && a[i] <= '9') sa += (a[i] - '0');
                if (b[i] >= '0' && b[i] <= '9') sb += (b[i] - '0');
            }
            if (sa == sb) return a < b;

            return sa < sb;
        }
        }
    );
    for (int i = 0; i < n; i++) {
        cout << v[i] << '\n';
    }
}