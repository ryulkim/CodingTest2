import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static int M;
	static boolean arr[];

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
//    	proc();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	M=Integer.parseInt(br.readLine());
    	arr=new boolean[21];
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
    			sb.append(check(Integer.parseInt(st.nextToken()))+"\n");
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
    	arr[x]=true;
    }
    
    public static void remove(int x) {
    	arr[x]=false;
    }
    
    public static int check(int x) {
    	return arr[x]?1:0;
    }
    
    public static void toggle(int x) {
    	if(check(x)==0) {
    		add(x);
    		return;
    	}
    	remove(x);
    }
    
    public static void all() {
    	Arrays.fill(arr, true);
    }
    
    public static void empty() {
    	Arrays.fill(arr, false);
    }

}