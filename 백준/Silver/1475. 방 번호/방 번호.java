import java.io.*;
import java.util.*;

public class Main {
	
	static int T, N, M;
	static String s;
	static int[] chk;
	
    public static void main(String[] args) throws IOException {
    	init();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	s=br.readLine();
    	N=s.length();
    	int set=0;
    	chk=new int[10];
    	
    	for (int i = 0; i < N; i++) {
    		int num=s.charAt(i)-'0';
    		chk[num]++;
		}
    	
    	for (int i = 0; i <= 9; i++) {
    		if(i==6) continue;
    		if(i==9) {
    			int sum=chk[6]+chk[9];
    			if(sum%2==0) {
    				set=Math.max(set, sum/2);
    			}
    			else {
    				set=Math.max(set, sum/2+1);
    			}
    		}
    		else {
    			set=Math.max(set, chk[i]);
    		}
		}
    	
    	System.out.println(set);
    }
    
}