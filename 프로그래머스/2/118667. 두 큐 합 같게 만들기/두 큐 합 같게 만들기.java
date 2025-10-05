import java.util.*;

class Solution {
    int N,M;
    long sum=0;
    long[] arr;
    
    public int solution(int[] queue1, int[] queue2) {
        N=queue1.length;
        M=queue2.length;
        arr=new long[N+M+1];
        for(int i=0;i<N;i++){
            arr[i]=queue1[i];
            sum+=queue1[i];
        }
        
        for(int i=0;i<M;i++){
            arr[i+N]=queue2[i];
            sum+=queue2[i];
        }
        
        int answer = proc();
        return answer;
    }
    
    public int proc(){
        int f=0,l=0;
        long temp=arr[0];
        int ans=1000_000_000;
        
        while(l<N+M){
            if(temp==sum/2){
                if(l<N-1){
                    ans=Math.min(ans, l+M+f+1);
                    System.out.println(f+" "+l+" "+temp+" "+(l+M+f+1));
                    // return l+M+f+1;
                }
                // if(f>=N){
                //     return l-f+1;
                // }
                else {
                    ans=Math.min(ans, f+(l-N+1));
                    System.out.println(f+" "+l+" "+temp+" "+(f+(l-N+1)));
                }
                
            }
            if(temp<=sum/2){
                l++;
                temp+=arr[l];
            }
            else{
                temp-=arr[f];
                f++;
            }
        }
        
        if(ans==1000_000_000) return -1;
        return ans;
    }
}

/*
3 2 7 2 
*/