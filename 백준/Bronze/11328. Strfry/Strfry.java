import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] arr;
	static HashMap<Character, Integer> hm;
	
    public static void main(String[] args) throws IOException {
    	init();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	hm=new HashMap<>();
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		String a=st.nextToken();
    		String b=st.nextToken();
    		hm.clear();
    		System.out.println(valid(a,b)?"Possible":"Impossible");
		}
    }
    
    public static boolean valid(String a, String b) {
    	for (int j = 0; j < a.length(); j++) {
			char c=a.charAt(j);
			hm.put(c, hm.getOrDefault(c, 0)+1);
		}
		
		for (int j = 0; j < b.length(); j++) {
			char c=b.charAt(j);
			if(!hm.containsKey(c)) return false;
			int value=hm.getOrDefault(c, 0);
			if(value<=0) return false;
			if(value==1) {
				hm.remove(c);
			}
			else {				
				hm.put(c, value-1);
			}
		}
		
		if(hm.size()>0) {
			return false;
		}
		
		return true;
    }
  
}