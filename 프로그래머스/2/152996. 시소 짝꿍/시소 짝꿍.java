import java.util.*;

/*
n이 100,000개
O(3NlogN)

정렬
하나씩 탐색
treemap?hashmap?
비율: (1,1), (1,2), (2,3), (3,4)

100: 2
180: 1
270: 1
360: 1

    100 100 180 270 360
1:1 1   1   0   0   0
1:2 0   0   1   0   0
2:3 0   0   1   0   0
3:4 0   0   0   1   0

    100 180 270 360
1:1 2*1/2   0   0   0
1:2 0   1   0   0
2:3 0   1   0   0
3:4 0   0   1   0

만약?
100: 2
180: 1
270: 2
360: 1

    100 180 270 360
1:1 1   0   1   0
1:2 0   1   0   0
2:3 0   2   0   0
3:4 0   0   2   0

*/

class Solution {
    HashMap<Integer,Integer> hm=new HashMap<>();
    int[] divide={1,1,2,3};
    int[] gop={1,2,3,4};
    
    public long solution(int[] weights) {
        long answer = 0;
        
        init(weights);
        
        answer=find();
        
        return answer;
    }
    
    void init(int[] weights){
        int sz=weights.length;
        
        for(int i=0;i<sz;i++){
            int num=weights[i];
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
    }
    
    long find(){
        long cnt=0;
        
        for(int key: hm.keySet()){
            // System.out.println(key);
            // System.out.println(hm.get(key));
            
            //1대 1일 경우
            int value=hm.get(key);
            cnt+=(long) value*(value-1)/2;
            
            for(int k=1;k<4;k++){
                if(key%divide[k]!=0) continue;
                int target=(key/divide[k])*gop[k];
                cnt+=(long) hm.getOrDefault(target,0)*value;
            }
        }
        
        return cnt;
        
    }
    
}