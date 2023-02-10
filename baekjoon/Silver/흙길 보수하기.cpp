#include <iostream>
#include <map>

using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, l, a, b;
    //널판지 총 개수
    long long sum = 0;
    map<int, int> m;
    
    cin >> n >> l;

    for (int i = 0; i < n; i++) {
        cin >> a >> b;
        m[a] = b;
    }
    
    //널판지가 설치된 끝 위치
    int end = 0;
    
    for (auto iter = m.begin(); iter != m.end(); iter++) {
        int first = iter->first;
        int sec = iter->second;
        //깔아야 할 널판지 개수
        int cnt;

        //설치할 웅덩이에 일부분이 이미 널판지가 깔려 있는 경우
        if (first < end) {
            first = end;
        }
        cnt = (sec - first) / l;
        
        //널판지가 웅덩이 위치를 넘어간 경우
        if ((sec - first) % l > 0) {
            cnt += 1;
            end = sec + l-(sec - first) % l;
        }
        sum += cnt;
    }

    cout << sum << '\n';
}
