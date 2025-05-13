import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M;
	static HashMap<Integer, Integer> hm;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	hm=new HashMap<Integer, Integer>();
    	StringBuilder sb=new StringBuilder();
    	
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		int x=Integer.parseInt(st.nextToken());
    		hm.put(x, hm.getOrDefault(x, 0)+1);
		}
    	
    	M=Integer.parseInt(br.readLine());
    	st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < M; i++) {
    		int x=Integer.parseInt(st.nextToken());
    		sb.append(hm.getOrDefault(x,0)+" ");
		}
    	System.out.println(sb);
    }
    
    
}