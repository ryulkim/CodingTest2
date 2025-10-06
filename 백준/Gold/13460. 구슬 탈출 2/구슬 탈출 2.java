import java.io.*;
import java.util.*;

public class Main {

	static String s;
	static int N, M;
	static int[][] arr;
	static ArrayDeque<int[]> q;
	static int[] dr= {0,0,1,-1};
	static int[] dc= {-1,1,0,0};
	
    public static void main(String[] args) throws Exception {
    	init();
    	System.out.println(proc());
    }
        
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	arr=new int[N][M];
    	q=new ArrayDeque<>();
    	int[] info=new int[5];
    	for (int i = 0; i < N; i++) {
    		String row=br.readLine();
			for (int j = 0; j < M; j++) {
				char c=row.charAt(j);
				
				if(c=='#') {
					arr[i][j]=1;
				}
				else if(c=='O') {
					arr[i][j]=2;
				}
				else if(c=='R') {
					info[0]=i;
					info[1]=j;
				}
				else if(c=='B') {
					info[2]=i;
					info[3]=j;
				}
			}
		}
    	
    	q.add(info);
    }
    
    public static int proc() {
    	while(!q.isEmpty()) {
    		int[] info=q.poll();
    		if(info[4]>=10) continue;
    		
    		for (int k = 0; k < 4; k++) {
				int[] result=go(info, k);
				
				if(result[2]<=0||result[3]<=0) {
					continue;
				}
				else if(result[0]==-1||result[1]==-1) {
					return result[4];
				}
				
				q.add(result);
			}
    	}
    	
    	return -1;
    }
    
    public static int[] go(int[] info, int dir) { // 왼,오,아래,위
    	if(dir==0) {
    		int oResult=getPosition(info[0], info[1], dir);
			int tResult=getPosition(info[2], info[3], dir);
			
    		if(info[0]==info[2]&&oResult==tResult) {
    			if(info[1]<info[3]) {
    				return new int[] {info[0], oResult, info[2], oResult+1, info[4]+1};
    			}else {
    				return new int[] {info[0], oResult+1, info[2], oResult, info[4]+1};
    			}
    		}
    		else {
    			return new int[] {info[0], oResult, info[2], tResult, info[4]+1};
    		}
    	}
    	else if(dir==1) {
    		int oResult=getPosition(info[0], info[1], dir);
			int tResult=getPosition(info[2], info[3], dir);
			
    		if(info[0]==info[2]&&oResult==tResult) {
    			if(info[1]>info[3]) {
    				return new int[] {info[0], oResult, info[2], oResult-1, info[4]+1};
    			}else {
    				return new int[] {info[0], oResult-1, info[2], oResult, info[4]+1};
    			}
    		}
    		else {
    			return new int[] {info[0], oResult, info[2], tResult, info[4]+1};
    		}
    	}
    	else if(dir==2) {
    		int oResult=getPosition(info[0], info[1], dir);
			int tResult=getPosition(info[2], info[3], dir);
			
    		if(info[1]==info[3]&&oResult==tResult) {
    			if(info[0]>info[2]) {
    				return new int[] {oResult, info[1], oResult-1, info[3], info[4]+1};
    			}else {
    				return new int[] {oResult-1, info[1], oResult, info[3], info[4]+1};
    			}
    		}
    		else {
    			return new int[] {oResult, info[1], tResult, info[3], info[4]+1};
    		}
    	}
    	else {
    		int oResult=getPosition(info[0], info[1], dir);
			int tResult=getPosition(info[2], info[3], dir);
			
    		if(info[1]==info[3]&&oResult==tResult) {
    			if(info[0]<info[2]) {
    				return new int[] {oResult, info[1], oResult+1, info[3], info[4]+1};
    			}else {
    				return new int[] {oResult+1, info[1], oResult, info[3], info[4]+1};
    			}
    		}
    		else {
    			return new int[] {oResult, info[1], tResult, info[3], info[4]+1};
    		}
    	}
    }
    
    public static int getPosition(int row, int col, int dir) { // 왼,오,아래,위
    	int num=0;
    	if(dir==0) {
    		for (int i = col; i >= 0; i--) {
				if(arr[row][i]==2) {
					return -1;
				}
				else if(arr[row][i]==1) {
					return i+1;
				}
			}
    	}
    	else if(dir==1) {
    		for (int i = col; i < M; i++) {
				if(arr[row][i]==2) {
					return -1;
				}
				else if(arr[row][i]==1) {
					return i-1;
				}
			}
    	}
    	else if(dir==2) {
    		for (int i = row; i < N; i++) {
				if(arr[i][col]==2) {
					return -1;
				}
				else if(arr[i][col]==1) {
					return i-1;
				}
			}
    	}
    	else {
    		for (int i = row; i >= 0; i--) {
				if(arr[i][col]==2) {
					return -1;
				}
				else if(arr[i][col]==1) {
					return i+1;
				}
			}
    	}
    	
    	return num;
    }
    
}
