import java.util.*;

class Solution {
    int row, col;
    String[][] rel;
    
    public int solution(String[][] relation) {
        rel=relation;
        row=relation.length;
        col=relation[0].length;
        
        int ans=proc();
        
        return ans;
    }
    
    //유일성을 못 맞출 경우, 컬럼 조합을 늘려간다.
    public int proc(){
        ArrayDeque<int[]> q=new ArrayDeque<>(); // 뽑은 조합, 맨 뒤 idx
        q.add(new int[]{0,-1});
        ArrayList<Integer> ans=new ArrayList<>();
        
        while(!q.isEmpty()){
            int[] info=q.poll();
            int start=info[1]+1;
            
            for(int j=start;j<col;j++){
                boolean chk=true;
                HashSet<String> hs=new HashSet<>();
                int bit=info[0]*10+(j+1);

                for(int i=0;i<row;i++){
                    
                    StringBuilder sb=new StringBuilder();
                    int num=info[0];
                    
                    while(num>0){
                        int idx=num%10;
                        num/=10;
                        sb.append(rel[i][idx-1]+" ");
                    }
                    
                    sb.append(rel[i][j]);
                    String result=new String(sb);
                    
                    if(hs.contains(result)){
                        chk=false;
                        
                        q.add(new int[]{bit, j});

                        break;
                    }

                    hs.add(result);
                }

                if(chk){
                    boolean isHubo=true;
                    
                    for(int hubo : ans){
                        int num=hubo;
                        boolean isSub=true;
                        
                        // 부분 집합이 이미 있는지 확인
                        while(num>0){
                            int ele=num%10;
                            num/=10;
                            boolean isExist=false;
                            
                            int num2=bit;
                            while(num2>0){
                                int ele2=num2%10;
                                num2/=10;
                                
                                if(ele==ele2){
                                    isExist=true;
                                    break;
                                }
                            }
                            
                            if(!isExist){
                                isSub=false;
                                break;
                            }
                        }
                        
                        
                        if(isSub){
                            isHubo=false;
                            break;
                        }
                    }
                    
                    if(isHubo) {
                        ans.add(bit);
                    }
                }

            }  
        }
        
        return ans.size();
        
    }
        
}