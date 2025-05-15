import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int N;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	int num=666;
    	int cnt=0;
    	
    	while(true) {
    		if(String.valueOf(num).contains("666")) {
    			cnt++;
    			if(cnt==N) {
    				System.out.println(num);
    				break;
    			}
    		}
    		
    		num++;
    	}
    	
    	
    }

}