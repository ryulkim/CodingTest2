import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static long A, B, C;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	A=Long.parseLong(st.nextToken());
    	B=Long.parseLong(st.nextToken());
    	C=Long.parseLong(st.nextToken());
    	
    	System.out.println(A+B+C);
    }
    
    
    
}