#include <iostream>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;

//bool dp[2000002];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, x;
    vector<int> v;
    vector<int> v_result;

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> x;
        v.push_back(x);
    }

    int o_size = v.size();
    int pos = 0;

    for (int i = 0; i < o_size; i++) {
        v_result.push_back(v[i]);
        pos = v_result.size() - 1;

        for (int j = i + 1; j < o_size; j++) {
            int tem_sz = v_result.size();
            for (int k = pos; k < tem_sz; k++) {
                v_result.push_back(v_result[k] + v[j]);
            }
        }
    }

    int v_sz = v_result.size();

    set<int> st;
    for (int i = 0; i < v_sz; i++) {
        st.insert(v_result[i]);
    }

    int s_sz = st.size();
    set<int>::iterator it;
    int i = 1;
    bool ch = 0;

    for (it = st.begin(); it != st.end(); it++) {
        if (i != *it) {
            cout << i << '\n';
            ch = 1;
            break;
        }
        i++;
    }

    if (ch == 0) {
        cout << i << '\n';
    }
}
