import java.io.*;
import java.util.*;

public class Main {

	static String s;
	
    public static void main(String[] args) throws Exception {
    	init();
    }
        
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
//    	StringTokenizer st=new StringTokenizer(br.readLine());
    	s=br.readLine();
    	int len=s.length();
    	char c=s.charAt(0);
    	int[] cnt=new int[2];
    	cnt[c-'0']++;
    	
    	for (int i = 1; i < len; i++) {
    		char temp=s.charAt(i);
			if(c!=temp) {
				cnt[temp-'0']++;
				c=temp;
			}
		}
    	
    	System.out.println(Math.min(cnt[0], cnt[1]));
    }
    
    
    public static void proc() {
    	
    }
    
}
