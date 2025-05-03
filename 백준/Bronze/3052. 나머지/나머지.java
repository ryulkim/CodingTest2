import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	
	static int x;
	static HashSet<Integer> hs;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	
    	init();
    	
    	proc();
        
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	hs=new HashSet<Integer>();
    	
    	for (int i = 0; i < 10; i++) {
			x=Integer.parseInt(br.readLine());
			hs.add(x%42);
		}
    }
    
    public static void proc() {
    	System.out.println(hs.size());
    }
    
   
}