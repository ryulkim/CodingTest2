import java.io.*;
import java.util.*;

public class Main {

	static String s;
	static ArrayDeque<Integer> stack;

    public static void main(String[] args) throws Exception {
    	init();
    	System.out.println(proc());
    }

    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st=new StringTokenizer(br.readLine());
        s=br.readLine();
        stack=new ArrayDeque<>();
    }
    
    public static int proc() {
    	int sz=s.length();
    	int ans=0;
    	
    	for (int i = 0; i < sz; i++) {
    		char c=s.charAt(i);
			if(c=='(') {
				stack.addLast(-1);
			}
			else if(c=='[') {
				stack.addLast(-2);
			}
			else if(c==')') {
				int sum=0;
				while(!stack.isEmpty()) {
					int top=stack.pollLast();
					if(top==-2) {
						return 0;
					}
					else if(top==-1) {
						if(sum==0) sum=2;
						else sum*=2;
						stack.addLast(sum);
						break;
					}
					sum+=top;
				}
				if(stack.isEmpty()) {
					return 0;
				}
			}
			else if(c==']') {
				int sum=0;
				while(!stack.isEmpty()) {
					int top=stack.pollLast();
					if(top==-1) {
						return 0;
					}
					else if(top==-2) {
						if(sum==0) sum=3;
						else sum*=3;
						stack.addLast(sum);
						break;
					}
					sum+=top;
				}
				if(stack.isEmpty()) {
					return 0;
				}
			}
    	}
    	
    	while(!stack.isEmpty()) {
    		int top=stack.pollLast();
    		
    		if(top==-1||top==-2) {
    			return 0;
    		}
    		
    		ans+=top;
    	}
    	
    	return ans;
    }
}
