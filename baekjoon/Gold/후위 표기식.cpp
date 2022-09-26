#include <iostream>
#include <stack>
#include <queue>
using namespace std;

int main() {
    string s;
    string ans = "";
    cin >> s;

    int sz = s.size();
    stack<char> st;
    bool check = 0; //pop을 할지 안할지

    for (int i = 0; i < sz; i++) {
        if (s[i] >= 'A' && s[i] <= 'Z') {
            ans += s[i];
        }
        else if (s[i] == '(') {
            st.push('(');
            check = 0;
        }
        else if (s[i] == ')') {
            while (st.top() != '(') {
                ans += st.top();
                st.pop();
            }
            st.pop();
        }
        else if (s[i] == '*' || s[i] == '/') {
            if (!st.empty() && (st.top() == '+' || st.top() == '-')) {
                st.push(s[i]);
            }
            else if(!st.empty() && st.top() != '(') {
                ans += st.top();
                st.pop();
                st.push(s[i]);
            }
            else {
                st.push(s[i]);
            }
        }
        else if (s[i] == '+' || s[i] == '-') {
            if (!st.empty() && (st.top() == '*' || st.top() == '/')) {
                int sz = st.size();
                while (!st.empty()&&st.top() != '(') {
                    ans += st.top();
                    st.pop();
                }
                st.push(s[i]);
            }
            else if (!st.empty()&&st.top()!='(') {
                ans += st.top();
                st.pop();
                st.push(s[i]);
                check = 0;
            }
            else {
                st.push(s[i]);
            }
        }
    }
    int len = st.size();
    for (int i = 0; i < len; i++) {
        ans += st.top();
        st.pop();
    }
    cout << ans << '\n';
}

//A+B*C+D+(F+G)*T
//ABC*+D+FG+T*+
