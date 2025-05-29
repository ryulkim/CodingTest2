
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	
    public static void main(String[] args) throws IOException {
    	init();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	String s=br.readLine();
    	int len=s.length();
    	StringBuilder sb=new StringBuilder();
    	
//    	System.out.println('a'-'A');
    	
    	for (int i = 0; i < len; i++) {
			if(s.charAt(i)>='a') {
				sb.append(String.valueOf((char)(s.charAt(i)-32)));
			}
			else {
				sb.append(String.valueOf((char)(s.charAt(i)+32)));
			}
		}
    	
    	System.out.println(sb);
    }
    

    
   
}
