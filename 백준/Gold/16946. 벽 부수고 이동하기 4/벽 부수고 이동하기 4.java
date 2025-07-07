import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] arr, group, ans;
	static int[] cnt;
	static int[] dr= {0,0,1,-1};
	static int[] dc= {1,-1,0,0};
	static ArrayDeque<int[]> wall;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    	print();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	arr=new int[N][M];
    	group=new int[N][M];
    	ans=new int[N][M];
    	cnt=new int[1000_000];
    	wall=new ArrayDeque<>();
    	
    	for (int i = 0; i < N; i++) {
			String s=br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j]=s.charAt(j)-'0';
			}
		}
    	
    	int g=1;
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j]==0&&group[i][j]==0) {
					group[i][j]=g;
					cnt[g]++;
					bfs(g++,i,j);
				}
				else if(arr[i][j]==1) wall.add(new int[] {i,j});
			}
		}
    }
    
    public static void chk() {
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(group[i][j]+" ");
			}
			System.out.println();
		}
    }
    
    public static void proc() {
    	while(!wall.isEmpty()) {
    		int[] info=wall.poll();
    		int i=info[0];
    		int j=info[1];
    		if(arr[i][j]==0) continue;
			int sum=0;
			HashSet<Integer> g=new HashSet<Integer>();
			for (int k = 0; k < 4; k++) {
				int nr=i+dr[k];
				int nc=j+dc[k];
				if(!valid(nr,nc)) continue;
				if(arr[nr][nc]==1) continue;
				if(g.contains(group[nr][nc])) continue;
				sum+=cnt[group[nr][nc]];
				g.add(group[nr][nc]);
			}
			ans[i][j]=(sum+1)%10;
    	}
    }
    
    public static void print() {
    	StringBuilder sb=new StringBuilder();
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(ans[i][j]);
			}
			sb.append("\n");
		}
    	
    	System.out.println(sb);
    }
    
    public static void bfs(int g, int r, int c) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0], cc = cur[1];

            for (int k = 0; k < 4; k++) {
                int nr = cr + dr[k];
                int nc = cc + dc[k];

                if (!valid(nr, nc)) continue;
                if (arr[nr][nc] == 1) continue;
                if (group[nr][nc] != 0) continue;

                group[nr][nc] = g;
                cnt[g]++;
                q.add(new int[]{nr, nc});
            }
        }
    }

    
    public static void dfs(int g, int r, int c) {
    	for (int k = 0; k < 4; k++) {
			int nr=r+dr[k];
			int nc=c+dc[k];
			
			if(!valid(nr,nc)) continue;
			if(arr[nr][nc]==1) continue;
			if(group[nr][nc]!=0) continue;
			
			group[nr][nc]=g;
			cnt[g]++;
			dfs(g,nr,nc);
		}
    }
    
    public static boolean valid(int r, int c) {
    	return r>=0&&r<N&&c>=0&&c<M;
    }
}