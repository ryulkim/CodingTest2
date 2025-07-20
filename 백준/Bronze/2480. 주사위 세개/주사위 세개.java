import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	static int N;
	static int[] arr;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    }
    
	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	int a=Integer.parseInt(st.nextToken());
    	int b=Integer.parseInt(st.nextToken());
    	int c=Integer.parseInt(st.nextToken());
    	
    	if(a==b&&b==c) {
    		System.out.println(10000+a*1000);
    	}
    	else if(a==b) {
    		System.out.println(1000+a*100);
    	}
    	else if(b==c) {
    		System.out.println(1000+b*100);
    	}
    	else if(a==c) {
    		System.out.println(1000+a*100);
    	}
    	else {
    		int max=Math.max(a, b);
    		max=Math.max(max, c);
    		System.out.println(max*100);
    	}
	}
	
	public static int proc() {
		int ans=0;
		
		return ans;
	}
	
}
