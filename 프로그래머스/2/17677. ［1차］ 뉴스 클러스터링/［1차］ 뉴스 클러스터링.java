import java.util.*;

class Solution {
    
    HashMap<String, Integer> A, B, hap, cross;
    
    public int solution(String str1, String str2) {
        A=new HashMap<>();
        B=new HashMap<>();
        hap=new HashMap<>();
        cross=new HashMap<>();
        
        aCount(str1);
        bCount(str2);
        
        int cro=getCross();
        int h=getHap();
        
        if(cro==h) return 65536;
        
        long value=cro*65536;
        int answer = (int) (value/h);
        
        return answer;
    }
    
    public int getCross(){
        HashMap<String, Integer> temp=new HashMap<>();
        
        for(Map.Entry<String, Integer> entry : A.entrySet()){
            String s=entry.getKey();
            int cnt=entry.getValue();
            
            temp.put(s, Math.min(A.get(s), B.getOrDefault(s,0)));
        }
        
        int ans=0;
        for(Map.Entry<String, Integer> entry : temp.entrySet()){
            ans+=entry.getValue();
        }
        
        return ans;
    }
    
    public int getHap(){
        HashMap<String, Integer> temp=new HashMap<>();
        
        for(Map.Entry<String, Integer> entry : A.entrySet()){
            String s=entry.getKey();
            int cnt=entry.getValue();
            
            temp.put(s, Math.max(A.get(s), temp.getOrDefault(s,0)));
        }
        
        for(Map.Entry<String, Integer> entry : B.entrySet()){
            String s=entry.getKey();
            int cnt=entry.getValue();
            
            temp.put(s, Math.max(B.get(s), temp.getOrDefault(s,0)));
        }
        
        int ans=0;
        for(Map.Entry<String, Integer> entry : temp.entrySet()){
            ans+=entry.getValue();
        }
        
        System.out.println(ans);
        
        return ans;
    }
    
    public void aCount(String str){
        int sz=str.length();
        HashMap<String, Integer> t=new HashMap<>();
        
        for(int i=0;i<sz-1;i++){
            StringBuilder s=new StringBuilder();
            for(int j=0;j<2;j++){
                char c=str.charAt(i+j);
                if(c>='A'&&c<='Z'||c>='a'&&c<='z'){
                    s.append(c);
                }
                else break;
            }
            
            if(s.length()==2){
                String temp=new String(s).toLowerCase();
                t.put(temp, t.getOrDefault(temp,0)+1);
            }
        }
        
        A=t;
    }
    
    public void bCount(String str){
        int sz=str.length();
        HashMap<String, Integer> t=new HashMap<>();
        
        for(int i=0;i<sz-1;i++){
            StringBuilder s=new StringBuilder();
            for(int j=0;j<2;j++){
                char c=str.charAt(i+j);
                if(c>='A'&&c<='Z'||c>='a'&&c<='z'){
                    s.append(c);
                }
                else break;
            }
            
            if(s.length()==2){
                String temp=new String(s).toLowerCase();
                t.put(temp, t.getOrDefault(temp,0)+1);
            }
        }
        
        B=t;
    }
}