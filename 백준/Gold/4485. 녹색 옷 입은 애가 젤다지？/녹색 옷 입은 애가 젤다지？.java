import java.io.*;
import java.util.*;

public class Main {
    
	public static int T,N,map[][];
	public static int dr[]= {-1,1,0,0};
	public static int dc[]= {0,0,-1,1};
	public static final int INF=Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = 1;
        
        while(true) {
        	N=Integer.parseInt(br.readLine());
        	if(N==0) break;
        	map=new int[N][N];
        	
        	for (int i = 0; i < N; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
        	System.out.println("Problem "+T+++": "+dijkstra());
        }
        
    }
    
    static int dijkstra() {
    	boolean[][] visited=new boolean[N][N];
    	int[][] minValue=new int[N][N];
    	PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[2], b[2]));
    	
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			minValue[i][j]=INF;
			}
		}
    	
    	minValue[0][0]=map[0][0];
    	pq.add(new int[] {0,0,map[0][0]});
    	
    	while(!pq.isEmpty()) {
    		int[] stopOver=pq.poll();
    		int r=stopOver[0];
    		int c=stopOver[1];
    		int v=stopOver[2];
    		
    		if(r==N-1&&c==N-1) return minValue[r][c];
    		if(visited[r][c]) continue;
    		visited[r][c]=true;
    		
    		for (int k = 0; k < 4; k++) {
    			int nr=r+dr[k];
    			int nc=c+dc[k];
    			
    			if(!valid(nr,nc)) continue;
				if(visited[nr][nc]) continue;
				if(minValue[nr][nc]>minValue[r][c]+map[nr][nc]) {
					minValue[nr][nc]=minValue[r][c]+map[nr][nc];
					pq.offer(new int[] {nr,nc,minValue[nr][nc]});
				}
			}
    	}
    	
    	return -1;
    }
    
    static boolean valid(int i, int j) {
    	return i>=0&&i<N&&j>=0&&j<N;
    }
}
