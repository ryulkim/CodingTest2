import java.io.*;
import java.util.*;

public class Main {
	
	static int[][][][] boards; // 판 번호, 회전 수, 2차원 정보
	static int[][] select;
	static boolean[] selectChk;
	static int[][] direct= {{0,-1,0},{0,1,0},{1,0,0},{-1,0,0},{0,0,1},{0,0,-1}};
	static int[][] vertexs= {{0,0,0},{0,0,4},{0,4,0},{0,4,4},{4,4,4},{4,4,0},{4,0,4},{4,0,0}};
	static int ans=Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
    	init();
    	selectCube(0);
    	System.out.println(ans==Integer.MAX_VALUE?-1:ans);
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	boards=new int[5][4][5][5];
    	select=new int[5][2];
    	selectChk=new boolean[5];
    	for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				StringTokenizer st=new StringTokenizer(br.readLine());				
				for (int k = 0; k < 5; k++) {
					boards[i][0][j][k]=Integer.parseInt(st.nextToken());
				}
			}
		}
    	
    	saveRotate();
    }
    
    public static void selectCube(int depth) {
    	if(depth==5) {
    		selectDirect(0);
    		return;
    	}
    	
    	for (int i = 0; i < 5; i++) {
			if(selectChk[i]) continue;
			select[depth][0]=i;
			selectChk[i]=true;
			selectCube(depth+1);
			selectChk[i]=false;
		}
    }
    
    public static void selectDirect(int depth) {
    	if(depth==5) {
    		find();
    		return;
    	}
    	
    	for (int i = 0; i < 4; i++) {
			select[depth][1]=i;
			selectDirect(depth+1);
		}
    }
    
    public static void saveRotate() {
    	for (int boardNum = 0; boardNum < 5; boardNum++) {	
    		for (int i = 0; i < 3; i++) {
    			for (int j = 0; j < 5; j++) {
					for (int k = 0; k < 5; k++) {
						boards[boardNum][i+1][k][4-j]=boards[boardNum][i][j][k];
					}
				}
    		}
		}
    }
    
    public static void find() {
    	for (int i = 0; i < 4; i++) {
    		if(ans==12) return;
    		
    		int su=vertexs[i][0];
    		int sr=vertexs[i][1];
    		int sc=vertexs[i][2];
    		int eu=vertexs[i+4][0];
    		int er=vertexs[i+4][1];
    		int ec=vertexs[i+4][2];
    		
    		if(get(su, sr, sc)==0||get(eu, er, ec)==0) continue;
			int value=bfs(su,sr,sc,eu,er,ec);
			if(value!=-1) {
				ans=Math.min(ans, value);
			}
		}
    }
    
    private static int get(int u, int r, int c) {
        return boards[select[u][0]][select[u][1]][r][c];
    }

    
    public static int bfs(int startU, int startR, int startC, int endU, int endR, int endC) {
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	boolean[][][] chk=new boolean[5][5][5];
    	q.add(new int[] {startU, startR, startC, 0});
    	
    	while(!q.isEmpty()) {
    		int[] cur=q.poll();
    		
    		for (int k = 0; k < 6; k++) {
				int[] info=direct[k];
				int u=info[0];
				int r=info[1];
				int c=info[2];
				
				int nu=cur[0]+u;
				int nr=cur[1]+r; 
				int nc=cur[2]+c;
				
				if(!valid(nr,nc,nu)||get(nu,nr,nc)==0||chk[nu][nr][nc]) continue;
				
				q.add(new int[] {nu, nr, nc, cur[3]+1});
				chk[nu][nr][nc]=true;
				if(nu==endU&&nr==endR&&nc==endC) {
					return cur[3]+1;
				}
			}
    	}
    	
    	return -1;
    }
    
    private static boolean valid(int r, int c, int u) {
    	return r>=0&&r<5&&c>=0&&c<5&&u>=0&&u<5;
    }
}


