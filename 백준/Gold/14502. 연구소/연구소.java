import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos{
	int i, j;

	public Pos(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}
}

public class Main {
	public static int arr[][]=new int[10][10];
	public static int dr[]= {0,0,1,-1};
	public static int dc[]= {1,-1,0,0};
	public static int n,m,ans;
	
	public static boolean valid(int i, int j) {
		return i>=0&&i<n&&j>=0&&j<m;
	}
	
	public static int bfs(int chk[][], int a, int b, int cnt) {
		Queue<Pos> q=new LinkedList<>();
		
		q.add(new Pos(a,b));
		
		while(!q.isEmpty()) {
			int r=q.peek().i;
			int c=q.peek().j;
			q.poll();
			
			for (int k = 0; k < 4; k++) {
				int tr=r+dr[k];
				int tc=c+dc[k];
				
				if(valid(tr,tc)&&chk[tr][tc]==0) {
					q.add(new Pos(tr,tc));
					chk[tr][tc]=2;
					cnt--;
				}
			}
		}
		
		return cnt;
	}
	
	public static void wall(int a, int b, int cnt) {
		if(cnt==3) {			
			int chk[][]=new int[10][10];
			int survive=0;
//			System.out.println("==================================");
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					chk[i][j]=arr[i][j];
					if(arr[i][j]==0) survive++;
				}
			}
			
			for(int i=0;i<n;i++) {
				for (int j = 0; j < m; j++) {
					if(chk[i][j]==2) {
						survive=bfs(chk, i, j, survive);
					}
				}
			}
			if(survive>ans)ans=survive;
			
			return;
		}
		
		
		for (int i = a; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(arr[i][j]==0) {
					arr[i][j]=1;
//					System.out.println(i+" "+j);
					wall(i,j,cnt+1);
					arr[i][j]=0;
				}
			}
		}
//		System.out.println("==================================");

	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		ans=0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(arr[i][j]==0) {
					wall(i, j, 0);
				}
			}
		}
		
		System.out.println(ans);
		
		
	}
	
}

/*
3 3
1 0 0
0 0 1
1 0 2
 */
