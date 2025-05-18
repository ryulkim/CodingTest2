import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
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
    	ArrayDeque<Integer> q=new ArrayDeque<>();
    	q.add(init);
    	boolean[] chk=new boolean[10000];
    	int[] from=new int[10000];
    	char[] how=new char[10000];
    	
    	Arrays.fill(from, -1);
    	
    	while(!q.isEmpty()) {
    		int num=q.poll();
    		
//    		System.out.println(obj.cmd+" "+obj.num);
    		
    		if(num==ans) {
    			String s="";
    			
    			while(num!=init) {
    				s=String.valueOf(how[num])+s;
    				num=from[num];
    			}
    			return s;
    		}
    		
    		int l=left(num);
    		int d=D(num);
    		int s=S(num);
    		int r=right(num);
    		
    		if(from[l]==-1) {
    			q.add(l);
    			from[l]=num;
    			how[l]='L';
    		}
    		if(from[d]==-1) {
    			q.add(d);
    			from[d]=num;
    			how[d]='D';
    		}
    		if(from[s]==-1) {
    			q.add(s);
    			from[s]=num;
    			how[s]='S';
    		}
    		if(from[r]==-1) {
    			q.add(r);
    			from[r]=num;
    			how[r]='R';
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