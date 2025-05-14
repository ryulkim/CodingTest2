import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M;
	static int[][] arr;
	static int[][] dp;
	static int[] dr= {0,0,1,-1};
	static int[] dc= {1,-1,0,0};
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	dij();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	M=Integer.parseInt(st.nextToken());
    	N=Integer.parseInt(st.nextToken());
    	arr=new int[N][M];
    	dp=new int[N][M];
    	
    	for (int i = 0; i < N; i++) {
			String s=br.readLine();
			Arrays.fill(dp[i], 1000_000_000);
			
			for (int j = 0; j < M; j++) {
				arr[i][j]=(s.charAt(j)=='0')?0:1;
			}
		}
    }
    
    public static void dij() {
    	PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[2], b[2])); // i, j, 부수는 개수
    	pq.add(new int[] {0,0,0});
    	
    	while(!pq.isEmpty()) {
    		int[] info=pq.poll();
    		
//    		System.out.println(info[0]+" "+info[1]+" "+info[2]);
    		
    		if(dp[info[0]][info[1]]<info[2]) continue;
    		
    		if(info[0]==N-1&&info[1]==M-1) {
    			System.out.println(info[2]);
    			return;
    		}
    		
    		for (int k = 0; k < 4; k++) {
    			int nr=info[0]+dr[k];
    			int nc=info[1]+dc[k];
    			
				if(!valid(nr,nc)) continue;
				
				if(arr[nr][nc]==1&&dp[nr][nc]>info[2]+1) {
					dp[nr][nc]=info[2]+1;
					pq.add(new int[] {nr,nc,info[2]+1});
				}
				
				else if(arr[nr][nc]==0&&dp[nr][nc]>info[2]) {
					dp[nr][nc]=info[2];
					pq.add(new int[] {nr,nc,info[2]});
				}
			}
    		
    		
    	}
    }
    
    public static boolean valid(int i, int j) {
    	return i>=0&&i<N&&j>=0&&j<M;
    }

}