#include <string>
#include <vector>

using namespace std;

int answer = 0;
string alphabet[8]={"A","E","I","O","U"};
bool check=0;

void recurs(string word, string start, int len){
    if(len>5){
        return;
    }
    for(int i=0;i<5;i++){
        string a=start+alphabet[i];
        answer++;
        
        if(a==word){
            check=1;
            return;
        }
        
        recurs(word, a, len+1);
        
        if(check==1){
            return;
        }
    }
}

int solution(string word) {
    
    recurs(word, "", 1);
    
    return answer;
}
