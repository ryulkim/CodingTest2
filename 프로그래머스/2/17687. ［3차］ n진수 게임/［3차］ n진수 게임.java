class Solution {
    
    int N, T, M, P;
    char[] c={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    
    public String solution(int n, int t, int m, int p) {
        N=n;T=t;M=m;P=p;
        
        String answer = calculate();
        return answer;
    }
    
    public String calculate(){
        int seqNumber=0, order=0, target=P;
        StringBuilder sb=new StringBuilder();
        
        while(sb.length()<T){
            String value=convert(seqNumber++);
            order+=value.length();
            if(order>=target){
                // System.out.println(target+" "+order+" "+(target-(order-value.length())));
                char temp=value.charAt(target-(order-value.length())-1);
                sb.append(temp);
                // sb.append(1);
                target+=M;
            }
        }
        
        return new String(sb);
    }
    
    public String convert(int num){
        if(num==0) return "0";
            
        StringBuilder sb=new StringBuilder();
        
        while(num>0){
            sb.append(c[num%N]);
            num/=N;
        }
        
        return new String(sb.reverse());
    }
   
}