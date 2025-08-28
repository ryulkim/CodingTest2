import java.util.*;

class Solution {
    class Node {
        String s;
        int recent;
        int cnt;
        boolean isDeleted;
        
        Node(String s, int r, int c){
            this.s=s;
            this.recent=r;
            this.cnt=c;
            this.isDeleted=false;
        }
    }
    
    PriorityQueue<Node> pq;
    HashMap<String, Node> hm;
    int N;
    
    public int solution(int cacheSize, String[] cities) {
        init(cacheSize);
        return proc(cities);
    }
    
    public int proc(String[] cities){
        int idx=0;
        int ans=0;
        for(String city: cities){
            String s=city.toLowerCase();
            Node find=hm.get(s);
            
            if(find!=null){
                find.recent=idx++;
                pq.remove(find);
                pq.add(find);
                
                // find.isDeleted=true;
                // Node newNode=new Node(s, idx++, 0);
                // pq.add(newNode);
                // hm.put(s,newNode);

                ans++;
            }
            else {
                if(N>0){
                    // while(!pq.isEmpty()&&pq.peek().isDeleted){
                    //     pq.poll();
                    // }
                    
                    if(hm.size()>=N){
                        Node minus=pq.poll();
                        hm.remove(minus.s);
                    }
                    Node newNode=new Node(s, idx++, 0);
                    pq.add(newNode);
                    hm.put(s,newNode);
                }
                
                ans+=5;
            }
            
        }
        
        return ans;
    }
    
    public void init(int sz){
        pq=new PriorityQueue<>((a,b)->{
            // return Integer.compare(a.recent, b.recent);
            if(a.recent==b.recent){
                return a.s.compareTo(b.s);
            }
            return Integer.compare(a.recent, b.recent);
        });
        N=sz;
        hm=new HashMap<>();
    }
}