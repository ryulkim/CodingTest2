#include <iostream>
#include <vector>

using namespace std;

vector<int> v;
int sz;

int cut(int x) {
    int sum = 0;

    for (int i = 0; i < sz; i++) {
        sum += v[i] / x;
    }

    return sum;
}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k, x;
    long ans = 0;
    long start, end, cur;
    start = 1;
    end = 0;
    
    cin >> k >> n;

    for (int i = 0; i < k; i++) {
        cin >> x;
        v.push_back(x);

        if (end < x) {
            end = x;
        }
    }

    sz = v.size();

    while ((end - start) >= 0) {
        cur = (end + start) / 2;
        long num = cut(cur);
        
        if (num >= n) {
            if (cur > ans) {
                ans = cur;
            }
            start = cur + 1;
        }
        else{
            end = cur - 1;
        }
    }

    cout << ans << '\n';
}
