import java.io.*;
import java.util.*;

public class Main {

	static int N, ans=0;
	static int[][] arr;
	static int[] dr= {0,0,1,-1};
	static int[] dc= {1,-1,0,0};
	
    public static void main(String[] args) throws Exception {
    	init();
    }
        
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N][N];
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    	
    	for (int i = 0; i <= 100; i++) {
			proc(i);
		}
    	
    	System.out.println(ans);
    	
    }
    
    public static void proc(int num) {
    	boolean[][] chk=new boolean[N][N];
    	int cnt=0;
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j]>num&&!chk[i][j]) {
					bfs(i,j,chk,num);
					cnt++;
				}
			}
		}
    	
    	ans=Math.max(ans, cnt);
    }
    
    public static void bfs(int i, int j, boolean[][] chk, int num) {
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	q.add(new int[] {i,j});
    	chk[i][j]=true;
    	
    	while(!q.isEmpty()) {
    		int[] info=q.poll();
    		
    		for (int k = 0; k < 4; k++) {
				int nr=info[0]+dr[k];
				int nc=info[1]+dc[k];
				
				if(!valid(nr,nc)||chk[nr][nc]||arr[nr][nc]<=num) {
					continue;
				}
				
				chk[nr][nc]=true;
				q.add(new int[] {nr,nc});
			}
    	}
    }
    
    public static boolean valid(int i, int j) {
    	return i>=0&&i<N&&j>=0&&j<N;
    }
    
    
}
