import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, K, r, c, m, s, d;
	static ArrayDeque<int[]>[][] arr, next;
	static int[] dr= {-1,-1,0,1,1,1,0,-1};
	static int[] dc= {0,1,1,1,0,-1,-1,-1};
	
    public static void main(String[] args) throws IOException {
    	init();
    	proc();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	K=Integer.parseInt(st.nextToken());
    	arr=new ArrayDeque[N+1][N+1];
    	next=new ArrayDeque[N+1][N+1];
    	
    	for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				arr[i][j]=new ArrayDeque<>();
				next[i][j]=new ArrayDeque<>();
			}
		}
    	
    	for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			r=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			s=Integer.parseInt(st.nextToken());
			d=Integer.parseInt(st.nextToken());
			
			arr[r][c].add(new int[] {m,s,d});
		}
    }
    
    public static void proc() {
    	for (int i = 0; i < K; i++) {
			move();
			together();
		}
    	
    	int sum=0;
    	for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				while(!arr[i][j].isEmpty()) {
					sum+=arr[i][j].poll()[0];
				}
			}
		}
    	System.out.println(sum);
    }
    
    public static void together() {
    	for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(arr[i][j].size()>1) {
					int sumM=0;
					int sumS=0;
					int sumD=0; // bitMasking
					int sz=arr[i][j].size();
					
					while(!arr[i][j].isEmpty()) {
						int[] info=arr[i][j].poll();
						int m=info[0];
						int s=info[1];
						int d=info[2];
						
						sumM+=m;
						sumS+=s;
						if(d%2==0) {
							sumD|=2;
						}
						else {
							sumD|=1;
						}
					}
					
					if(sumM/5==0) {
						continue;
					}
					
					int rM=sumM/5;
					int rS=sumS/sz;
					
					if(sumD==3) {
						arr[i][j].add(new int[] {rM, rS, 1});
						arr[i][j].add(new int[] {rM, rS, 3});
						arr[i][j].add(new int[] {rM, rS, 5});
						arr[i][j].add(new int[] {rM, rS, 7});
					}
					else {
						arr[i][j].add(new int[] {rM, rS, 0});
						arr[i][j].add(new int[] {rM, rS, 2});
						arr[i][j].add(new int[] {rM, rS, 4});
						arr[i][j].add(new int[] {rM, rS, 6});
					}
				}
			}
		}
    }
    
    public static void move() {
    	for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				while(!arr[i][j].isEmpty()) {
					int[] info=arr[i][j].poll();
					int m=info[0];
					int s=info[1];
					int k=info[2];
					int nr=validMove(i+s*dr[k]);
					int nc=validMove(j+s*dc[k]);
					
					next[nr][nc].add(new int[] {m,s,k});
				}
			}
		}
    	
    	ArrayDeque<int[]>[][] temp=arr;
    	arr=next;
    	next=temp;
    }
    
    public static int validMove(int go) {
        int x = (go - 1) % N;  // 0~N-1 형태로 보정하려는 준비 단계

        if (x < 0) x += N;     // 음수라면 한 번만 올려주면 0~N-1 범위 확정

        return x + 1;          // 다시 1~N으로 변환
    }

}