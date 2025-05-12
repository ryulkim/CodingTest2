import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static int L;
	static String s;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
//    	proc();
//    	System.out.println(ans);
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	L=Integer.parseInt(br.readLine());
    	s=br.readLine();
    	int sum=0;
    	
    	for (int i = L-1; i > 0; i--) {
			int value=s.charAt(i)-'a'+1;
			sum+=value;
			sum*=31;
			sum%=1234567891;
		}
    	
    	sum+=s.charAt(0)-'a'+1;
    	sum%=1234567891;
    	
    	System.out.println(sum);
    }
    
    public static void proc() {
    	
    }
}