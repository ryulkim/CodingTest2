#include <iostream>
using namespace std;

class stack {
private:
    int st[10003] = { 0, };
    int pos = 0;
public:
    void push(int num) {
        st[pos] = num;
        pos++;
    }
    int pop() {
        if (empty() == 1) return -1;

        pos--;
        int num = st[pos];
        st[pos] = 0;
        
        return num;
    }
    int top() {
        if (empty() == 1) return -1;
        return st[pos-1];
    }
    int size() {
        return pos;
    }
    int empty() {
        if (pos == 0) {
            return 1;
        }
        return 0;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, x;
    string s;
    stack st;

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> s;

        if (s == "push") {
            cin >> x;
            st.push(x);
        }
        else if (s == "top") {
            cout << st.top() << '\n';
        }
        else if (s == "size") {
            cout << st.size() << '\n';
        }
        else if (s == "empty") {
            cout << st.empty() << '\n';
        }
        else if (s == "pop") {
            cout << st.pop() << '\n';;
        }
    }
}