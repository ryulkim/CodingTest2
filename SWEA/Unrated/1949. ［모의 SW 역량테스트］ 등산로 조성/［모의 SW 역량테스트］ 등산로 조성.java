import java.io.*;
import java.util.*;

/*
 * 18,380 kb
 * 72 ms
 */
public class Solution {
    
    public static int T,N,K,ans,max;
    public static int[][] graph;
    public static boolean[][] visited;
    public static int[] dr= {0,0,1,-1};
    public static int[] dc= {1,-1,0,0};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        T = Integer.parseInt(br.readLine());
        
        for (int testCase = 1; testCase <= T; testCase++) {
            st=new StringTokenizer(br.readLine()," ");
            N=Integer.parseInt(st.nextToken());
            K=Integer.parseInt(st.nextToken());
            graph=new int[N+1][N+1];
            ans=0; max=0;
            
            for (int i = 0; i < N; i++) {
                st=new StringTokenizer(br.readLine()," ");
                for (int j = 0; j < N; j++) {
                    graph[i][j]=Integer.parseInt(st.nextToken());
                    max=Math.max(max, graph[i][j]);
                }
            }
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(graph[i][j]!=max) continue;
                    visited=new boolean[N+1][N+1];
                    
                    proc(i,j,1,false);
                }
            }
            
            sb.append("#"+testCase+" "+ans+'\n');
        }
        System.out.println(sb);
    }
    
    public static void proc(int i, int j, int len, boolean flag) {
        ans=Math.max(ans, len);
        visited[i][j]=true;
        int num=graph[i][j];
        for (int k = 0; k < 4; k++) {
            int nr=i+dr[k];
            int nc=j+dc[k];
            
            if(!valid(nr,nc)||visited[nr][nc]) continue;
            int value=graph[nr][nc];
            
            if(value<num) {
                visited[nr][nc]=true;
                proc(nr,nc,len+1,flag);
                visited[nr][nc]=false;
            }
            else if(flag) continue;
            else if(value-K<num){
            	visited[nr][nc]=true;
                graph[nr][nc]=num-1;
                proc(nr,nc,len+1,true);
                graph[nr][nc]=value;
                visited[nr][nc]=false;
            }
        }
    }
    
    public static boolean valid(int i, int j) {
        return i>=0&&i<N&&j>=0&&j<N;
    }
}
