import java.util.*;

//O(NlogN)

class Solution {
    public int[] solution(int[] prices) {
        int len=prices.length;
        int[] answer = new int[len];
        
        for(int i=0;i<len;i++){
            int time=0;
            for(int j=i+1;j<len;j++,time++){
                if(prices[i]>prices[j]){
                    answer[i]=++time;
                    break;
                }
            }
            if(answer[i]==0){
                answer[i]=time;
            }
            
        }
        
        return answer;
    }
}

/*
        int len=prices.length;
        int[] answer = new int[len];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        int time=0;
        
        for(int i=0;i<len;i++,time++){
            if(!pq.isEmpty()&&pq.peek()[0]>prices[i]){
                int[] t=pq.poll();
                // System.out.println(t[0]);
                answer[t[1]]=time-t[1];
            }
            pq.add(new int[]{prices[i],i});
            
        }
        
        while(!pq.isEmpty()){
            int[] t=pq.poll();
            answer[t[1]]=time-t[1]-1;
        }
        
        return answer;
*/