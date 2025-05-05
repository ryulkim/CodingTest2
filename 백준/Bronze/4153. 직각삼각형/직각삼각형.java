import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();

    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
    	while(true) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		long a=Long.parseLong(st.nextToken());
    		long b=Long.parseLong(st.nextToken());
    		long c=Long.parseLong(st.nextToken());
    		
    		ArrayList<Long> arr=new ArrayList<Long>();
    		arr.add(a);
    		arr.add(b);
    		arr.add(c);
    		Collections.sort(arr);
    		
    		if(a==0&b==0&&c==0) {
    			break;
    		}
    		
    		proc(arr);
    	}
    	
    	
    	
    }
    
    public static void proc(ArrayList<Long> arr) {
    	long a=arr.get(0);
    	long b=arr.get(1);
    	long c=arr.get(2);
    	
    	if(a*a+b*b==c*c) {
    		System.out.println("right");
    	}
    	else {
    		System.out.println("wrong");
    	}
    }
    
    
    
   
}