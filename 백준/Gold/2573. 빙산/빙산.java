import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] arr, area;
	static int[] dr= {0,0,1,-1};
	static int[] dc= {-1,1,0,0};
	static boolean[][] visited;

    public static void main(String[] args) throws IOException {
		init();
		proc();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		arr=new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
    }
    
    public static void proc() {
    	int ans=0;
    	while(true) {
    		int[][] temp=new int[N][M];
    		visited=new boolean[N][M];
    		ans++;
    	
    		for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arr[i][j]==0) continue;
					
					int cnt=0;
					for (int k = 0; k < 4; k++) {
						int nr=i+dr[k];
						int nc=j+dc[k];
						
						if(arr[nr][nc]==0) cnt++;						
					}
					
					temp[i][j]=Math.max(0, arr[i][j]-cnt);
				}
			}
    		
    		arr=temp;
    		
    		int cnt=0;
    		for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arr[i][j]!=0&&!visited[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
    		
    		if(cnt>=2) {
    			System.out.println(ans);
    			return;
    		}
    		else if(cnt==0) {
    			System.out.println(0);
    			return;
    		}
    	}
    }
    
    public static void bfs(int r, int c) {
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	q.add(new int[] {r,c});
    	visited[r][c]=true;
    	
    	while(!q.isEmpty()) {
    		int[] info=q.poll();
    		r=info[0];
    		c=info[1];
    		
    		for (int k = 0; k < 4; k++) {
    			int nr=r+dr[k];
    			int nc=c+dc[k];
    			
    			if(!valid(nr,nc)||visited[nr][nc]||arr[nr][nc]==0) {
    				continue;
    			}
    			
    			visited[nr][nc]=true;
    			q.add(new int[] {nr,nc});
			}

    	}
    	
    }
    
    public static boolean valid(int r, int c) {
    	return r>=0&&r<N&&c>=0&&c<M;
    }

}
