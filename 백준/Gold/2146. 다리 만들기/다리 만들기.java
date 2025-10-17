import java.io.*;
import java.util.*;

public class Main {
	
	static int N, C;
	static int[][] arr, area;
	static int[] dr= {0,0,1,-1};
	static int[] dc= {-1,1,0,0};

    public static void main(String[] args) throws IOException {
		init();
		proc();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		area=new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
    }
    
    public static void decideArea() {
    	int num=1;
    	
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			if(arr[i][j]==1&&area[i][j]==0) {
    				bfsArea(i,j,num++);
    			}
    		}
    	}
    	
    }
    
    public static void proc() {
    	decideArea();
    	
    	int ans=Integer.MAX_VALUE;
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(area[i][j]==0) continue;
				
				boolean chk=true;
				
				for (int k = 0; k < 4; k++) {
					int nr=i+dr[k];
					int nc=j+dc[k];
					
					if(!valid(nr,nc)) continue;
					
					if(area[nr][nc]==0) chk=false;
				}
				
				if(!chk) {
					ans=Math.min(ans, distanceDfs(i, j, area[i][j]));
				}
			}
		}
    	
    	System.out.println(ans);
    }
    
    public static int distanceDfs(int r, int c, int num) {
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	q.add(new int[] {r,c,0});
    	boolean[][] visited=new boolean[N][N];
    	visited[r][c]=true;
    	
    	while(!q.isEmpty()) {
    		int[] info=q.poll();
    		r=info[0];
    		c=info[1];
    		
    		for (int k = 0; k < 4; k++) {
    			int nr=r+dr[k];
    			int nc=c+dc[k];
    			
    			if(!valid(nr,nc)||area[nr][nc]==num||visited[nr][nc]) continue;
    			
				if(area[nr][nc]!=0) {
					return info[2];
				}
				else {
					visited[nr][nc]=true;
					q.add(new int[] {nr,nc,info[2]+1});
				}
			}
    	}
    	
    	return Integer.MAX_VALUE;
    }
    
    public static void bfsArea(int r, int c, int num) {
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	q.add(new int[] {r,c,0});
    	area[r][c]=num;
    	
    	while(!q.isEmpty()) {
    		int[] info=q.poll();
    		r=info[0];
    		c=info[1];
    		
    		for (int k = 0; k < 4; k++) {
				int nr=r+dr[k];
				int nc=c+dc[k];
				
				if(!valid(nr, nc)||area[nr][nc]!=0||arr[nr][nc]==0) continue;
				
				area[nr][nc]=num;
				q.add(new int[] {nr,nc,info[2]+1});
			}
    	}
    }
    
    public static boolean valid(int r, int c) {
    	return r>=0&&r<N&&c>=0&&c<N;
    }

}
