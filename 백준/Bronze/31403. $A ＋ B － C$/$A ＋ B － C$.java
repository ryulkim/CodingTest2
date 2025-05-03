import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static String A,B;
	static int C;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	
    	init();
    	
    	proc();
        
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	A=br.readLine();
    	B=br.readLine();
    	C=Integer.parseInt(br.readLine());
    }
    
    public static void proc() {
    	System.out.println(Integer.parseInt(A)+Integer.parseInt(B)-C);
    	System.out.println(Integer.parseInt(A+B)-C);
    }
    
   
}