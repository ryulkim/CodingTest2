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
    	
    	while(true) {
    		String s=br.readLine();
    		if(s.equals("#")) break;
    		System.out.println(proc(s));
    	}
    	
    }
    

    public static int proc(String s) {
    	int sz=s.length();
    	int ans=0;
    	
    	for (int i = 0; i < sz; i++) {
			if(chk(s.charAt(i))) {
				ans++;
			}
		}
    	
    	return ans;
    }
   
    public static boolean chk(char c) {
    	return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
    }
}
