#include <iostream>

using namespace std;

int inorder[100003] = { 0, };
int post[100003] = { 0, };
int index[100003] = { 0, };

void solution(int inStart, int inEnd, int postStart, int postEnd) {
    if (inStart > inEnd || postStart > postEnd) {
        return;
    }

    int root = post[postEnd];
    int left=index[root]-inStart;
    int right = inEnd - index[root];
    cout << root << ' ';

    solution(inStart, index[root] - 1, postStart, postStart+left-1);
    solution(index[root] + 1, inEnd, postEnd - right, postEnd - 1);
}

int main() {
    int n, x;

    cin >> n;

    for (int i = 1; i <= n; i++) {
        cin >> x;
        inorder[i] = x;
        index[inorder[i]] = i;
    }

    for (int i = 1; i <= n; i++) {
        cin >> x;
        post[i] = x;
    }

    solution(1, n, 1, n);
}
