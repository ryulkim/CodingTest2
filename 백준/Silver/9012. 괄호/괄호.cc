#include <iostream>
#include <stack>
using namespace std;

string solution(string s) {
    int sz = s.size();
    stack<bool> st;

    for (int i = 0; i < sz; i++) {
        if (s[i] == '(') {
            st.push(1);
        }
        else {
            if (!st.empty()) {
                st.pop();
            }
            else return "NO";
        }
    }

    if(st.empty()) return "YES";
    return "NO";
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    string s;
    stack<int> st;

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> s;

        cout<<solution(s)<<'\n';
    }
}