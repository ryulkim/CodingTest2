import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, K, R, C, cnt=0;
	static char[][] board;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {-1,1,0,0};
	static boolean[][] chk;
	
    public static void main(String[] args) throws IOException {
    	init();
    	proc();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	board=new char[12][6];
    	chk=new boolean[12][6];
    	
    	for (int i = 0; i < 12; i++) {
			String s=br.readLine();
			for (int j = 0; j < 6; j++) {
				board[i][j]=s.charAt(j);
			}
		}
    }
    
    public static void proc() {
    	int ans=0;
    	
    	while(true) {
    		
    		down();
    		
    		boolean flag=false;
    		for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if(find(i,j,board[i][j])) flag=true;
				}
			}
    		
    		if(flag) {
    			ans++;
    		}
    		else {
    			break;
    		}
    		
    		
    		
    	}
    	
    	System.out.println(ans);
    }
    
    private static void down() {
    	for (int i = 0; i < 6; i++) {
    		int j=11;
			while(j>0) {
				char value=board[j][i];
				int nj=j;
				if(value=='.') {
					while(nj>0&&board[nj][i]=='.') nj--;
					board[j][i]=board[nj][i];
					board[nj][i]='.';
				}
				j--;
			}
		}
    }
    
    private static boolean find(int startR, int startC, char value) {
    	if(value=='.') return false;
    	
		for (int k = 0; k < 12; k++) {
			Arrays.fill(chk[k], false);
		}
    	
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	ArrayList<int[]> ans=new ArrayList<>();
    	q.add(new int[] {startR, startC});
    	ans.add(new int[] {startR, startC});
    	chk[startR][startC]=true;
    	
    	while(!q.isEmpty()) {
    		int[] info=q.poll();
    		startR=info[0];
    		startC=info[1];
    		
    		for (int k = 0; k < 4; k++) {
    			int nr=startR+dr[k];
    			int nc=startC+dc[k];
    			
    			if(!valid(nr, nc)||chk[nr][nc]) continue;
    			
    			if(value==board[nr][nc]) {
    				q.add(new int[] {nr, nc});
    				ans.add(new int[] {nr, nc});
    				chk[nr][nc]=true;
    			}
    		}
    	}
    	
    	if(ans.size()>=4) {
    		for (int[] info : ans) {
				board[info[0]][info[1]]='.';
			}
    		return true;
    	}
    	return false;
    }
    
    private static boolean valid(int i, int j) {
    	return i>=0&&i<12&&j>=0&&j<6;
    }
 
}


