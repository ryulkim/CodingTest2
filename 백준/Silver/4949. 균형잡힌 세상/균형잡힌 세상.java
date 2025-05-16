import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	
	static Stack<String> st;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	
//    	chk();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
    	while(true) {
    		String s=br.readLine();
    		st=new Stack<String>();
    		
    		if(s.equals(".")) break;
    		
    		String ans=proc(s)?"yes":"no";
        	System.out.println(ans);
    	}
    }
    
    public static boolean proc(String s) {
    	int sz=s.length();
    	
    	for (int i = 0; i < sz; i++) {
			if(s.charAt(i)=='('||s.charAt(i)=='[') {
				st.add(String.valueOf(s.charAt(i)));
			}
			else if(s.charAt(i)==')') {
				if(st.isEmpty()) return false;
				if(!st.peek().equals("(")) {
					return false;
				}
				st.pop();
			}
			else if(s.charAt(i)==']') {
				if(st.isEmpty()) return false;
				if(!st.peek().equals("[")) {
					return false;
				}
				st.pop();
			}
		}
    	
    	if(!st.isEmpty()) return false;
    	
    	return true;
    }

}