import java.io.*;
import java.util.*;

public class Main {
	
	static int a, b, p, q, a1, b1, p1, q1;
	
    public static void main(String[] args) throws IOException {
    	init();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
    	for (int i = 0; i < 4; i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		a=Integer.parseInt(st.nextToken());
    		b=Integer.parseInt(st.nextToken());
    		p=Integer.parseInt(st.nextToken());
    		q=Integer.parseInt(st.nextToken());
    		
    		a1=Integer.parseInt(st.nextToken());
    		b1=Integer.parseInt(st.nextToken());
    		p1=Integer.parseInt(st.nextToken());
    		q1=Integer.parseInt(st.nextToken());
    		
    		int dx=Math.min(p, p1)-Math.max(a, a1);
    		int dy=Math.min(q, q1)-Math.max(b, b1);
    		
    		if(dx<0||dy<0) {
    			System.out.println('d');
    		}
    		else if(dx==0&&dy==0) {
    			System.out.println('c');
    		}
    		else if(dx==0||dy==0) {
    			System.out.println('b');
    		}
    		else {
    			System.out.println('a');
    		}
		}
    }
    
}