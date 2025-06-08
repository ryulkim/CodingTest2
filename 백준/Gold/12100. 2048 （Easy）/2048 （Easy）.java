import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static int[][] arr;
	static int N, max=0;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc(arr,0);
//    	int[][] ans=down(arr);
//    	chk(ans);
    	System.out.println(max);
    }
    
    public static void chk(int[][] arr) {
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("---------------");
    }
    
    public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N][N];
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    }
    
    public static void proc(int[][] temp, int depth) {
    	if(depth==5) {
    		//가장 큰 블록 구하기
    		for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					max=Math.max(max, temp[i][j]);
				}
			}
    		
//    		chk(temp);
    		
    		return;
    	}
    	
    	//위, 아래, 왼, 오 이동 경우 구하기
    	proc(up(temp),depth+1);
    	proc(down(temp),depth+1);
    	proc(left(temp),depth+1);
    	proc(right(temp),depth+1);
    }
    
    public static int[][] up(int[][] arr) {
    	ArrayDeque<Integer>[] q=new ArrayDeque[N];
    	int[][] temp=new int[N][N];
    	    	
    	for (int i = 0; i < N; i++) {
    		q[i]=new ArrayDeque<Integer>();
		}
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[j][i]!=0) q[i].add(arr[j][i]);
			}
		}
    	
//    	for (int i = 0; i < N; i++) {
//    		if(q[i].isEmpty()) continue;
//    		temp[0][i]=q[i].poll();
//    	}
    	
    	for (int i = 0; i < N; i++) {
    		int j=0;
    		int value=0;
    		while(!q[i].isEmpty()) {
    			int num=q[i].poll();
    			if(value==0) {
    				value=num;
    			}
    			else if(value==num) {
    				temp[j++][i]=2*num;
    				value=0;
    			}
    			else {
    				temp[j++][i]=value;
    				value=num;
    			}
    		}
    		
    		if(value!=0) {
    			temp[j][i]=value;
    		}
		}
    	
    	return temp;
    }
    
    public static int[][] down(int[][] arr) {
    	ArrayDeque<Integer>[] q=new ArrayDeque[N];
    	int[][] temp=new int[N][N];
    	    	
    	for (int i = 0; i < N; i++) {
    		q[i]=new ArrayDeque<Integer>();
		}
    	
    	for (int i = 0; i < N; i++) {
			for (int j = N-1; j >= 0; j--) {
				if(arr[j][i]!=0) q[i].add(arr[j][i]);
			}
		}
    	
//    	for (int i = 0; i < N; i++) {
//    		if(q[i].isEmpty()) continue;
//    		temp[N-1][i]=q[i].poll();
//    	}
    	
    	for (int i = 0; i < N; i++) {
    		int j=N-1;
    		int value=0;
    		while(!q[i].isEmpty()) {
    			int num=q[i].poll();
    			if(value==0) {
    				value=num;
    			}
    			else if(value==num) {
    				temp[j--][i]=2*num;
    				value=0;
    			}
    			else {
    				temp[j--][i]=value;
    				value=num;
    			}
    		}
    		
    		if(value!=0) {
    			temp[j][i]=value;
    		}
		}
    	
    	return temp;
    }
    
    public static int[][] left(int[][] arr) {
    	ArrayDeque<Integer>[] q=new ArrayDeque[N];
    	int[][] temp=new int[N][N];
    	    	
    	for (int i = 0; i < N; i++) {
    		q[i]=new ArrayDeque<Integer>();
		}
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j]!=0) q[i].add(arr[i][j]);
			}
		}
    	
//    	for (int i = 0; i < N; i++) {
//    		if(q[i].isEmpty()) continue;
//    		temp[i][0]=q[i].poll();
//    	}
    	
    	for (int i = 0; i < N; i++) {
    		int j=0;
    		int value=0;
    		while(!q[i].isEmpty()) {
    			int num=q[i].poll();
    			if(value==0) {
    				value=num;
    			}
    			else if(value==num) {
    				temp[i][j++]=2*num;
    				value=0;
    			}
    			else {
    				temp[i][j++]=value;
    				value=num;
    				
    			}
    		}
    		
    		if(value!=0) {
    			temp[i][j]=value;
    		}
		}
    	
    	
    	
    	return temp;
    }
    
    public static int[][] right(int[][] arr) {
    	ArrayDeque<Integer>[] q=new ArrayDeque[N];
    	int[][] temp=new int[N][N];
    	    	
    	for (int i = 0; i < N; i++) {
    		q[i]=new ArrayDeque<Integer>();
		}
    	
    	for (int i = 0; i < N; i++) {
			for (int j = N-1; j >= 0; j--) {
				if(arr[i][j]!=0) q[i].add(arr[i][j]);
			}
		}
    	
//    	for (int i = 0; i < N; i++) {
//    		if(q[i].isEmpty()) continue;
//    		temp[i][N-1]=q[i].poll();
//    	}
    	
    	for (int i = 0; i < N; i++) {
    		int j=N-1;
    		int value=0;
    		while(!q[i].isEmpty()) {
    			int num=q[i].poll();
    			if(value==0) {
    				value=num;
    			}
    			else if(value==num) {
    				temp[i][j--]=2*num;
    				value=0;
    			}
    			else {
    				temp[i][j--]=value;
    				value=num;
    				
    			}
    		}
    		
    		if(value!=0) {
    			temp[i][j]=value;
    		}
		}
    	
    	return temp;
    }
}