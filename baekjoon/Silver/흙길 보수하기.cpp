#include <iostream>
#include <map>

using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, l, a, b;
    long long sum = 0;
    map<int, int> m;
    
    cin >> n >> l;

    for (int i = 0; i < n; i++) {
        cin >> a >> b;
        m[a] = b;
    }

    int end = 0;
    
    for (auto iter = m.begin(); iter != m.end(); iter++) {
        int first = iter->first;
        int sec = iter->second;
        int cnt;

        if (first < end) {
            first = end;
        }
        cnt = (sec - first) / l;
        if ((sec - first) % l > 0) {
            cnt += 1;
            end = sec + l-(sec - first) % l;
        }
        sum += cnt;
    }

    cout << sum << '\n';
}
