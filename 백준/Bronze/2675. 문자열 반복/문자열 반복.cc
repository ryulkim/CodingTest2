#include <iostream>
using namespace std;

int main(){
    string s;
    int r,T;
    
    cin>>T;
    
    for(int t=0;t<T;t++){
        cin>>r>>s;
    
        int sz=s.size();
    
        for(int i=0;i<sz;i++){
            for(int j=0;j<r;j++){
                cout<<s[i];
            }
        }
        
        cout<<'\n';
    }
    
}