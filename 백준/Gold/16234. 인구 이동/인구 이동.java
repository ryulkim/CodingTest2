import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {

	static int N, L, R;
	static int[][] graph;
	static int[] dr= {0,0,1,-1};
	static int[] dc= {1,-1,0,0};
	static ArrayList<int[]> infos;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	int ans=0;
    	while(proc()>0) {
    		ans++;
    	}
    	System.out.println(ans);
    }

	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	L=Integer.parseInt(st.nextToken());
    	R=Integer.parseInt(st.nextToken());
    	graph=new int[N][N];
    	infos=new ArrayList<int[]>();
    	
    	for (int i = 0; i < N; i++) {
    		st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    }
    
    public static int proc() {
    	int[][] together=new int[N][N];
    	int num=1;
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(together[i][j]==0) {
					bfs(i,j,together,num++);
				}
			}
		}
    	
    	if(num>N*N) return -1;
    	
    	return num-1;
    }

    
    public static void bfs(int r, int c, int[][] arr, int num) {
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	arr[r][c]=num;
    	q.add(new int[] {r,c});
    	int cnt=0;
    	int sum=0;
    	infos.clear();
    	infos.add(new int[] {r,c});
    	
    	while(!q.isEmpty()) {
    		int[] info=q.poll();
    		r=info[0];
    		c=info[1];
    		cnt++;
    		sum+=graph[r][c];
    		
    		for (int i = 0; i < 4; i++) {
    			int nr=r+dr[i];
    			int nc=c+dc[i];
				
    			if(!valid(nr,nc)) continue;
    			if(arr[nr][nc]!=0) continue;
    			
    			int value=Math.abs(graph[r][c]-graph[nr][nc]);

    			if(value<L||value>R) continue;
    			
    			arr[nr][nc]=num;
    			q.add(new int[] {nr,nc});
    			infos.add(new int[] {nr,nc});
			}
    	}
    	
    	int value=sum/cnt;
    	for (int i = 0; i < infos.size(); i++) {
			graph[infos.get(i)[0]][infos.get(i)[1]]=value;
		}
    }
    
    public static boolean valid(int r, int c) {
    	return r>=0&&r<N&&c>=0&&c<N;
    }
}