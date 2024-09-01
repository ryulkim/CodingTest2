import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 시간: 364ms	메모리: 97,080KB */

class Position{
	public Position(int i, int j) {
		this.x=i;
		this.y=j;
	}

	public int x, y;
	
}

class Solution
{
    public static int dr[]= {0,0,1,-1};
	public static int dc[]= {1,-1,0,0};
	public static int n;
	public static int ans=10000000, ans_cnt=0;
	
	public static boolean valid(int i, int j) {
		return i>=0&&i<n&&j>=0&&j<n;
	}
	
	public static void back(int core, int sum, int check[][], List<Position> arr, int cnt) {
		
		if(core==arr.size()) {
			if(cnt>ans_cnt) {
				ans=sum;
				ans_cnt=cnt;
			}
			else if(cnt==ans_cnt&&ans>sum) {
				ans=sum;
				ans_cnt=cnt;
			}
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int r=arr.get(core).x;
			int c=arr.get(core).y;
			int tr=r+dr[i];
			int tc=c+dc[i];
			boolean chk=false;
			
			while(valid(tr,tc)) {
				if(check[tr][tc]==1) {
					chk=true;
					break;
				}
				sum++;
				check[tr][tc]=1;
				tr+=dr[i];
				tc+=dc[i];

			}
			tr-=dr[i];
			tc-=dc[i];
			if(chk) {
				while(tr!=r||tc!=c) {
					check[tr][tc]=0;
					tr-=dr[i];
					tc-=dc[i];
					sum--;						
				}
				back(core+1, sum, check, arr,cnt);
			}
			else {
				back(core+1, sum, check, arr,cnt+1);
				while(tr!=r||tc!=c) {
					check[tr][tc]=0;
					tr-=dr[i];
					tc-=dc[i];
					sum--;						
				}
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int t=Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= t; testCase++) {
			List<Position> arr=new ArrayList<Position>();
			n=Integer.parseInt(br.readLine());
			int check[][]=new int[n+1][n+1];
			ans=10000000;
			ans_cnt=0;
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < n; j++) {
					check[i][j]=Integer.parseInt(st.nextToken());
					if(check[i][j]==1)	{
						if(i!=0&&i!=n&&j!=0&&j!=n-1) {
						arr.add(new Position(i,j));
						}
					}
				}
			}
			
			back(0,0, check, arr, 0);
			System.out.println("#"+testCase+" "+ans);
			
		}
	}
}