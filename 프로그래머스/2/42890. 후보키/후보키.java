import java.util.*;

class Solution {
    
    class Node{
        String s;
        int bit, last;
        
        Node(String s, int bit, int last){
            this.s=s;
            this.bit=bit;
            this.last=last;
        }
    }
    
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
        // if(cnt>=col) return;
        ArrayDeque<Node> q=new ArrayDeque<>(); // 비트마스킹, 맨 뒤 idx
        q.add(new Node("",0,-1));
        ArrayList<Integer> ans=new ArrayList<>();
        
        while(!q.isEmpty()){
            Node info=q.poll();
            int start=info.last+1;
            // System.out.println(info.bit);
            
            for(int j=start;j<col;j++){
                boolean chk=true;
                HashSet<String> hs=new HashSet<>();
                int bit=info.bit|1<<j;

                for(int i=0;i<row;i++){
                    
                    StringBuilder sb=new StringBuilder();
                    
                    for(int k=0;k<8;k++){
                        if((info.bit&1<<k)!=0){
                            sb.append(rel[i][k]+" ");
                        }
                    }
                    
                    sb.append(rel[i][j]);
                    String result=new String(sb);
                    
                    if(hs.contains(result)){
                        chk=false;
                        
                        q.add(new Node(result, bit, j));
                        // ArrayList<Integer> temp=new ArrayList(combi);
                        // temp.add(j);
                        // proc(cnt+1, temp);

                        break;
                    }

                    hs.add(result);
                }

                if(chk){
                    boolean isHubo=true;
                    
                    for(int hubo : ans){
                        if((hubo&bit)==hubo){
                            isHubo=false;
                            break;
                        }
                    }
                    
                    if(isHubo) {
                        // System.out.println("pick: "+bit);
                        ans.add(bit);
                    }
                    // else System.out.println(bit);
                    
                    // for(Integer idx: combi){
                    //     System.out.print(idx+" ");
                    // }
                    // System.out.println(j);
                }

            }  
        }
        
        return ans.size();
        
    }
        
}