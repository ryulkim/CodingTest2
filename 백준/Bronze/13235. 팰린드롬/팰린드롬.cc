#include <iostream>
using namespace std;

string s;

bool fun(int i, int j) {
    if (i >= j) return true;
    if (s[i] == s[j]) return fun(i + 1, j - 1);
    else return false;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> s;

    bool isPalingdrome = fun(0, s.size() - 1);

    if (isPalingdrome == 1) cout << "true";
    else cout << "false";
}