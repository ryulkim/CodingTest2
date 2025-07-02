import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	static int N, X;
	static int[] arr, sum;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	String s=br.readLine();
    	int sz=s.length();
    	int num=1;
    	
    	for (int i = 0; i < sz; ) {
    		String convert = Integer.toString(num);
    		
    		for (int j = 0; j < convert.length() && i < sz; j++) {
    			if(s.charAt(i)==convert.charAt(j)) {
    				i++;
    			}
			}
    		
    		num++;
    	}    	
    	
    	System.out.println(num-1);
    }
    
}