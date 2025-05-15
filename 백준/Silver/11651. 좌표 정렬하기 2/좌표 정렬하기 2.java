import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int N;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->{
    		if(a[1]==b[1]) return Integer.compare(a[0], b[0]);
    		return Integer.compare(a[1], b[1]);
    	});
    	
    	for (int i = 0; i < N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			pq.add(new int[] {x,y});
		}
    	

    	while(!pq.isEmpty()) {
    		int[] info=pq.poll();
    		System.out.println(info[0]+" "+info[1]);
    	}
    }

}