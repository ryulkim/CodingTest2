import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M, K, ans_x;
	static long ans;
	static ArrayList<int[]>[] graph;
	static long[] dp;
	static int[] dr= {0,0,1,-1};
	static int[] dc= {1,-1,0,0};
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
//    	dij();
//    	chk();
//    	System.out.println();
//    	System.out.println(num);
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int num=0;
    	
    	for (int i = 0; i < 3; i++) {
			String s=br.readLine();
			
			if(num!=0) {
				num++;
				continue;
			}
			
			if(s.equals("Fizz")) {
				
			}
			else if(s.equals("Buzz")) {
				
			}
			else if(s.equals("FizzBuzz")) {
				
			}
			else {
				num=Integer.parseInt(s);
			}
		}
    	
    	num++;
    	
    	if(num%15==0) {
    		System.out.println("FizzBuzz");
    	}
    	else if(num%3==0) {
    		System.out.println("Fizz");
    	}
    	else if(num%5==0) {
    		System.out.println("Buzz");
    	}
    	else {
    		System.out.println(num);
    	}
    }

}