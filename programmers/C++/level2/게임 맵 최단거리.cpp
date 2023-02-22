#include <vector>
#include <queue>
using namespace std;

int directX[5]={-1,1,0,0};
int directY[5]={0,0,-1,1};

bool valid(int i, int j, int n, int m){
    return i>=0&&i<m&&j>=0&&j<n;
}

int bfs(vector<vector<int>> maps){
    int n=maps[0].size();
    int m=maps.size();
    int check[102][102]={0,};
    
    queue<pair<pair<int,int>,int>> q; //<<i,j>,거리>
    q.push({{0,0},1});
    
    while(!q.empty()){
        int i=q.front().first.first;
        int j=q.front().first.second;
        int r=q.front().second;
        
        if(i==m-1&&j==n-1){
            break;
        }
        
        q.pop();
        
        for(int a=0;a<4;a++){
            if(valid(i+directY[a], j+directX[a], n, m)&&check[i+directY[a]][j+directX[a]]==0&&maps[i+directY[a]][j+directX[a]]==1){
                q.push({{i+directY[a], j+directX[a]},r+1});
                check[i+directY[a]][j+directX[a]]=1;
            }
        }
    }
    if(q.empty()){
        return -1;
    }
    return q.front().second;
}

int solution(vector<vector<int>> maps)
{
    int answer = bfs(maps);
    return answer;
}
