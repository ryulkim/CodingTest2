#include <iostream>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;


struct cmp {
    bool operator()( string a,  string b) const{
        if (a.size() == b.size()) {
            return a < b;
        }
        return a.size() < b.size();
    }
};


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    string s;
    
    set<string, cmp> v;
    
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> s;
        v.insert(s);
    }


    for (auto i = v.begin(); i != v.end(); i++) {
        cout << *i << '\n';
    }
}
