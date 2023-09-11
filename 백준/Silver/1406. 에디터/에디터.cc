#include <iostream>
#include <stack>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    stack<char> st;
    string s;
    char c;

    cin >> s >> n;

    for (int i = 0; i < n; i++) {
        cin >> c;

        if (c == 'L') {
            if (!s.empty()) {
                st.push(s.back());
                s.erase(s.end()-1);
            }
        }
        else if (c == 'D') {
            if (!st.empty()) {
                s+=st.top();
                st.pop();
            }
        }
        else if (c == 'B') {
            if (!s.empty()) s.erase(s.end() - 1);
        }
        else if (c == 'P') {
            char temp;
            cin >> temp;
            s+=temp;
        }
    }
    
    cout << s;

    while (!st.empty()) {
        cout << st.top();
        st.pop();
    }
}