class Solution {
    int[] emoticons, sales;
    int[][] users;
    int N, M, ansCnt=0, ansValue=0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        this.emoticons=emoticons;
        this.users=users;
        this.N=users.length;
        this.M=emoticons.length;
        this.sales=new int[M];
        
        combi(0);
        
        int[] answer = {ansCnt, ansValue};
        return answer;
    }
    
    public void combi(int depth){
        if(depth==M){
            int cnt=0;
            int total=0;
            
            for(int i=0;i<N;i++){
                int sum=0;
                for(int j=0;j<M;j++){
                    if(sales[j]>=users[i][0]){
                        sum+=emoticons[j]*(100-sales[j])*0.01;
                        // System.out.println(emoticons[j]+" "+sales[j]+" "+sum);
                    }
                }
                
                if(sum>=users[i][1]){
                    cnt++;
                }
                else{
                    total+=sum;
                }
            }
            
            if(cnt==ansCnt&&total>ansValue){
                ansValue=total;
            }
            else if(cnt>ansCnt){
                ansCnt=cnt;
                ansValue=total;
                
                // for(int i=0;i<M;i++){
                //     System.out.print(sales[i]+" ");
                // }
                System.out.println();
            }
            
            return;
        }
        
        for(int i=10;i<=40;i+=10){
            sales[depth]=i;
            combi(depth+1);
        }
        
        
    }
}

