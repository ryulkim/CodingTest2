import java.io.*;
import java.util.*;

public class Main {
	
	static int N, ans=0, sr, sc, er, ec, MAX=1000_000_000;
	static int[][] arr, dp;
	static int[] dr= {-2, -2, 0, 0, 2, 2};
	static int[] dc= {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
    	init();
    	proc();
    	System.out.println(arr[er][ec]==MAX?-1:arr[er][ec]);
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N][N];
//    	dp=new int[N][N];
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	sr=Integer.parseInt(st.nextToken());
    	sc=Integer.parseInt(st.nextToken());
    	er=Integer.parseInt(st.nextToken());
    	ec=Integer.parseInt(st.nextToken());
    	
    	for (int i = 0; i < N; i++) {
			Arrays.fill(arr[i], MAX);
		}
    }
    
    public static void proc() {
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	q.add(new int[] {sr,sc,0});
    	
    	while(!q.isEmpty()) {
    		int[] info=q.poll();
    		int num=info[2];
    		
    		for (int k = 0; k < 6; k++) {
				int nr=info[0]+dr[k];
				int nc=info[1]+dc[k];
				
				if(!valid(nr,nc)||arr[nr][nc]!=MAX) continue;
				
				arr[nr][nc]=Math.min(arr[nr][nc], num+1);
				
				q.add(new int[] {nr,nc,num+1});
			}
    	}
    }

    public static boolean valid(int i, int j) {
    	return i>=0&&i<N&&j>=0&&j<N;
    }
    
}