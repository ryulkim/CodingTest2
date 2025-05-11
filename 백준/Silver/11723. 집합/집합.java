import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static int M;
	static int S;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
//    	proc();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	M=Integer.parseInt(br.readLine());
    	StringBuilder sb=new StringBuilder();
    	
    	for (int i = 0; i < M; i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		String cmd=st.nextToken();
    		
    		switch(cmd) {
    		case "add":
    			add(Integer.parseInt(st.nextToken()));
    			break;
    		case "remove":
    			remove(Integer.parseInt(st.nextToken()));
    			break;
    		case "check":
    			sb.append(check(Integer.parseInt(st.nextToken()))).append('\n');
    			break;
    		case "toggle":
    			toggle(Integer.parseInt(st.nextToken()));
    			break;
    		case "all":
    			all();
    			break;
    		case "empty":
    			empty();
    			break;
    		}
    		
		}
    	
    	
    	System.out.println(sb);
    	
    }
    
    public static void add(int x) {
    	S|=(1<<x);
    }
    
    public static void remove(int x) {
    	S&=~(1<<x);
    }
    
    public static int check(int x) {
    	return (S&(1<<x))!=0?1:0;
    }
    
    public static void toggle(int x) {
    	S^=(1<<x);
    }
    
    public static void all() {
    	S=(1<<21)-1;
    }
    
    public static void empty() {
    	S=0;
    }

}