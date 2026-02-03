import java.io.*;
import java.util.*;

public class Main {
	
	static int w, h, answer;
	static int[] dr= {0,0,1,-1};
	static int[] dc= {1,-1,0,0};
	static int[][] arr;
	static int cntDirty;
	static int sr, sc;
	static int[][] dist;
	static int[] select;
	static ArrayList<int[]> dirty;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			if(!init(br)) {
				break;
			}
	    	System.out.println(proc());
		}
	}
    
    public static boolean init(BufferedReader br) throws IOException {
    	StringBuilder sb=new StringBuilder();
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	w=Integer.parseInt(st.nextToken());
    	h=Integer.parseInt(st.nextToken());
    	
    	if(w==0&&h==0) return false;
    	
    	sr=0; sc=0; cntDirty=0;
    	dirty=new ArrayList<>();
    	
    	
    	arr=new int[h][w];
    	cntDirty=1;
    	answer=Integer.MAX_VALUE;
    	
    	for (int i = 0; i < h; i++) {
    		String s=br.readLine();
			for (int j = 0; j < w; j++) {
				char c=s.charAt(j);
				if(c=='*') {
					arr[i][j]=cntDirty++;
					dirty.add(new int[] {i,j});
				}
				else if(c=='o') {
					sr=i; sc=j;
				}
				else if(c=='x') {
					arr[i][j]=-1;
				}
			}
		}
    	
    	cntDirty--;
    	select=new int[cntDirty+1];
    	dist=new int[cntDirty+1][cntDirty+1];
    	resetDist();
    	
    	
    	return true;
    }
    
    public static void resetDist() {
    	for (int i = 0; i <= cntDirty; i++) {
			for (int j = 0; j <= cntDirty; j++) {
				dist[i][j]=Integer.MAX_VALUE;
				if(i==j) dist[i][j]=0;
			}
		}
    }
    
    public static int proc() {
    	bfs(sr,sc,0);
    	for(int i=0;i<cntDirty;i++) {
    		int[] info=dirty.get(i);
    		bfs(info[0], info[1], i+1);
    	}
    	
    	permutation(1, 0);
    	return answer==Integer.MAX_VALUE?-1:answer;
    }
    
    public static void permutation(int depth, int flag) {
    	if(depth==cntDirty+1) {
    		int start=0;
    		int ans=0;
    		for (int i = 1; i <= cntDirty; i++) {
    			int value=dist[start][select[i]];
				if(value==Integer.MAX_VALUE) return;
				ans+=value;
				start=select[i];
			}
    		answer=Math.min(answer, ans);
    		
    		return;
    	}
    	for (int i = 1; i <= cntDirty; i++) {
    		if((flag&(1<<i))!=0) continue;
			select[depth]=i;
			permutation(depth+1, flag|1<<i);
		}
    }
    
    private static void bfs(int r, int c, int num) {
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	q.add(new int[] {r,c,0});
    	boolean[][] chk=new boolean[h][w];
    	chk[r][c]=true;
    	
    	while(!q.isEmpty()) {
    		int[] info=q.poll();
    		
    		for (int k = 0; k < 4; k++) {
				int nr=info[0]+dr[k];
				int nc=info[1]+dc[k];
				
				if(!valid(nr,nc)||arr[nr][nc]==-1||chk[nr][nc]) continue;
				int value=arr[nr][nc];
				
				if(value>0) {
					dist[num][value]=info[2]+1;
					dist[value][num]=info[2]+1;
				}
				
				chk[nr][nc]=true;
				q.add(new int[] {nr,nc,info[2]+1});
			}
    	}
    	
    	return;
    }
    
    private static boolean valid(int i, int j) {
    	return i>=0&&i<h&&j>=0&&j<w;
    }
    
    
}


