import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Object{
	public int age, order;
	public String name;
	
	public Object(int age, String name, int order) {
		super();
		this.age = age;
		this.name = name;
		this.order = order;
	}
}


public class Main {
	
	static int N, age;
	static String name;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	PriorityQueue<Object> pq=new PriorityQueue<Object>((a,b)->{
    		if(a.age==b.age) return Integer.compare(a.order, b.order);
    		return Integer.compare(a.age, b.age);
    	});
    	StringBuilder sb=new StringBuilder();
    	
    	for (int i = 0; i < N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			age=Integer.parseInt(st.nextToken());
			name=st.nextToken();
			pq.add(new Object(age, name, i));
		}
    	
    	while(!pq.isEmpty()) {
    		Object obj=pq.poll();
    		sb.append(obj.age+" "+obj.name);
    		sb.append("\n");
    	}
    	
    	System.out.println(sb);
    }
    
}