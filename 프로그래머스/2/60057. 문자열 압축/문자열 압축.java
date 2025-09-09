import java.util.*;

class Solution {
    
    String input;
    int sz;
    HashMap<String, Integer> hm;
    
    
    public int solution(String s) {
        input=s;
        sz=s.length();
        hm=new HashMap<>();
        int answer = 0;
        int min=sz;
        
        for(int i=1;i<=sz;i++){
            int value=proc(i);
            // System.out.println(i+" "+value);
            if(value<min){
                min=value;
                answer=i;
            }
        }
        
        
        return min;
    }
    
    public int calculateLength(){
        int length=0;
        
        for(Map.Entry<String, Integer> info: hm.entrySet()){
            String key=info.getKey();
            String value=info.getValue().toString();
            
            System.out.println(key+" "+value);
            
            length+=key.length();
            if(!value.equals("1")){
                length+=value.length();
            }
        }
        
        return length;
    }
    
    public int proc(int num){
        StringBuilder sb=new StringBuilder();
        String prev="";
        int cnt=0;
        int length=0;
        
        for(int i=0;i<sz;i++){
            if(i%num==0){
                if(sb!=null&&sb.length()>0){
                    String s=new String(sb);
                    if(prev.equals("")){
                        prev=s;
                        cnt=1;
                    }
                    else if(s.equals(prev)){
                       cnt++; 
                    }
                    else{
                        if(cnt>1) length+=Integer.toString(cnt).length();
                        length+=prev.length();
                        cnt=1;
                        prev=s;
                    }
                    // System.out.println("proc: "+s+" "+cnt+" "+length);
                }
                sb=new StringBuilder();
            }
            sb.append(input.charAt(i));
        }
        
        String s=new String(sb);
        if(s.equals(prev)){
           cnt++; 
        }
        else{
            if(cnt>1) length+=Integer.toString(cnt).length();
            length+=prev.length();
            cnt=1;
            prev=s;
        }
        // System.out.println("proc: "+s+" "+cnt+" "+length);
        
        if(cnt>1) length+=Integer.toString(cnt).length();
        length+=prev.length();
        // System.out.println("proc-final: "+s+" "+cnt+" "+length);
        
        return length;
    }
}