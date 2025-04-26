import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// A G C T A T

public class Main {
    
	static String s;
	static int[][] dp;
	static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
        
//    	proc();
    	
//    	chk();
        
//        System.out.println(dp[0][N-1]);
        
    }
    
    public static void proc() {

    }
    
    public static void init() throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s;
        
        while((s=br.readLine())!=null) {
        	StringTokenizer st=new StringTokenizer(s);
        	int a=Integer.parseInt(st.nextToken());
        	int b=Integer.parseInt(st.nextToken());
        	
        	System.out.println(a+b);
        }
    }
}