import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        answer=binary(distance, rocks, n);
        return answer;
    }
    
    int binary(int distance, int[] rocks, int n){
        int f=1, e=distance; 
        int sz=rocks.length;
        int max=0;
        Arrays.sort(rocks);
        
        while(f<=e){
            int mid=(f+e)/2; //최소 거리
            int point=0, cnt=0;
            
            // System.out.println(mid);
            
            for(int i=0;i<sz&&cnt<=n;i++){
                int dis=rocks[i]-point;
                if(dis<mid){ //최소 거리보다 더 작을 때 count++
                    cnt++;
                }
                else{
                    point=rocks[i]; //최소 거리보다 클 때, 현재 위치 변경
                }
            }
            if(cnt<=n && distance-point<mid){
                cnt++;
            }
            
            if(cnt>n){
                e=mid-1;
            }
            else{
                max=Math.max(max,mid);
                f=mid+1;
            }
        }
        return max;
    }
}

