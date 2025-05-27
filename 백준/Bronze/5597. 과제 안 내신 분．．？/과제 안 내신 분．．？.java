import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static boolean[] chk;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	chk=new boolean[31];
    	
    	for (int i = 0; i < 28; i++) {
			int x=Integer.parseInt(br.readLine());
			chk[x]=true;
		}
    	
    	for (int i = 1; i <= 30; i++) {
			if(!chk[i]) {
				System.out.println(i);
			}
		}
    	
    }
    
    
    
}