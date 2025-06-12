import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {

	static int N, M, H, ans=4;
	static boolean[][] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
//    	print();
    	proc(0,1,1);
    	System.out.println(ans==4?-1:ans);
    }
    
    public static void print() {
    	for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
    	System.out.println("-----------------");
    }

	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	H=Integer.parseInt(st.nextToken());
    	arr=new boolean[H+1][N+1];
    	
    	for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			arr[a][b]=true;
		}
    }
    
    public static void proc(int depth, int startH, int startN) {
    	if(depth>3) return;
//    	print();
    	
    	if(simul()) {
    		ans=Math.min(ans, depth);
//    		System.out.println("@@@@@@@@@@@@@@@@@@@@");
//    		return; 
    	}
    	for (int i = startH; i <= H; i++) {
			for (int j = startN; j < N; j++) {
//				System.out.println(i+" "+j);
				
				if(arr[i][j]) continue;
				if(arr[i][j+1]) continue;
				if(j>1&&arr[i][j-1]) continue;
				
//				System.out.println("++ "+i+" "+j);
				
				arr[i][j]=true;
				proc(depth+1, i, j+1);
				arr[i][j]=false;
//				System.out.println("-- "+i+" "+j);
			}
			startN=1;
		}
    }
    
    public static boolean simul() {
    	for (int i = 1; i <= N; i++) {
			int curN=i;
			int curH=1;
			
			while(curH<=H) {
//				System.out.println(curN+" "+curH+" "+H);
				if(arr[curH][curN]) {
					curN++;
					curH++;
				}
				else if(curN>1&&arr[curH][curN-1]) {
					curN--;
					curH++;
				}
				else curH++;
			}
			
			if(curN!=i) return false;
		}
    	
    	return true;
    }
}