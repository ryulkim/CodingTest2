import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static int N;
	public static int[][] arr, cnt;
	public static int[][] dr= {{0,0,1},{0,1,1},{0,1,1}}; //가로, 세로, 대각선
	public static int[][] dc= {{1,0,1},{0,0,1},{1,0,1}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		cnt=new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		cnt[0][1]=1;
		bfs();
		
		System.out.println(cnt[N-1][N-1]);
	}
	
	public static void bfs() {
		ArrayDeque<int[]> q=new ArrayDeque<>();
		q.add(new int[] {0,1,0}); //i, j, 방향
		int dir=0; //0: 가로, 1: 세로, 2: 대각선
		
		while (!q.isEmpty()){
			int[] v=q.poll();
			dir=v[2];
			
			for (int i = 0; i < 3; i++) {
				int nr=v[0]+dr[dir][i];
				int nc=v[1]+dc[dir][i];
				
				if(!valid(nr,nc)) continue;
				if(nr==v[0]&&nc==v[1]) continue;
				if(arr[nr][nc]==1) continue;
//				if(cnt[nr][nc]!=0) continue;
				if(i==2) {
					if(nr-1>=0&&arr[nr-1][nc]==1) continue; 
					if(nc-1>=0&&arr[nr][nc-1]==1) continue; 
				}
				q.add(new int[] {nr,nc,i});
				cnt[nr][nc]++;
			}
		}
	}
	
	public static boolean valid(int i, int j) {
		return i>=0&&i<N&&j>=0&&j<N;
	}

}
