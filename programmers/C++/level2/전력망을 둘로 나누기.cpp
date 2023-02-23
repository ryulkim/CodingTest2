#include <string>
#include <vector>
#include <queue>
#include <cstdlib>

using namespace std;

int bfs(vector<int> v[102], int start, int con){
    bool check[102]={0,};
    int num=0;
    queue<int> q;
    
    q.push(start);
    check[start]=1;
    check[con]=1;
    
    while(!q.empty()){
        int f=q.front();
        int sz=v[f].size();
        
        q.pop();
        num++;
        
        for(int i=0;i<sz;i++){
            int temp=v[f][i];
            
            if(check[temp]==0){
                q.push(temp);
                check[temp]=1;
            }
        }
    }
    
    return num;
}

int solution(int n, vector<vector<int>> wires) {
    int answer = 1000;
    vector<int> v[102];
    int m=wires.size();
    
    for(int i=0;i<m;i++){
        int a=wires[i][0];
        int b=wires[i][1];
        
        v[a].push_back(b);
        v[b].push_back(a);
    }
    
    for(int i=0;i<m;i++){
        int a=wires[i][0];
        int b=wires[i][1];
        
        int num1=bfs(v, a, b);
        int num2=bfs(v, b, a);
        
        answer=min(answer,abs(num1-num2));
    }
    
    return answer;
}
