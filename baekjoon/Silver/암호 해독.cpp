#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string key, s;
    char c;
    char arr[102][12] = { "", };
    char ans[102][12] = { "", };
    bool check[12] = { 0, };
    
    cin >> key >> s;

    int sz = key.size();
    int rs = s.size() / sz;
    int num = 0;
    string key_sort = key;

    sort(key_sort.begin(), key_sort.end());

    for (int i = 0; i < sz; i++) {
        arr[0][i] = key_sort[i];
    }

    for (int i = 0; i < sz; i++) {
        for (int j = 1; j <= rs; j++) {
            arr[j][i] = s[num++];
        }
    }

    for (int i = 0; i < sz; i++) {
        for (int j = 0; j < sz; j++) {
            if (key[i] == arr[0][j] && check[j] == 0) {
                for (int k = 1; k <= rs; k++) {
                    ans[k][i]=arr[k][j];
                }
                check[j] = 1;
                break;
            }
        }
    }

    for (int i = 1; i <= rs; i++) {
        for (int j = 0; j < sz; j++) {
            cout << ans[i][j];
        }
    }
}
