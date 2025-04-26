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
//    	init();
        
    	proc();
    	
//    	chk();
        
//        System.out.println(dp[0][N-1]);
        
    }
    
    public static void proc() {
    	System.out.println("         ,r'\"7\n"
    			+ "r`-_   ,'  ,/\n"
    			+ " \\. \". L_r'\n"
    			+ "   `~\\/\n"
    			+ "      |\n"
    			+ "      |");
    }
    
    public static void init() throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb=new StringBuilder();
        
        while(true) {
            StringTokenizer st=new StringTokenizer(br.readLine());
        	int a=Integer.parseInt(st.nextToken());
        	int b=Integer.parseInt(st.nextToken());
        	
        	if(a==0&&b==0) break;
        	
        	sb.append(a+b);
        	sb.append("\n");
        }
        
        System.out.println(sb);
    }
}