import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static int A, B, C;
	static HashMap<String, Integer> hm;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
        
    	proc();
    	
    	StringBuilder sb=new StringBuilder();
    	
    	for (int i = 0; i <= 9; i++) {
			String num=Integer.toString(i);
			
			sb.append(hm.getOrDefault(num, 0)+"\n");
		}
    	
        
        System.out.println(sb);
        
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
    	A=Integer.parseInt(br.readLine());
    	B=Integer.parseInt(br.readLine());
    	C=Integer.parseInt(br.readLine());
    	
    	hm=new HashMap<String, Integer>();
    	
    }
    
    public static void proc() {
    	int value=A*B*C;
    	String seq=Integer.toString(value);
    	
    	for(int i=0;i<seq.length();i++) {
    		hm.put(String.valueOf(seq.charAt(i)), hm.getOrDefault(String.valueOf(seq.charAt(i)), 0)+1);
    	}
    }
    
    
}