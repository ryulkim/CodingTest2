import java.io.*;
import java.util.*;

public class Main {
	
	static int N, num, ansR, ansC;
	static int[][] arr;
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	
    public static void main(String[] args) throws IOException {
    	init();
    	proc(N/2,N/2);
    	print();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	num=Integer.parseInt(br.readLine());
    	arr=new int[N][N];
    }
    
    public static void proc(int r, int c) {
    	int start=1;
    	int dir=-1;
    	
    	while(true) {
    		if(start==num) {
    			ansR=r;
    			ansC=c;
    		}
    		
    		arr[r][c]=start++;
    		dir=(dir+1)%4;
    		
    		int nr=r+dr[dir];
    		int nc=c+dc[dir];
    		if(!valid(nr, nc)) {
    			dir=(dir+3)%4;    			
    		}
    		
    		nr=r+dr[dir];
    		nc=c+dc[dir];
    		
    		if(!valid(nr,nc)) break;
    		
    		r=nr;
    		c=nc;
    	}
    }
    
    public static void print() {
    	StringBuilder sb=new StringBuilder();
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
    	
    	sb.append(ansR+1).append(" ").append(ansC+1);
    	System.out.println(sb);
    }
    
    public static boolean valid(int i, int j) {
    	return i>=0&&i<N&&j>=0&&j<N&&arr[i][j]==0;
    }
  
}