import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int A, B;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	int num=gcd(A,B);
    	System.out.println(num);
    	System.out.println(lcm(num));
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	A=Integer.parseInt(st.nextToken());
    	B=Integer.parseInt(st.nextToken());
    }
    
    public static int gcd(int a, int b) {
    	while(b!=0) {
    		int temp=a%b;
    		a=b;
    		b=temp;
    	}
    	return a;
    }
    
    public static int lcm(int num) {
    	return A*B/num;
    }
}