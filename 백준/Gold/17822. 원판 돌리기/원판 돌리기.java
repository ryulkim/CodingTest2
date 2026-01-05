import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, T;
	static int[][] arr;
	static boolean[][] chk;
	static int[] dr={0,0,1,-1};
	static int[] dc={-1,1,0,0};
	static boolean flag=false;
	
    public static void main(String[] args) throws IOException {
    	init();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	T=Integer.parseInt(st.nextToken());
    	arr=new int[N+1][M];
    	chk=new boolean[N+1][M];
    	
    	for (int i = 1; i <= N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    	
    	for (int i = 0; i < T; i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			
			rotateDirect(x, d, k);
			if(!find()) {
				calculate();
			}			
		}
    	System.out.println(calculateSum());
    }
    
    public static int calculateSum() {
    	int sum=0;
    	
    	for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] > 0) {
					sum+=arr[i][j];					
				}
			}
		}
    	
    	return sum;
    }
    
    public static void calculate() {
    	double averageNum = calculateAverage();
    	
    	for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j]==0) continue;
				
				if(arr[i][j]>averageNum) {
					arr[i][j]--;
				}
				else if(arr[i][j]<averageNum){
					arr[i][j]++;
				}
			}
		}
    }
    
    private static double calculateAverage() {
    	int sum=0,cnt=0;
    	
    	for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j]>0) {
					cnt++;
					sum+=arr[i][j];
				}
			}
		}
    	
    	return (double) sum/cnt;
    }
    
    public static boolean find() {
    	boolean result=false;
    	
    	for (int i = 1; i <= N; i++) {
			Arrays.fill(chk[i], false);
		}
    	
    	for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				if(!chk[i][j]&&arr[i][j]>0) {
					if(dfs(i,j,arr[i][j])) {
						result=true;
						arr[i][j]=0;
					}
				}
			}
		}
    	
    	return result;
    }
    
    public static boolean dfs(int i, int j, int value) {
    	chk[i][j]=true;
    	boolean flag=false;
    	
    	for (int k = 0; k < 4; k++) {
			int nr=i+dr[k];
			int nc=(j+dc[k]+M)%M;
			
			if(!valid(nr,nc)||arr[nr][nc]!=value||chk[nr][nc]) continue;
			
			arr[nr][nc]=0;
			flag=true;
			
			dfs(nr,nc,value);
		}
    	
    	return flag;
    }
    
    public static void rotateDirect(int x, int dir, int k) {
    	for (int i = x; i <= N; i+=x) {
			rotateOne(i, dir, k);
		}
    }
    
    private static void rotateOne(int num, int dir, int k) {
    	int[] temp=new int[M];
    	
    	if(dir==0) {
    		for (int i = 0; i < M; i++) {
				temp[(i+k)%M]=arr[num][i];
			}
    		
    		for (int i = 0; i < M; i++) {
				arr[num][i]=temp[i];
			}
    	}
    	else {
    		for (int i = 0; i < M; i++) {
    			temp[(i-k+M)%M]=arr[num][i];				
			}
    		
    		for (int i = 0; i < M; i++) {
				arr[num][i]=temp[i];
			}
    	}
    }
    
    private static boolean valid(int i, int j) {
    	return i>=1&&i<=N&&j>=0&&j<M;
    }
}