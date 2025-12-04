import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] change= {1,2,3,0};
	static int[] dr= {0,-1,0,1};
	static int[] dc= {1,0,-1,0};
	static boolean[][] arr;
	
    public static void main(String[] args) throws IOException {
    	init();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	arr=new boolean[101][101];
    	
    	for (int i = 0; i < N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int g=Integer.parseInt(st.nextToken());
			
			ArrayList<Integer> generation = generate(g, d);
			dots(x,y,generation);
		}
    	
    	System.out.println(getCount());
    }
    
    public static int getCount() {
    	int cnt=0;
    	
    	for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(arr[i][j]&&arr[i+1][j]&&arr[i][j+1]&&arr[i+1][j+1]) {
					cnt++;
				}
			}
		}
    	
    	return cnt;
    }
    
    public static void dots(int x, int y, ArrayList<Integer> generation) {
    	arr[y][x]=true;
    	for (int dir : generation) {
    		int nr=y+dr[dir];
    		int nc=x+dc[dir];
    		y=nr;
    		x=nc;
    		
    		arr[nr][nc]=true;
		}
    }
    
    public static ArrayList<Integer> generate(int g, int dir) {
    	ArrayList<Integer> temp=new ArrayList<>();
    	temp.add(dir);
    	
    	for (int i = 0; i < g; i++) {
    		int sz=temp.size();
			for (int j = sz-1; j >= 0; j--) {
				int curDir=temp.get(j);
				int nextDir=change[curDir];
				temp.add(nextDir);
			}
		}
    	
    	return temp;
    }
    
}