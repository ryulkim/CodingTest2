import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int N;
	static char[][] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc(0,N-1,N);
    	print();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	arr=new char[N][2*N];
    	
    	for (int i = 0; i < N; i++) {
    		Arrays.fill(arr[i], ' ');
		}
    }
    
    
    public static void proc(int r, int c, int size) {
    	if(size==3) {
    		arr[r][c]='*';
    		arr[r+1][c-1]='*';
    		arr[r+1][c+1]='*';
    		arr[r+2][c-2]='*';
    		arr[r+2][c-1]='*';
    		arr[r+2][c]='*';
    		arr[r+2][c+1]='*';
    		arr[r+2][c+2]='*';
    		return;
    	}
    	proc(r,c,size/2);
    	proc(r+size/2,c-size/2,size/2);
    	proc(r+size/2,c+size/2,size/2);
    }
    
    public static void print() {
    	StringBuilder sb=new StringBuilder();
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2*N-1; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
    	
    	System.out.println(sb);
    }
}