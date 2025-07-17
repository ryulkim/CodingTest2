import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, ans=-1;
	static int[][] arr;
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	static boolean[][] visited;
	static ArrayDeque<int[]> q; // i,j,타입(j/f),타임
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    	System.out.println(ans==-1?"IMPOSSIBLE":ans);
    }
    
	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	R=Integer.parseInt(st.nextToken());
    	C=Integer.parseInt(st.nextToken());
    	arr=new int[R][C];
    	q=new ArrayDeque<>();
    	visited=new boolean[R][C];
    	
    	
    	for (int i = 0; i < R; i++) {
    		String s=br.readLine();
			for (int j = 0; j < C; j++) {
				char c=s.charAt(j);
				if(c=='J') {
					q.add(new int[] {i,j,0,0});
					arr[i][j]=1000_000_000;
					visited[i][j]=true;
				}
				else if(c=='F') {
					q.add(new int[] {i,j,1,0});
					arr[i][j]=0;
				}
				else if(c=='#'){
					arr[i][j]=-2;
				}
				else {
					arr[i][j]=1000_000_000;
				}
			}
		}
    	
	}
	
	public static void proc() {
		
		while(!q.isEmpty()) {
			int[] info=q.poll();
			
//			System.out.println(info[0]+" "+info[1]+" "+info[2]+" "+info[3]);
			
			if(info[2]==0) {
				if(arr[info[0]][info[1]]<=info[3]) continue;
			}
			
			
			for (int k = 0; k < 4; k++) {
				int nr=info[0]+dr[k];
				int nc=info[1]+dc[k];
				
				if(info[2]==1) {
					if(valid(nr,nc)&&arr[nr][nc]==1000_000_000) {
						q.add(new int[] {nr,nc,1,info[3]+1});
						arr[nr][nc]=info[3]+1;
					}
				}
				else if(info[2]==0) {
					if(!valid(nr,nc)) {
						ans=info[3]+1;
						return;
					}
					
					if(arr[nr][nc]==1000_000_000&&!visited[nr][nc]) {
						q.add(new int[] {nr,nc,0,info[3]+1});
						visited[nr][nc]=true;
					}
				}
				
			}
		}
	}
	
	public static boolean valid(int r, int c) {
		return r>=0&&r<R&&c>=0&&c<C;
	}
	
}
