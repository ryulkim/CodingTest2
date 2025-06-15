import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	static long N, M;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    }

	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Long.parseLong(st.nextToken());
    	M=Long.parseLong(st.nextToken());
    }
    
    public static void proc() {
    	System.out.println(Math.abs(N-M));
    }
}