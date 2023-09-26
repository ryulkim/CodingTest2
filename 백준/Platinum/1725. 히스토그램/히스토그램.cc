#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n, x;

int solve(vector<int> &A) {
    int n = A.size();

    if (n == 1) return A[0];

    vector<int> left(A.begin(), A.begin() + n / 2);
    vector<int> right(A.begin() + n / 2, A.end());
    int result = max(solve(left), solve(right));

    int lit = n / 2 - 1;
    int rit = n / 2;
    int height = min(A[lit], A[rit]);
    result = max(result, height * 2);

    while (1) {
        bool l = lit - 1 >= 0;
        bool r = rit + 1 < n;

        if (l && r) {
            if (A[lit - 1] > A[rit + 1]) {
                height = min(height, A[--lit]);
                result = max(result, height * (rit - lit + 1));
            }
            else {
                height = min(height, A[++rit]);
                result = max(result, height * (rit - lit + 1));
            }
        }
        else if (l) {
            height = min(height, A[--lit]);
            result = max(result, height * (rit - lit + 1));
        }
        else if (r) {
            height = min(height, A[++rit]);
            result = max(result, height * (rit - lit + 1));
        }
        else break;
    }
    return result;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<int> v;

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> x;
        v.push_back(x);
    }

    cout<<solve(v)<<'\n';

    
}