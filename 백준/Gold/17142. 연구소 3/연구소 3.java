import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, cnt=0, MAX=1000_000_000, ans=MAX;
	static int[][] arr;
	static boolean[][] valid;
	static int[] dr= {0,0,1,-1};
	static int[] dc= {-1,1,0,0};
	static ArrayList<int[]> birus;
	static ArrayDeque<int[]> q;
	static int[] selectBirus;
	
    public static void main(String[] args) throws IOException {
    	init();
    	proc();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	arr=new int[N][N];
    	birus=new ArrayList<>();
    	q=new ArrayDeque<>();
    	selectBirus=new int[M];
    	valid=new boolean[N][N];
    	
    	for (int i = 0; i < N; i++) {
    		st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num=Integer.parseInt(st.nextToken());
				arr[i][j]=num;
				if(num==2) {
					birus.add(new int[] {i,j});
				}
				else if(num==0) {
					cnt++;
				}
			}
		}
    }
    
    public static void proc() {
    	if(cnt>0) select(0, 0);
    	else if(cnt==0) ans=0;
    	System.out.println(ans==1000_000_000?-1:ans);
    }
    
    public static void select(int depth, int start) {
    	if(depth==M) {
    		q.clear();
    		for (int k = 0; k < M; k++) {
				int bNum=selectBirus[k];
				int[] info=birus.get(bNum);
				arr[info[0]][info[1]]=3;
				q.add(new int[] {info[0], info[1], 0});
			}
    		refresh();
    		int t=bfs();
    		ans=Math.min(ans, t);
    		for (int k = 0; k < M; k++) {
				int bNum=selectBirus[k];
				int[] info=birus.get(bNum);
				arr[info[0]][info[1]]=2;
			}
    		return;
    	}
    	
    	for (int i = start; i < birus.size(); i++) {
			selectBirus[depth]=i;
			select(depth+1, i+1);
		}
    }
    
    public static int bfs() {
    	int tCnt=cnt;
    	while(!q.isEmpty()) {
    		int[] info=q.poll();
    		int r=info[0];
    		int c=info[1];
    		
    		for (int k = 0; k < 4; k++) {
				int nr=r+dr[k];
				int nc=c+dc[k];
				
				if(!valid(nr,nc)||(arr[nr][nc]!=0&&arr[nr][nc]!=2)||valid[nr][nc]) continue;
				
				q.add(new int[]{nr, nc, info[2]+1});
				valid[nr][nc]=true;
				if(arr[nr][nc]==0) tCnt--;
				if(tCnt==0) return info[2]+1;
			}
    	}
    	
    	return MAX;
    }
    
    public static boolean valid(int i, int j) {
    	return i>=0&&i<N&&j>=0&&j<N;
    }
    
    public static boolean check() {
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j]==0&&!valid[i][j]) {
					return false;
				}
			}
		}
    	
    	return true;
    }
    
    public static void refresh() {
    	for (int i = 0; i < N; i++) {
			Arrays.fill(valid[i], false);;
		}
    }

}