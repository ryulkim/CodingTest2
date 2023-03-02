#include <iostream>
#include <vector>
#include <algorithm>


using namespace std;

int l, c;
vector<char> v;
char a[5];
char vo[] = { 'a','e','i','o','u' };

void ans(int lev, int start, int vc, int cc) {
    if (lev == l) {
        if (vc >= 1 && cc >= 2) {
            for (int i = 0; i < l; i++) {
                cout << a[i];
            }
            cout << '\n';
        }
        
        return;
    }


    for (int i = start; i < c; i++) {
        int ch = 0;

        a[lev] = v[i];
        
        for (int j = 0; j < 5; j++) {
            if (v[i] == vo[j]) {
                ch = 1;
                vc++;
                break;
            }
        }

        if (ch == 0) {
            cc++;
        }

        ans(lev + 1, i + 1, vc, cc);

        if (ch == 0) {
            cc--;
        }
        else {
            vc--;
        }
    }
}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    
    char x;
    
    cin >> l >> c;

    for (int i = 0; i < c; i++) {
        cin >> x;
        v.push_back(x);
    }

    sort(v.begin(), v.end());

    ans(0, 0, 0, 0);
}
