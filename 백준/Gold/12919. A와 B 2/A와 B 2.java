import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {

	static String origin;
	static int ans=0;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	System.out.println(ans);
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	origin=br.readLine();
    	String t=br.readLine();
    	proc(t);
    }
    
    public static void proc(String target) {
    	if(target.equals(origin)) {
    		ans=1;
    		return;
    	}
    	if(target.length()<=origin.length()) return;
    	int len=target.length();
    	if(target.charAt(len-1)=='A') {
    		proc(target.substring(0, len-1));
    	}
    	if(target.charAt(0)=='B') {
    		proc(new StringBuilder(target.substring(1, len)).reverse().toString());
    	}
//    	if(target.charAt(len-1)=='B') {
//    		proc(new StringBuilder(target.substring(0, len-1)).reverse().toString());
//    	}
    }
}