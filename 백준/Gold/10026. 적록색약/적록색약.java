import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Main {
	
	static int N;
	static char[][] ordinary, special;
	static int[] dr= {0,0,1,-1};
	static int[] dc= {1,-1,0,0};

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	System.out.println(ordinaryProc()+" "+specialProc());
    	
//    	chk();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	ordinary=new char[N][N];
    	special=new char[N][N];
    	
    	for (int i = 0; i < N; i++) {
    		String s=br.readLine();
			for (int j = 0; j < N; j++) {
				char c=s.charAt(j);
				if(c=='R'||c=='G') {
					ordinary[i][j]=c;
					special[i][j]='S';
				}
				else {
					ordinary[i][j]=c;
					special[i][j]=c;
				}
			}
		}
    	
    }
    
    public static int specialProc() {
    	int cnt=0;
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(special[i][j]!='F') {
					cnt++;
//					System.out.println(i+" "+j);
					specialBfs(i, j, special[i][j]);
				}
			}
		}
    	
    	return cnt;
    }
    
    public static void specialBfs(int i, int j, char color) {
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	special[i][j]='F';
    	q.add(new int[] {i,j});
    	
    	while(!q.isEmpty()) {
    		int[] pos=q.poll();
    		int r=pos[0];
    		int c=pos[1];
    		
    		for (int k = 0; k < 4; k++) {
				int nr=r+dr[k];
				int nc=c+dc[k];
				
				if(!valid(nr, nc)) continue;
				if(special[nr][nc]!=color) continue;
				
				special[nr][nc]='F';
				q.add(new int[] {nr, nc});
			}
    	}
    }
    
    
    public static int ordinaryProc() {
    	int cnt=0;
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(ordinary[i][j]!='F') {
					cnt++;
					ordinaryBfs(i, j, ordinary[i][j]);
				}
			}
		}
    	
    	return cnt;
    }
    
    public static void ordinaryBfs(int i, int j, char color) {
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	ordinary[i][j]='F';
    	q.add(new int[] {i,j});
    	
    	while(!q.isEmpty()) {
    		int[] pos=q.poll();
    		int r=pos[0];
    		int c=pos[1];
    		
    		for (int k = 0; k < 4; k++) {
				int nr=r+dr[k];
				int nc=c+dc[k];
				
				if(!valid(nr, nc)) continue;
				if(ordinary[nr][nc]!=color) continue;
				
				ordinary[nr][nc]='F';
				q.add(new int[] {nr, nc});
			}
    	}
    }
    
    public static boolean valid(int i, int j) {
    	return i>=0&&i<N&&j>=0&&j<N;
    }
}