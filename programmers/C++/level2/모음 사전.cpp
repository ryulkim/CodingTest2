#include <string>
#include <vector>

using namespace std;

int solution(string word) {
    int answer = 0;
    string alphabet[8]={"A","E","I","O","U"};
    
    for(int i=0;i<5;i++){
        string a=alphabet[i];
        answer++;
        if(a==word){
            return answer;
        }
        for(int i=0;i<5;i++){
            string b=a+alphabet[i];
            answer++;
            if(b==word){
                return answer;
            }
            for(int i=0;i<5;i++){
                string c=b+alphabet[i];
                answer++;
                if(c==word){
                    return answer;
                }
                for(int i=0;i<5;i++){
                    string d=c+alphabet[i];
                    answer++;
                    if(d==word){
                        return answer;
                    }
                    for(int i=0;i<5;i++){
                        string e=d+alphabet[i];
                        answer++;
                        if(e==word){
                            return answer;
                        }
                    }
                }
            }
        }
    }
    
    return answer;
}
