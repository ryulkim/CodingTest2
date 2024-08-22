import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 시간: 320ms	메모리: 50852KB
 */
public class Main {
	
	public static int r, c, ans;
	public static int[][] arr, chk;
	public static int[] dr= {-1,0,1};
	public static int[] dc= {1,1,1};
	public static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		arr=new int[r][c];
		
		for (int i = 0; i < r; i++) {
			String s=br.readLine();
			for (int j = 0; j < c; j++) {
				if(s.charAt(j)=='.') {
					arr[i][j]=0;
				}
				else {
					arr[i][j]=-1;
				}
			}
		}
		
		for (int i = 0; i < r; i++) {
			flag=false;
			arr[i][0]=1;
			dfs(i,0);
		}
		
		for (int i = 0; i < r; i++) {
			if(arr[i][c-1]==1) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
	public static void dfs(int i, int j) {
		if(j==c-1) {
			flag=true;
			return;
		}
		
		for (int k = 0; k < 3; k++) {
			int nr=dr[k]+i;
			int nc=dc[k]+j;
			
			if(flag) return;
			
			if(valid(nr, nc)&&arr[nr][nc]==0) {
				arr[nr][nc]=1;
				dfs(nr, nc);
			}
			
		}
		
	}
	
	public static boolean valid(int i, int j) {
		return i>=0&&i<r&&j>=0&&j<c;
	}

}

/*
5 5
.xx..
..x..
.....
...x.
...x.
*/
