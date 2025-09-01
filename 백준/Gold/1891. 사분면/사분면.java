import java.io.*;
import java.util.*;

public class Main {

	static long d, x, y, len, r, c, size;
	static String num, ans="-1";
	
    public static void main(String[] args) throws Exception {
    	init();
    	proc(0,0,size,0);
    	if(valid(r-y, c+x)) {
    		find(0,0,size,0,new StringBuilder());    		
    	}
    	System.out.println(ans);
    }
    
    public static boolean valid(long i, long j) {
    	return i>=0&&i<size&&j>=0&&j<size;
    }

    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	StringBuilder sb=new StringBuilder();
    	d=Long.parseLong(st.nextToken());
    	num=st.nextToken();
    	st=new StringTokenizer(br.readLine());
    	x=Long.parseLong(st.nextToken());
    	y=Long.parseLong(st.nextToken());
    	size=(long) Math.pow(2, d);
    }
    
    public static void proc(long u, long l, long sz, int idx) {
    	if(sz==1) {
    		r=u;
    		c=l;
    		return;
    	}
    	
    	if(num.charAt(idx)=='2') {
    		proc(u, l, sz/2, idx+1);
    	}
    	else if(num.charAt(idx)=='3') {
    		proc(u+sz/2, l, sz/2, idx+1);
    	}
    	else if(num.charAt(idx)=='1') proc(u, l+sz/2, sz/2, idx+1);
    	else proc(u+sz/2, l+sz/2, sz/2, idx+1);
    }
   
    public static void find(long u, long l, long sz, int idx, StringBuilder sb) {
    	if(sz==1) {
    		ans=sb.toString();
    		return;
    	}
    	if(u+sz/2>r-y) {
    		if(l+sz/2>c+x) {
    			find(u, l, sz/2, idx+1, sb.append(2));
    		}
    		else find(u, l+sz/2, sz/2, idx+1, sb.append(1));
    	}
    	else {
    		if(l+sz/2>c+x) {    			
    			find(u+sz/2, l, sz/2, idx+1, sb.append(3));
    		}
    		else find(u+sz/2, l+sz/2, sz/2, idx+1, sb.append(4));
    	}
    }
   
}
