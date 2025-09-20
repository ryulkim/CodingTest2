import java.util.*;

class Solution {
    
    int[][] key,  lock;
    int[] kBit, lBit;
    int N, M;
    
    int rotate=0;
    
    public boolean solution(int[][] key, int[][] lock) {
        this.key=key;
        this.lock=lock;
        this.N=lock.length;
        this.M=key.length;
        this.kBit=new int[M];
        this.lBit=new int[N];
        lockBit();
        
        for(int i=0;i<4;i++){
            keyBit();
            if(proc()){
                return true;
            }
            rotate();
            rotate++;
        }
        
        return false;
    }
    
    public boolean proc(){
        
        for(int sRow=-M+1;sRow<N;sRow++){
            for(int col=-M+1;col<N;col++){
                if(fits(sRow, col)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean fits(int sRow, int col){
        for(int row=0;row<N;row++){
            int kRow=row-sRow;
            int x=0;
            if(0<=kRow&&kRow<M){
                if(col>0) x=kBit[kRow]>>col;
                else x=kBit[kRow]<<(-col);
                x&=(1<<N)-1;
                
                if((lBit[row]&x)!=0){
                    return false;
                }

                if(((lBit[row]|x)^((1<<N)-1))!=0){
                    return false;
                }
            }
            else{
                if((lBit[row]^((1<<N)-1))!=0){
                    return false;
                }
            }
        }

        return true;
    }
    
    public void keyBit(){
        for(int i=0;i<M;i++){
            int x=0;
            
            for(int j=0;j<M;j++){
                x<<=1;
                if(key[i][j]==1){
                    x|=1;
                }
            }
            
            kBit[i]=x;
        }
    }
    
    public void lockBit(){ // 홈이 1
        for(int i=0;i<N;i++){
            int x=0;
            
            for(int j=0;j<N;j++){
                x<<=1;
                if(lock[i][j]==1){
                    x|=1;
                }
            }
            
            lBit[i]=x;
        }
    }
    
    public void rotate(){
        int[][] temp=new int[M][M];
        
        for(int i=0;i<M;i++){
            for(int j=0;j<M;j++){
                temp[j][M-i-1]=key[i][j];
            }
        }
        
        key=temp;
    }
}