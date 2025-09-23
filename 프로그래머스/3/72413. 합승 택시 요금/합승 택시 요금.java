import java.util.*;

class Solution {
    
    int MAX=1000_000_000;
    int N, S, A, B, ans=Integer.MAX_VALUE;
    int[][] graph;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        init(n, s, a, b, fares);
        flowid();
        // no();
        together();
        
        return ans;
    }
    
    // 최저 값 구하기
    // 탑승 후 A, B 나눠서
    // A까지 가고, B만 혼자
    // B까지 가고, A만 혼자
    // 탑승 안하고 각자
    
    
    // A,B 합승할 때
    public void together(){
        for(int tg=1;tg<=N;tg++){
            if(graph[S][tg]==MAX || graph[tg][A]==MAX || graph[tg][B]==MAX) continue;
            ans=Math.min(ans, graph[S][tg]+graph[tg][A]+graph[tg][B]);
        }
    }
    
    // 합승 안할 때
    public void no(){
        ans=Math.min(ans, graph[S][A]+graph[S][B]);
    }
    
    // 플로이드 워샬
    public void flowid(){
        for(int k=0;k<=N;k++){
            for(int i=0;i<=N;i++){
                for(int j=0;j<=N;j++){
                    if(graph[i][k]==MAX || graph[k][j]==MAX) continue;
                    graph[i][j]=Math.min(graph[i][j], graph[i][k]+graph[k][j]);
                }
            }
        }
    }
    
    // 입력값 처리
    public void init(int n, int s, int a, int b, int[][] fares){
        N=n; S=s; A=a; B=b;
        graph=new int[N+1][N+1];
        
        for(int i=0;i<=N;i++){
            Arrays.fill(graph[i], MAX);
            graph[i][i]=0;
        }
        
        int len=fares.length;
        
        for(int i=0;i<len;i++){
            int[] info=fares[i];
            graph[info[0]][info[1]]=info[2];
            graph[info[1]][info[0]]=info[2];
        }
    }
    
    
}