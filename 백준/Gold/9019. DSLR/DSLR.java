import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


class Objects{
	public String cmd;
	public int num;
	
	public Objects(String cmd, int num) {
		super();
		this.cmd = cmd;
		this.num = num;
	}
}


public class Main {
	
	static int T;
	static char[] cmdList= {'D','S','L','R'};
	

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	T=Integer.parseInt(br.readLine());
    	
    	for (int testCase = 0; testCase < T; testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			int A=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
			
			String ans=bfs(A, B);
			
			System.out.println(ans);
		}
    	
    }
    
    
    public static String bfs(int init, int ans) {
    	ArrayDeque<Objects> q=new ArrayDeque<>();
    	q.add(new Objects("", init));
    	boolean[] chk=new boolean[10000];
    	
    	while(!q.isEmpty()) {
    		Objects obj=q.poll();
    		
//    		System.out.println(obj.cmd+" "+obj.num);
    		
    		if(obj.num==ans) {
    			return obj.cmd;
    		}
    		
    		int l=left(obj.num);
    		int d=D(obj.num);
    		int s=S(obj.num);
    		int r=right(obj.num);
    		
    		if(!chk[l]) {
    			q.add(new Objects(obj.cmd+"L",l));
    			chk[l]=true;
    		}
    		if(!chk[d]) {
    			q.add(new Objects(obj.cmd+"D",d));
    			chk[d]=true;
    		}
    		if(!chk[s]) {
    			q.add(new Objects(obj.cmd+"S",s));
    			chk[s]=true;
    		}
    		if(!chk[r]) {
    			q.add(new Objects(obj.cmd+"R",r));
    			chk[r]=true;
    		}
    	}
    	
    	return "";
    }
    
    public static int left(int num) {
    	int first=num/1000;
    	return (num*10)%10000+first;
    }
    
    public static int right(int num) {
    	int first=num%10;
    	return (num/10)%10000+first*1000;
    }
    
    public static int D(int num) {
    	return (num*2)%10000;
    }
    
    public static int S(int num) {
    	return (num+9999)%10000;
    }
}