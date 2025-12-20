import java.io.*;
import java.util.*;

public class Main {
	
	static int N, ans=0;
	
    public static void main(String[] args) throws IOException {
    	init();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	
    	while(true) {
    		N=Integer.parseInt(br.readLine());
    		ans=0;
    		
    		if(N==0) break;
    		
    		ans++;
    		while(N>0) {
    			int remain=N%10;
    			N/=10;
    			proc(remain);
    			ans++;
    		}
    		sb.append(ans).append('\n');
    	}
    	
    	System.out.println(sb);
    }
    
    public static void proc(int num) {
    	if(num==1) {
			ans+=2;
		}
		else if(num==0) {
			ans+=4;
		}
		else{
			ans+=3;
		}
    }
    
}