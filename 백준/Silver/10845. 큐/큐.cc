#include <iostream>
using namespace std;

class queue {
private:
    int q[10003] = { 0, };
    int f = 0;
    int b = 0;
public:
    void push(int num) {
        q[b] = num;
        b++;
    }
    int pop() {
        if (empty() == 1) return -1;

        int num = q[f];
        f++;
        
        return num;
    }
    int front() {
        if (empty() == 1) return -1;
        return q[f];
    }
    int back() {
        if (empty() == 1) return -1;
        return q[b-1];
    }
    int size() {
        return b-f;
    }
    int empty() {
        if (b==f) {
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
    queue q;

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> s;

        if (s == "push") {
            cin >> x;
            q.push(x);
        }
        else if (s == "front") {
            cout << q.front() << '\n';
        }
        else if (s == "back") {
            cout << q.back() << '\n';
        }
        else if (s == "size") {
            cout << q.size() << '\n';
        }
        else if (s == "empty") {
            cout << q.empty() << '\n';
        }
        else if (s == "pop") {
            cout << q.pop() << '\n';;
        }
    }
}