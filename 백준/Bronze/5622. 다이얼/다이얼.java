import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	
    public static void main(String[] args) throws IOException {
    	init();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	String s=br.readLine();
    	int ans=0;
    	
    	for (int i = 0; i < s.length(); i++) {
    		char c=s.charAt(i);
    		if(c>='A') {
    			ans+=3;
    		}
    		if(c>='D') {
    			ans++;
    		}
    		if(c>='G') {
    			ans++;
    		}
    		if(c>='J') {
    			ans++;
    		}
    		if(c>='M') {
    			ans++;
    		}
    		if(c>='P') {
    			ans++;
    		}
    		if(c>='T') {
    			ans++;
    		}
    		if(c>='W') {
    			ans++;
    		}
		}
    	
    	System.out.println(ans);
    	
    }
    
}