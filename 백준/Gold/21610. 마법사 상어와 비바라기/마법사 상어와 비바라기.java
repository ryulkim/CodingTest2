import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] arr;
	static ArrayList<int[]> cloudInfo;
	static int[] dr= {0,-1,-1,-1,0,1,1,1};
	static int[] dc= {-1,-1,0,1,1,1,0,-1};
	
    public static void main(String[] args) throws IOException {
    	init();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	arr=new int[N][N];
    	cloudInfo=new ArrayList<>();
    	
    	for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    	
    	bibaragi();
    	
    	for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int d=Integer.parseInt(st.nextToken())-1;
			int s=Integer.parseInt(st.nextToken());
			moveCloud(d, s);
			rain();
			waterCopy();
			createCloud();
		}
    	
    	System.out.println(result());
    }
    
    public static int result() {
    	int sum=0;
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum+=arr[i][j];
			}
		}
    	
    	return sum;
    }
    
    public static void createCloud() {
    	boolean[][] check=new boolean[N][N];
    	
    	for (int i = 0; i < cloudInfo.size(); i++) {
			int[] info=cloudInfo.get(i);
			check[info[0]][info[1]]=true;
		}
    	
    	cloudInfo.clear();
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j]>=2&&!check[i][j]) {
					arr[i][j]-=2;
					cloudInfo.add(new int[] {i,j});
				}
			}
		}
    }
    
    public static void waterCopy() {
    	for (int i = 0; i < cloudInfo.size(); i++) {
			int[] info=cloudInfo.get(i);
			int r=info[0];
			int c=info[1];
			int count=countBucket(info[0], info[1]);
			
			arr[r][c]+=count;
		}
    }
    
    public static int countBucket(int i, int j) {
    	int count=0;
    	for (int k = 1; k < 8; k+=2) {
			int nr=dr[k]+i;
			int nc=dc[k]+j;
			if(valid(nr,nc)&&arr[nr][nc]>0) {
				count++;
			}
		}
    	return count;
    }
    
    public static boolean valid(int i, int j) {
    	return i>=0&&i<N&&j>=0&&j<N;
    }
    
    public static void rain() {
    	for (int i = 0; i < cloudInfo.size(); i++) {
			int[] info=cloudInfo.get(i);
			int r=info[0];
			int c=info[1];
			arr[r][c]++;
		}
    }
    
    public static void moveCloud(int d, int s) {
    	for (int i = 0; i < cloudInfo.size(); i++) {
			int[] info=cloudInfo.get(i);
			info[0]=validMove(info[0]+dr[d]*s);
			info[1]=validMove(info[1]+dc[d]*s);
		}
    }
    
    public static int validMove(int num) {
    	return ((num%N)+N)%N;
    }
    
    public static void bibaragi() {
    	cloudInfo.add(new int[] {N-2,0});
    	cloudInfo.add(new int[] {N-2,1});
    	cloudInfo.add(new int[] {N-1,0});
    	cloudInfo.add(new int[] {N-1,1});
    }

}