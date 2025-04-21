import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	static int N, M;
	static int[] dr= {-1,0,1,0}; //위,오,아,왼
	static int[] dc= {0,1,0,-1};
	static int[][] arr;
	
	/*
	 * 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
	 * 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
	 * 	1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
	 * 	2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
	 * 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
	 * 	1. 반시계 방향으로 90도 회전한다
	 * 	2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
	 * 4. 1번으로 돌아간다.
	 */
    public static void main(String[] args) throws IOException {
    	System.out.println(init());
    }
    
    public static int init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	
    	st=new StringTokenizer(br.readLine());
    	int r=Integer.parseInt(st.nextToken());
    	int c=Integer.parseInt(st.nextToken());
    	int d=Integer.parseInt(st.nextToken());
    	
    	arr=new int[N][M];
    	
    	for (int i = 0; i < N; i++) {
    		st=new StringTokenizer(br.readLine());
    		
			for (int j = 0; j < M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    	
    	return proc(r,c,d);
    }
    
    public static int proc(int r, int c, int d) {
    	int cnt=0;
    	
    	StringBuilder sb=new StringBuilder();
    	
    	while(true) {
    		sb.append(r+" "+c+"\n");
    		
    		// 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
    		if(arr[r][c]==0) {
    			arr[r][c]=-1;
    			cnt++;
    			continue;
    		}
    		// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는지 확인 유무
    		boolean flag=false;
    		for (int k = 0; k < 4; k++) {
    			int nr=r+dr[k];
    			int nc=c+dc[k];
    			
				if(valid(nr,nc)&&arr[nr][nc]==0) {
					flag=true;
					break;
				}
			}
    		
    		// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
    		if(!flag) {
    			// 후진 할 수 있다면
    			int behind=(d+2)%4;
    			int nr=r+dr[behind];
    			int nc=c+dc[behind];
    			
    			if(!valid(nr, nc)) break;
    			
    			if(arr[nr][nc]!=1) {
    				r=nr;
    				c=nc;
    			}
    			// 후진 할 수 없다면
    			else {
    				break;
    			}
    		}
    		// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
    		else {
    			d=(d+3)%4;
    			int nr=r+dr[d];
    			int nc=c+dc[d];
    			
    			if(!valid(nr,nc)) continue;
    			
    			if(arr[nr][nc]==0) {
    				r=nr;
    				c=nc;
    				arr[nr][nc]=-1;
    				cnt++;
    			}
    		}
    	}
    	
//    	System.out.println(sb);
    	
    	return cnt;
    }
    
    public static boolean valid(int r, int c) {
    	return r>=0&&r<N&&c>=0&&c<M;
    }
}
