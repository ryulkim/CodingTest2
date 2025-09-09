import java.util.*;

class Solution {
    
    String input;
    int sz;
    
    public int solution(String s) {
        input=s;
        sz=s.length();
        int answer = 0;
        int min=sz;
        
        for(int i=1;i<=sz;i++){
            int value=proc(i);
            min=Math.min(min,value);
        }
        return min;
    }
    
    public int proc(int num){
        String prev="";
        int cnt=0;
        int length=0;
        
        for(int i=0;i<sz;){
            int end=Math.min(sz, i+num);
            String s=input.substring(i, end);
            i=end;
            if(prev.equals("")){
                prev=s;
                cnt=1;
            }
            else if(s.equals(prev)){
               cnt++; 
            }
            else{
                if(cnt>1) length+=(int) Math.log10(cnt)+1;
                length+=prev.length();
                cnt=1;
                prev=s;
            }
        }
        
        if(cnt>1) length+=Integer.toString(cnt).length();
        length+=prev.length();
        
        return length;
    }
}