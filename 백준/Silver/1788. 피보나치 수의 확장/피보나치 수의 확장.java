import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] arr, dp;

    public static void main(String[] args) throws IOException {
    	init();
    	proc();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	
    }
    
    public static void proc() {
    	if(N==0) {
    		System.out.println(0);
    		System.out.println(0);
    	}
    	else if(N==1) {
    		System.out.println(1);
    		System.out.println(1);
    	}
    	else if(N>0) {
    		int num=plus();
    		System.out.println(1);
    		System.out.println(num);
    	}
    	else {
    		int num=minus();
    		if(num==0) {
    			System.out.println(0);
    			System.out.println(0);
    		}
    		else if(num<0) {
    			System.out.println(-1);;
    			System.out.println(-num);
    		}
    		else {
    			System.out.println(1);
    			System.out.println(num);
    		}
    	}
    }
    
    public static int plus() {
    	long f=0, s=1;
    	int idx=2;
    	long value=f+s;
    	
    	while(idx++<N) {
    		f=s;
    		s=value;
    		value=(s+f)%1000_000_000;
    	}
    	
    	return (int) value;
    }
    
    public static int minus() {
    	long f=0, s=1;
    	int idx=-1;
    	long value=s-f;
    	
    	while(idx-->N) {
    		s=f;
    		f=value;
    		if((s-f)<0) {
    			value=-(s-f);
    			value%=1000_000_000;
    			value*=-1;
    		}
    		else {
    			value=s-f;
    			value%=1000_000_000;
    		}
    	}
    	
    	return (int) value;
    }
    
    
}