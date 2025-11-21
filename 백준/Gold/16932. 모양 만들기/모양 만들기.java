import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, ans=0;
	static int[][] arr, dp;
	static int[] dr= {0,0,1,-1};
	static int[] dc= {-1,1,0,0};
	static int[] cnt;
	static HashSet<Integer> chk;
	
    public static void main(String[] args) throws IOException {
    	init();
    	proc();
    	System.out.println(ans);
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	arr=new int[N][M];
    	dp=new int[N][M];
    	cnt=new int[N*M+1];
    	for (int i = 0; i < N; i++) {
    		st=new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    	
    	int num=1;
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j]==1&&dp[i][j]==0) {
					bfs(i,j,num++);
				}
			}
		}
    }
    
    public static void bfs(int i, int j, int num) {
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	q.add(new int[] {i, j});
    	cnt[num]=1;
    	dp[i][j]=num;
    	
    	while(!q.isEmpty()) {
    		int[] info=q.poll();
    		
    		for (int k = 0; k < 4; k++) {
				int nr=info[0]+dr[k];
				int nc=info[1]+dc[k];
				
				if(!valid(nr,nc)||dp[nr][nc]!=0||arr[nr][nc]==0) {
					continue;
				}
				
				q.add(new int[] {nr, nc});
				dp[nr][nc]=num;
				cnt[num]++;
			}
    	}
    }
    
    public static void proc() {
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j]==1) continue;
				
				int sum=0;
				chk=new HashSet<>();
				for (int k = 0; k < 4; k++) {
					int nr=i+dr[k];
					int nc=j+dc[k];
					
					if(!valid(nr,nc)||arr[nr][nc]==0) continue;
					
					int num=dp[nr][nc];
					
					if(chk.contains(num)) continue;
					chk.add(num);
					sum+=cnt[num];
				}
				
				
				ans=Math.max(ans, sum+1);
			}
		}
    }
    
    public static boolean valid(int i, int j) {
    	return i>=0&&i<N&&j>=0&&j<M;
    }
}