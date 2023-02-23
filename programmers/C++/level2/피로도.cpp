#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(int k, vector<vector<int>> dungeons) {
    int answer = 0;
    int sz=dungeons.size();
    sort(dungeons.begin(), dungeons.end());
    
    do{
        int temp=k;
        int cnt=0;
        
        for(int i=0;i<sz;i++){
            int a=dungeons[i][0];
            int b=dungeons[i][1];
            
            if(temp>=a){
                temp-=b;
                cnt++;
            }
        }
        
        answer=max(cnt, answer);
    }while(next_permutation(dungeons.begin(), dungeons.end()));
    
    return answer;
}
