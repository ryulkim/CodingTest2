import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {

	static int N, M, ans=1_000_000;
	static int[][] graph;
	static ArrayList<int[]> cctv;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc(0, graph);
    	System.out.println(ans);
    }
    
    public static void print(int[][] arr) {
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
    	System.out.println();
    }

	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	graph=new int[N][M];
    	cctv=new ArrayList<>();
    	
    	for (int i = 0; i < N; i++) {
    		st=new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int num=Integer.parseInt(st.nextToken());
				graph[i][j]=num;
				if(num>0&&num<6) {
					cctv.add(new int[] {i,j,num});
				}
			}
		}
    }
    
    public static void proc(int depth, int[][] arr) {
    	if(depth==cctv.size()) {
//    		print(arr);
    		chk(arr);
    		return;
    	}
    	
    	int[] infos=cctv.get(depth);		
    	int r=infos[0];
    	int c=infos[1];
    	int num=infos[2];
    	
    	switch(num) {
    	case 1:
    		for (int i = 0; i < 4; i++) {
        		int[][] temp=copy(arr);
        		one(temp,r,c,i);    
        		proc(depth+1, temp);
    		}
    		break;
    	case 2:
    		for (int i = 0; i < 2; i++) {
    			int[][] temp=copy(arr);
    			two(temp,r,c,i);
    			proc(depth+1, temp);
			}
    		break;
    	case 3:
    		for (int i = 0; i < 4; i++) {
        		int[][] temp=copy(arr);
        		three(temp,r,c,i);    
        		proc(depth+1, temp);
    		}
    		break;
    	case 4:
    		for (int i = 0; i < 4; i++) {
        		int[][] temp=copy(arr);
        		four(temp,r,c,i);    
        		proc(depth+1, temp);
    		}
    		break;
    	case 5:
    		int[][] temp=copy(arr);
    		five(temp,r,c);    
    		proc(depth+1, temp);
    		break;
    	}
    }
    	
    public static void five(int[][] arr, int r, int c) {
    	go(arr, r, c, 0);
    	go(arr, r, c, 1);
    	go(arr, r, c, 2);
    	go(arr, r, c, 3);
    }
    
    public static void four(int[][] arr, int r, int c, int dir) {
    	go(arr, r, c, dir);
    	go(arr, r, c, (dir+1)%4);
    	go(arr, r, c, (dir+3)%4);
    }
    	
    public static void three(int[][] arr, int r, int c, int dir) {
    	go(arr, r, c, dir);
    	go(arr, r, c, (dir+1)%4);
    	
    }
    	
    public static void two(int[][] arr, int r, int c, int dir) {
    	go(arr, r, c, dir);
    	go(arr, r, c, dir+2);
    }
    
    
    public static void one(int[][] arr, int r, int c, int dir) {
    	go(arr, r, c, dir);
    }
    
    public static void go(int[][] arr, int r, int c, int dir) {
    	int nr=r+dr[dir];
    	int nc=c+dc[dir];
    	
    	while(valid(nr,nc)) {
    		int info=arr[nr][nc];
    		if(info==0) arr[nr][nc]=7;
    		if(info==6) break;
    		nr+=dr[dir];
    		nc+=dc[dir];
    	}
    }
    
    public static boolean valid(int r, int c) {
    	return r>=0&&r<N&&c>=0&&c<M;
    }
    
    public static int[][] copy(int[][] arr){
    	int[][] temp=new int[N][M];
    	for (int i = 0; i < N; i++) {
    		temp[i]=Arrays.copyOf(arr[i], arr[i].length);
		}
    	return temp;
    }
    
    public static void chk(int[][] temp) {
    	int sum=0;
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(temp[i][j]==0) {
					sum++;
				}
			}
		}
    	ans=Math.min(ans, sum);
    }
    
}