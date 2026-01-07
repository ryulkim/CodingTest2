import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, T, x1, y1, r1, x2, y2, r2;
	
    public static void main(String[] args) throws IOException {
    	init();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	N=Integer.parseInt(br.readLine());
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		x1=Integer.parseInt(st.nextToken());
    		y1=Integer.parseInt(st.nextToken());
    		r1=Integer.parseInt(st.nextToken());
    		x2=Integer.parseInt(st.nextToken());
    		y2=Integer.parseInt(st.nextToken());
    		r2=Integer.parseInt(st.nextToken());
    		
    		System.out.println(proc(x1, y1, r1, x2, y2, r2));
		}
    	
    	
    }
    
    public static int proc(int x1, int y1, int r1, int x2, int y2, int r2) {
    	int distance=(x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
    	int sum=(r2+r1)*(r2+r1);
    	int cha=(r2-r1)*(r2-r1);
    	if(x1==x2&&y1==y2&&r1==r2) {
    		return -1;
    	}
    	else if(distance==sum||distance==cha) { // 1개 맞닿을 때
    		return 1;
    	}
    	else if(distance>sum||distance<cha) { // 0개 맞닿을 때
    		return 0;
    	}
    	else { // 2개 맞닿았을 때
    		return 2;
    	}
    }
    
    
    
    

}