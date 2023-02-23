#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> sizes) {
    int answer = 0;
    int sz=sizes.size();
    int height=0;
    int width=0;
    
    for(int i=0;i<sz;i++){
        if(sizes[i][0]>sizes[i][1]){
            height=max(height, sizes[i][0]);
            width=max(width, sizes[i][1]);
        }
        else{
            height=max(height, sizes[i][1]);
            width=max(width, sizes[i][0]);
        }
    }
    
    answer=height*width;
    return answer;
}
