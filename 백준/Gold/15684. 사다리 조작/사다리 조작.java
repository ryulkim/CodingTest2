import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {

	static int N, M, H, ans=-1;
	static boolean[][] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
//    	print();
    	proc();
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
    
    public static void proc() {
    	for (int i = 0; i <= 3; i++) {
			combi(0,i,1,1);
			if(ans!=-1) break;
		}
    }
    
    public static void combi(int depth, int num, int startH, int startN) {
    	if(depth==num) {
    		if(simul()) {
//    			System.out.println(num);
//    			print();
    			ans=num;
    		}
    		return;
    	}
    	
//    	System.out.println("@@@");

    	for (int i = startH; i <= H; i++) {
			for (int j = startN; j < N; j++) {
				
				if(arr[i][j]) continue;
				if(arr[i][j+1]) continue;
				if(j>1&&arr[i][j-1]) continue;
				
				arr[i][j]=true;
				combi(depth+1, num, i, j+1);
				arr[i][j]=false;
			}
			startN=1;
		}
    }
    
    public static boolean simul() {
    	for (int i = 1; i <= N; i++) {
			int curN=i;
			int curH=1;
			
			while(curH<=H) {
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