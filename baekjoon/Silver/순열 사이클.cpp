#include <iostream>
#include <vector>


using namespace std;

void dfs(vector<int> &v, int start, int i, bool (&check)[1003]) {//&: 참조자를 쓰면, 빠르게 전달가능하기 때문에 시간이 덜 걸린다.
    if (check[i] == 1) {
        int sz = v.size();

        return;
    }
    

    check[i] = 1;

    dfs(v, start, v[i], check);

}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int t, n, x;
    

    cin >> t;

    for (int i = 0; i < t; i++) {
        cin >> n;
        bool check[1003] = { 0, };
        int ans = 0;
        vector<int> v;
        v.push_back(0);

        for (int j = 0; j < n; j++) {
            cin >> x;
            v.push_back(x);
        }

        for (int j = 1; j <= n; j++) {

            if (check[j] == 1) {
                continue;
            }

            dfs(v, j, j, check);

            ans++;
        }

        cout << ans << '\n';
    }
    
}
