import java.util.*;

class Solution {
    
    String p;
    
    public String solution(String p) {
        int len=p.length();
        int start=0;
        this.p=p;
        StringBuilder sb=new StringBuilder();
        
        proc(0, len, sb);
        
        String answer = new String(sb);
        return answer;
    }
    
    public void proc(int start, int end, StringBuilder sb){
        // System.out.println(start+" "+end);
        
        for(int i=start;i<=end;i++){
            String u=p.substring(start, i);
            
            if(balance(u)){
                
                if(correct(u)){
                    start=i;
                    sb.append(u);
                }
                else{
                    sb.append('(');
                    
                    proc(i, end, sb);
                    
                    sb.append(')');
                    
                    for(int j=start+1;j<i-1;j++){
                        if(p.charAt(j)=='('){
                            sb.append(')');
                        }
                        else sb.append('(');
                    }
                    
                    
                    
                    start=i;
                    
                    break;
                }
            }
        }
    }
    
    public boolean balance(String s){
        int open=0, close=0;
        int len=s.length();
        
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='(') open++;
            else close++;
        }
        
        if(open==close) return true;
        return false;
    }
    
    public boolean correct(String s){
        ArrayDeque<Integer> st=new ArrayDeque<>();
        int len=s.length();
        
        for(int i=0;i<len;i++){
            if(s.charAt(i)==')'){
                if(!st.isEmpty()) st.pop();
                else return false;
            }
            else{
                st.push(1);
            }
        }
        
        if(!st.isEmpty()) return false;
        return true;
    }
}