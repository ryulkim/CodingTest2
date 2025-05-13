import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int N, K;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	K=Integer.parseInt(st.nextToken());
    	
    	System.out.println(binary(N, N-K+1)/binary(K, 1));
    }
    
    public static int binary(int b, int a) {
    	int value=1;
    	for (int i = a; i <= b; i++) {
			value*=i;
		}
    	return value;
    }
    
    
}