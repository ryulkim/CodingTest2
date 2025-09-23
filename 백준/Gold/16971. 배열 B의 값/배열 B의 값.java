import java.io.*;
import java.util.*;

public class Main {

	static int N, M, ans=-1000_000_000, init=0;
	static int[][] arr;
	static int[] rI, cI, rO, cO;
	
    public static void main(String[] args) throws Exception {
    	init();
    	calculateSum();
    	initB();
    	proc();
    	
    	System.out.println(ans);
    }
        
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	arr=new int[N+1][M+1];
    	rI=new int[N];
    	rO=new int[N];
    	cI=new int[M];
    	cO=new int[M];
    	
    	for (int i = 0; i < N; i++) {
    		st=new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    }
    
    public static void calculateSum() {
    	for (int i = 0; i < N; i++) {
			rO[i]=arr[i][0]+arr[i][M-1];
			
			for (int j = 1; j < M-1; j++) {
				rI[i]+=arr[i][j];
			}
		}
    	
    	for (int i = 0; i < M; i++) {
    		cO[i]=arr[0][i]+arr[N-1][i];
    		
			for (int j = 1; j < N-1; j++) {
				cI[i]+=arr[j][i];
			}
		}
    }
    
    public static void initB() {
    	init+=rO[0];
    	init+=rI[0]*2;
    	init+=rO[N-1];
    	init+=rI[N-1]*2;
    	
    	for (int i = 1; i < N-1; i++) {
			init+=rO[i]*2;
			init+=rI[i]*4;
		}
    }
    
    public static void proc() {
    	ans=init;
    	
    	for (int i = 1; i < N-1; i++) {
			int value=init-(rO[0]+rI[0]*2+rO[i]*2+rI[i]*4)+(rO[i]+rI[i]*2+rO[0]*2+rI[0]*4);
			ans=Math.max(ans, value);
		}
    	
    	for (int i = 1; i < N-1; i++) {
			int value=init-(rO[N-1]+rI[N-1]*2+rO[i]*2+rI[i]*4)+(rO[i]+rI[i]*2+rO[N-1]*2+rI[N-1]*4);
			ans=Math.max(ans, value);
		}
    	
    	for (int i = 1; i < M-1; i++) {
			int value=init-(cO[M-1]+cI[M-1]*2+cO[i]*2+cI[i]*4)+(cO[i]+cI[i]*2+cO[M-1]*2+cI[M-1]*4);
			ans=Math.max(ans, value);
		}
    	
    	for (int i = 1; i < M-1; i++) {
			int value=init-(cO[0]+cI[0]*2+cO[i]*2+cI[i]*4)+(cO[i]+cI[i]*2+cO[0]*2+cI[0]*4);
			ans=Math.max(ans, value);
		}
    }
    
}
