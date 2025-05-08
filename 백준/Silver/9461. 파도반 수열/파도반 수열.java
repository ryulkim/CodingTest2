import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


/*
 * 모든 경우의 수 - 1
 * 
 */

public class Main {
	
	static int T, N;
	static long arr[];

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	T=Integer.parseInt(br.readLine());
    	arr=new long[101];
    	
    	proc();
    	
    	for (int i = 0; i < T; i++) {
			System.out.println(arr[Integer.parseInt(br.readLine())]);
		}

    	
    }
    
    public static void proc() {
    	arr[1]=1;
    	arr[2]=1;
    	arr[3]=1;
    	arr[4]=2;
    	arr[5]=2;
    	arr[6]=3;
    	arr[7]=4;
 
    	for (int i = 8; i <= 100; i++) {
			arr[i]=arr[i-1]+arr[i-5];
		}
    }
    
    

    
    
   
}