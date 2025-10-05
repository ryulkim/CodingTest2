class Solution {
    
    int[][] board;
    int N, M;
    
    public int solution(int m, int n, String[] board) {
        M=m;N=n;
        this.board=new int[M][N];
        initBoard(board);
        
        while(isFind()){
            reArange();
        }
        
        int answer = count();
        return answer;
    }
    
    public void print(){
        for(int r=0;r<M;r++){
            for(int c=0;c<N;c++){
                System.out.print(board[r][c]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public int count(){
        int sum=0;
        
        for(int r=0;r<M;r++){
            for(int c=0;c<N;c++){
                if(board[r][c]==0){
                    sum++;            
                }
            }
        }
        
        return sum;
    }
    
    public void reArange(){
        int[][] temp=new int[M][N];
        
        for(int c=0;c<N;c++){
            int row=M-1;
            for(int r=M-1;r>=0;r--){
                if(board[r][c]>0){
                    temp[row--][c]=board[r][c];
                }
            }
        }
        
        for(int r=0;r<M;r++){
            for(int c=0;c<N;c++){
                board[r][c]=temp[r][c];
            }
        }
    }
    
    public boolean isFind(){
        int[][] chk=new int[M][N];
        boolean flag=false;
        
        for(int i=0;i<M-1;i++){
            for(int j=0;j<N-1;j++){
                if(board[i][j]==0) continue;
                
                int one=board[i][j];
                int two=board[i][j+1];
                int three=board[i+1][j];
                int four=board[i+1][j+1];
                if(one==two&&two==three&&three==four&&four==one){
                    chk[i][j]=1;
                    chk[i][j+1]=1;
                    chk[i+1][j]=1;
                    chk[i+1][j+1]=1;
                    flag=true;
                }
            }
        }
        
        
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(chk[i][j]==1){
                    board[i][j]=0;
                }
            }
        }
        
        return flag;
    }
    
    public void initBoard(String[] info){
        for(int i=0;i<M;i++){
            String col=info[i];
            for(int j=0;j<N;j++){
                board[i][j]=(col.charAt(j)-'A'+1);
            }
        }
    }
}