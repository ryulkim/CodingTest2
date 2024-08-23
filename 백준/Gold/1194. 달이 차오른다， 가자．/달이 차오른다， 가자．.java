import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 시간: 580ms, 메모리: 66620KB
 */

public class Main {
	
	public static char arr[][];
	public static int cnt[][][];
	public static int dr[]= {0,-1,0,1};
	public static int dc[]= {-1,0,1,0};
	public static int n,m,sr,sc,er,ec,ans=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr=new char[n][m];
		cnt=new int[n][m][65];
		
		for (int i = 0; i < n; i++) {
			String s=br.readLine();
			for (int j = 0; j < m; j++) {
				char c=s.charAt(j);
				arr[i][j]=c;
				if(c=='0') {
					sr=i;
					sc=j;
				}
			}
		}
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				for (int k = 0; k <= 64; k++) {
//					cnt[i][j][k]=Integer.MAX_VALUE;
//				}
//			}
//		}
		
		cnt[sr][sc][0]=0;
		bfs();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(arr[i][j]=='1') {					
					for (int k = 0; k <= 64; k++) {
						if(ans<cnt[i][j][k]) {
							ans=cnt[i][j][k];
						}
					}
				}
			}
		}
		
		if(ans==0) {
			System.out.println(-1);
		}
		else System.out.println(ans);
	}
	
	public static void bfs() {
		Queue<int[]> q=new LinkedList<>(); // i,j,열쇠 가진 것,전체 이동 횟수
		q.add(new int[] {sr,sc,0});
		
		while (!q.isEmpty()){
			
//			for (int[] temp : q) {
//				System.out.println(Arrays.toString(temp));
//			}
//			System.out.println();
			int[] v=q.poll();
			int num=cnt[v[0]][v[1]][v[2]];
			if(arr[v[0]][v[1]]=='1') {
				return;
			}
			
			for (int k = 0; k < 4; k++) {
				int nr=v[0]+dr[k];
				int nc=v[1]+dc[k];
				
				
				if(!valid(nr,nc)) continue;
				
				if(arr[nr][nc]=='1') {
					cnt[nr][nc][v[2]]=num+1;
					return;
				}
				
				if (cnt[nr][nc][v[2]]>0) continue;
				
				if(arr[nr][nc]=='#') continue;
				
				if(arr[nr][nc]>='A'&&arr[nr][nc]<='F'&&(v[2]|(1<<arr[nr][nc]-'A'))==v[2]) {
					q.add(new int[] {nr, nc, v[2]});
					cnt[nr][nc][v[2]]=num+1;
				}
				else if(arr[nr][nc]>='a'&&arr[nr][nc]<='f'&&cnt[nr][nc][v[2]|(arr[nr][nc]-'a')]==0) {
					q.add(new int[] {nr, nc, v[2]|1<<(arr[nr][nc]-'a')});
					cnt[nr][nc][v[2]|1<<(arr[nr][nc]-'a')]=num+1;
				}
				else if((arr[nr][nc]=='.'||arr[nr][nc]=='0')) {
					q.add(new int[] {nr, nc, v[2]});
					cnt[nr][nc][v[2]]=num+1;
				}
			}
		}
		
	}
	
	public static boolean valid(int i, int j) {
		return i>=0&&i<n&&j>=0&&j<m;
	}

}

 
/*
1 7
f0.F..1

5 5
....1
#1###
.1.#0
....A
.1.#.
*/