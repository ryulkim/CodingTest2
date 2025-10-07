class Solution {
    
    int[] stones;
    int K, N;
    
    public int solution(int[] stones, int k) {
        this.stones=stones;
        this.K=k;
        this.N=stones.length;
        
        int answer = binary();
        return answer;
    }
    
    public int binary(){
        int f=0,l=2_000_000_000;
        int max=0;
        
        while(f<=l){
            int mid=(f+l)/2;
            boolean chk=true;
            int cnt=0;
            
            for(int i=0;i<N;i++){
                if(stones[i]<mid) cnt++;
                else cnt=0;
                
                if(cnt>=K){
                    chk=false;
                    break;
                }
            }
            
            if(chk){
                f=mid+1;
                max=Math.max(max, mid);
            }
            else{
                l=mid-1;
            }
        }
        
        return max;
    }
}

/*

*/