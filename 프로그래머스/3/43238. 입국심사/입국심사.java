class Solution {
    public long solution(int n, int[] times) {
        long max=1000000000000000000L;
        long answer = max;
        long f=1L;
        long l=max;
        int len=times.length;
        
        while(f<=l){
            long mid=(f+l)/2;
            long sum=0L;
            
            for(int i=0;i<len;i++){
                sum+=(long) mid/times[i];
            }
            
            // System.out.println(sum);
            
            if(sum>=n){
                answer=Math.min(answer,mid);
                l=mid-1;
            }
            else{
                f=mid+1;
            }
        }
        return answer;
    }
}