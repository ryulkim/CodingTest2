import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int T;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
//    	proc();
    }

	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	T=Integer.parseInt(br.readLine());
    	for (int i = 0; i < T; i++) {
			String s=br.readLine();
			System.out.println(s.charAt(0)+""+s.charAt(s.length()-1));
		}
    }
    
    public static void proc() {
    
    }
}