import java.util.*;

class Solution {
    
    ArrayList<ArrayList<Integer>> infos;
    ArrayList<Integer> arr;
    HashMap<Integer, Integer> chk;
    
    public int[] solution(String s) {
        init(s);
        return proc();
    }
    
    public void init(String s){
        infos=new ArrayList<>();
        chk=new HashMap<>();
        
        StringBuilder num=new StringBuilder();
        for(int i=1;i<s.length()-1;i++){
            if(s.charAt(i)=='{'){
                arr=new ArrayList<>();
            }
            else if(s.charAt(i)==','){
                if(num.length()>0){
                    arr.add(Integer.parseInt(num.toString()));
                    num=new StringBuilder();
                }
                
            }
            else if(s.charAt(i)=='}'){
                arr.add(Integer.parseInt(num.toString()));
                num=new StringBuilder();
                infos.add(arr);
            }
            else{
                num.append(s.charAt(i));
            }
        }
        
    }
    
    public int[] proc(){
        infos.sort((a,b)->Integer.compare(a.size(),b.size()));
        int idx=0;
        
        for(ArrayList<Integer> temp: infos){
            for(int num: temp){
                //System.out.print(num+" ");
                if(!chk.containsKey(num)){
                    chk.put(num,idx++);
                }
            }
            System.out.println();
        }
        
        int[] ans=new int[chk.size()];
        
        for(Map.Entry<Integer, Integer> info: chk.entrySet()){
            ans[info.getValue()]=info.getKey();
        }
        
        return ans;
    }
}