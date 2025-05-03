import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	HashSet<Integer> hs=new HashSet<Integer>();
    	
    	for (int i = 0; i < 10; i++) {
			int x=Integer.parseInt(br.readLine());
			hs.add(x%42);
		}
    	
    	System.out.println(hs.size());
    }
    
   
}