import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int H,W,N,M;
	static int[][] arr;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    }

	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	H=Integer.parseInt(st.nextToken());
    	W=Integer.parseInt(st.nextToken());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
//    	arr=new int[H][W]; 
    	
    	int a=H/(N+1);
    	a+=H%(N+1)>0?1:0;
    	int b=W/(M+1);
    	b+=W%(M+1)>0?1:0;
    	
    	System.out.println(a*b);
    }
	
	
    public static void proc() {
    	
    	
    }
}