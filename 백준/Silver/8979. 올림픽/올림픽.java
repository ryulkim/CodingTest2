import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	static PriorityQueue<int[]> pq;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    }

	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	K=Integer.parseInt(st.nextToken());
    	pq=new PriorityQueue<int[]>((a,b)->{
    		if(a[1]==b[1]&&a[2]==b[2]) {
    			return Integer.compare(b[3], a[3]);
    		}
    		else if(a[1]==b[1]) {
    			return Integer.compare(b[2], a[2]);
    		}
    		return Integer.compare(b[1], a[1]);
    	});
    	
    	for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			int num=Integer.parseInt(st.nextToken());
			int gold=Integer.parseInt(st.nextToken());
			int silver=Integer.parseInt(st.nextToken());
			int bronze=Integer.parseInt(st.nextToken());
			pq.add(new int[] {num,gold,silver,bronze});
		}
    }
	
	
    public static void proc() {
    	int rank=0;
    	int cnt=0;
    	int gold=-1, silver=-1, bronze=-1;
    	while(!pq.isEmpty()) {
    		int[] info=pq.poll();
    		
//    		System.out.println(info[0]+" "+info[1]+" "+info[2]+" "+info[3]);
//    		System.out.println(rank);
    		

    		
    		if(gold==info[1]&&silver==info[2]&&bronze==info[3]) {
    			cnt++;
    		}
    		else {
    			rank+=cnt;
    			cnt=0;
    			rank++;
    			gold=info[1];
    			silver=info[2];
    			bronze=info[3];
    		}
    		
    		if(info[0]==K) {
    			break;
    		}
			
    	}
    	System.out.println(rank);
    }
}