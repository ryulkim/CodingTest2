import java.util.*;
import java.math.*;

class Solution {
    
    int N, K, SIZE=1_00_000_000, LEN=9;
    boolean[] prim;
    
    public int solution(int n, int k) {
        this.N=n;
        this.K=k;
        this.prim=new boolean[SIZE+2];
        // eratos();
        String value=convert();
    
        return find(value);
    }
    
    public int find(String value){
        int cnt=0;
        int sz=value.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<sz;i++){
            char c=value.charAt(i);
            if(c=='0'){
                if(sb.length()>0){
                    String temp=new String(sb);
                    long num=Long.parseLong(temp);
                    if(isPrime(num)){
                        cnt++;
                    }
                }
                
                sb.setLength(0);
            }
            else {
                sb.append(c);
            }
        }
        
        if(sb.length()>0){
            String temp=new String(sb);
            long num=Long.parseLong(temp);
            if(isPrime(num)){
                cnt++;
            }
        }
        
        return cnt;
    }
    
    boolean isPrime(long n) {
        return BigInteger.valueOf(n).isProbablePrime(10);
    }

    
    public String convert(){
        StringBuilder sb=new StringBuilder();
        while(N>0){
            sb.append(N%K);
            N/=K;
        }
        return new String(sb.reverse());
    }
    
    public void eratos(){
        prim[1]=true;
        
        for(int i=2;i<=(int) Math.sqrt(SIZE);i++){
            if(prim[i]) continue;
            for(int j=i*i;j<=SIZE;j+=i){
                prim[j]=true;
            }
        }
    }
}