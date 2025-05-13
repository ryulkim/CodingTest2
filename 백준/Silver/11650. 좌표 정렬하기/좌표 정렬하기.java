import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Object{
	public int x, y;

	public Object(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static int N;
	static Object[] arr;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	StringBuilder sb=new StringBuilder();
    	arr=new Object[N];
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine()," ");
    		int x=Integer.parseInt(st.nextToken());
    		int y=Integer.parseInt(st.nextToken());
    		
    
    		
    		arr[i]=new Object(x,y);
    		
//    		System.out.println(x+" "+y);
		}
    	
    	Arrays.sort(arr, (a,b)->{
    		if(a.x==b.x) return Integer.compare(a.y, b.y);
    		return Integer.compare(a.x, b.x);
    	});
    	
    	for (int i = 0; i < N; i++) {
			sb.append(arr[i].x+" "+arr[i].y);
			sb.append("\n");
		}
    	
    	System.out.println(sb);
    	
    }

}