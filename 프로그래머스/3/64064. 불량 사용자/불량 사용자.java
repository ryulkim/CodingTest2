import java.util.*;

class Solution {
    
    ArrayList<String>[] hubos;
    HashSet<HashSet<String>> ans;
    int banLen;
    String[] users, bans;
    
    public int solution(String[] user_id, String[] banned_id) {
        init(user_id, banned_id);
        getHubo();
        back(0, new HashSet<>());

        return ans.size();
    }
    
    void init(String[] user_id, String[] banned_id){
        banLen=banned_id.length;
        int userLen=user_id.length;
        hubos=new ArrayList[banLen];
        for(int i=0;i<banLen;i++){
            hubos[i]=new ArrayList<>();
        }
        ans=new HashSet<>();
        users=user_id;
        bans=banned_id;
    }
    
    void getHubo(){
        for(int idx=0; idx<bans.length; idx++){
            String ban=bans[idx];
            for(String user: users){
                if(ban.length()!=user.length()) continue;
                int sz=ban.length();
                boolean chk=true;
                
                for(int i=0;i<sz;i++){
                    if(ban.charAt(i)=='*') continue;
                    if(ban.charAt(i)!=user.charAt(i)){
                        chk=false;
                        break;
                    }
                }
                
                if(chk){
                    hubos[idx].add(user);
                }
            }
        }
        
    }
    
    void back(int idx, HashSet<String> hs){
        if(banLen==idx){
            ans.add(new HashSet<>(hs));
            return;
        }
        
        ArrayList<String> arr=hubos[idx];
        
        for(String s: arr){
            if(!hs.contains(s)){
                hs.add(s);
                back(idx+1, hs);
                hs.remove(s);
            }
        }
    }
    

}