import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        HashSet<Integer> hs=new HashSet<>();
        ArrayDeque<Integer> q=new ArrayDeque<>();
        ArrayList<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            if(q.isEmpty()){
                //비어있으면 하나 추가
                q.add(arr[i]);
                ans.add(arr[i]);
                continue;
            }
            //큐 앞에 있는 숫자와 같은 값인지 확인, 다른 값이면 추가
            int num=q.poll();
            if(num!=arr[i]){
                q.add(arr[i]);
                ans.add(arr[i]);
            }
            else{
                q.add(arr[i]);
            }
        }
        
        int[] answer=new int[ans.size()];
        
        int idx=0;
        for(Integer num: ans){
            answer[idx++]=num;
            // System.out.println(num);
        }

        return answer;
    }
}