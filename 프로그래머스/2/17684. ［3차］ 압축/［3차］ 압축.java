import java.util.*;

class Solution {
    
    int seq=1;
    HashMap<String, Integer> dict;
    ArrayList<Integer> arr;
    
    public int[] solution(String msg) {
        init();
        proc(msg);
        int[] answer = new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            answer[i]=arr.get(i);
        }
        
        return answer;
    }
    
    public void proc(String msg){
        int len=msg.length();
        for(int i=0;i<len;){
            StringBuilder sb=new StringBuilder();
            int num=0;
            for(int j=i;j<len;j++,i++){
                sb.append(msg.charAt(j));
                int value=dict.getOrDefault(new String(sb), -1);
                
                // System.out.println(i+" "+j+" "+value);
                
                if(value!=-1){
                    num=value;
                }
                else{
                    i=j;
                    break;
                }
            }
            arr.add(num);
            dict.put(new String(sb), seq++);
        }
    }
    
    public void init(){
        dict=new HashMap<>();
        arr=new ArrayList<>();
        
        for(char c='A';c<='Z';c++){
            String s=String.valueOf(c);
            dict.put(s,seq++);
        }
        
//         for(String s: dict.keySet()){
//             System.out.println(s);
//         }
    }
}