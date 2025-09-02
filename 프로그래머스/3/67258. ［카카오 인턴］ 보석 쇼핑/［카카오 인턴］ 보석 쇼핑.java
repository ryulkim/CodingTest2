import java.util.*;

class Solution {
    HashSet<String> types;
    HashMap<String, Integer> count;
    String[] gems;
    
    public int[] solution(String[] gems) {
        this.gems=gems;
        
        init();

        int[] answer = proc();
        return answer;
    }
    
    public void init(){
        types=new HashSet<>();
        count=new HashMap<>();
        
        for(String s: gems){
            types.add(s);
        }
    }
    
    public int[] proc(){
        int len=gems.length;
        int f=0,l=0;
        int ans=100_000;
        int ans_f=0, ans_l=0;
        
        while(l<len){
            String first=gems[f];
            String last=gems[l];
      
            count.put(last, count.getOrDefault(last,0)+1);
            
            while(count.getOrDefault(first,0)>1){
                count.put(first, count.get(first)-1);
                f++;
                first=gems[f];
            }
                  
            if(count.size()==types.size()){
                if(ans>(l-f+1)){
                    ans=l-f+1;
                    ans_f=f;
                    ans_l=l;
                }
            }
            
            l++;
        }
        
        return new int[]{ans_f+1, ans_l+1};
    }
}