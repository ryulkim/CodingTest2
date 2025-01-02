import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] arr=new int[105][105];
        int cnt=rectangle.length;
        boolean[][] visited=new boolean[105][105];
        ArrayDeque<int[]> q=new ArrayDeque<>();
        int[] dr={0,0,1,-1};
        int[] dc={1,-1,0,0};
        
        for(int i=0;i<cnt;i++){
            int lx=rectangle[i][0]*2;
            int ly=rectangle[i][1]*2;
            int rx=rectangle[i][2]*2;
            int ry=rectangle[i][3]*2;
            
            for(int x=lx;x<=rx;x++){
                for(int y=ly;y<=ry;y++){
                    if((x==lx||x==rx||y==ly||y==ry)&&arr[y][x]!=2) arr[y][x]=1;
                    else arr[y][x]=2;
                }
            }
        }
        
        visited[characterY*2][characterX*2]=true;
        
        for(int k=0;k<4;k++){
            int nr=characterY*2+dr[k];
            int nc=characterX*2+dc[k];
            
            if(arr[nr][nc]==1){
                q.add(new int[]{nr,nc,0});
                visited[nr][nc]=true;
            }
        }
        
        System.out.println(q.size());
        
        while(!q.isEmpty()){
            int[] head=q.poll();
            
            if(head[0]==itemY*2&&head[1]==itemX*2){
                answer=head[2]+1;
                break;
            }
            
            for(int k=0;k<4;k++){
                int nr=head[0]+dr[k];
                int nc=head[1]+dc[k];
                int num=head[2];
                
                if(!valid(nr,nc)) continue;
                
                
                
                if(!visited[nr][nc]&&arr[nr][nc]==1){
                    visited[nr][nc]=true;
                    q.add(new int[]{nr,nc,num+1});
                }
            }
        }
        
        
        return answer/2;
    }
    
    
    boolean valid(int i, int j){
        return i>=0&&i<=100&&j>=0&&j<=100;
    }
}