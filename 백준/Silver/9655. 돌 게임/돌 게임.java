import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	
	static int N, oIdx, tIdx;
	static ArrayDeque<String> f,l;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
//    	proc();
    }

	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	if(N%2==0) {
    		System.out.println("CY");
    	}
    	else {
    		System.out.println("SK");
    	}
    }
	
	
    public static void proc() {
    	

    }
    
 
}