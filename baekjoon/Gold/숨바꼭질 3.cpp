#include <iostream>
#include <queue>
#define M 100001
using namespace std;

int bfs(int s, int f){
  priority_queue<pair<int,int>, vector<pair<int,int>>,greater<pair<int,int>>> pq;
  bool visited[100003]={0,};

  pq.push({0,s});

  while(pq.top().second!=f){
    int time=pq.top().first;
    int dis=pq.top().second;
    pq.pop();

    if(dis*2<M&&visited[dis*2]==0){
      pq.push({time, dis*2});
      visited[dis*2]=1;
    }

    if(dis+1<M&&visited[dis+1]==0){
      pq.push({time+1, dis+1});
      visited[dis+1]=1;
    }

    if(dis-1>=0&&visited[dis-1]==0){
      pq.push({time+1, dis-1});
      visited[dis-1]=1;
    }

  }

  return pq.top().first;
}

int main() {
  int n,k;
  cin>>n>>k;

  cout<<bfs(n,k)<<'\n';
}
