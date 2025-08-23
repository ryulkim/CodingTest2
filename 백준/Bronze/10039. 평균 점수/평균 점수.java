import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
    	init();
//    	proc();
    }

    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st=new StringTokenizer(br.readLine());
        int sum=0;
    	
        for (int i = 0; i < 5; i++) {
			int x=Integer.parseInt(br.readLine());
			if(x<40) {
				sum+=40;
			}
			else sum+=x;
		}
        
        System.out.println(sum/5);
        
    }
    
    public static void proc() {
    	
    }
    
}
