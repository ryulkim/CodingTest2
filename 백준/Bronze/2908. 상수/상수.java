import java.io.*;
import java.util.*;

public class Main {
	
	static int A, B;

    public static void main(String[] args) throws IOException {
    	init();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	A=Integer.parseInt(st.nextToken());
    	B=Integer.parseInt(st.nextToken());
    	
    	int a=proc(A);
    	int b=proc(B);
    	
    	if(a>b) {
    		System.out.println(a);
    	}
    	else {
    		System.out.println(b);
    	}
    }
    
    public static int proc(int num) {
    	int value=0;
    	while(num>0) {
    		value*=10;
    		value+=num%10;
    		num/=10;
    	}
    	return value;
    }
    
}