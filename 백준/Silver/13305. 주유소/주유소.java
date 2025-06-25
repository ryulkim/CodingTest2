import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] dist, price;
	static long[] djik;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	System.out.println(proc());
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	dist=new int[N];
    	price=new int[N];
    	djik=new long[N];
    	
    	Arrays.fill(djik, 1000_000_000_000_000_000L);
    	
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < N-1; i++) {
			dist[i]=Integer.parseInt(st.nextToken());
		}
    	
    	st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
			price[i]=Integer.parseInt(st.nextToken());
		}
    	
    }
     
    public static long proc() {
    	long ans=1000_000_000_000_000_000L;
    	// idx, 총 가격
    	PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
    		if(a[1]==b[1]) return Integer.compare(b[0], a[0]);
    		return Integer.compare(a[1], b[1]);
    	});
    	pq.add(new int[] {0,0});
    	djik[0]=0;
    	
    	while(!pq.isEmpty()) {
    		int[] infos=pq.poll();
//    		int idx=infos[0];
//    		int value=infos[1];
//    		System.out.println(infos[0]+" "+infos[1]);
    		
    		if(djik[infos[0]]!=infos[1]) {
    			continue;
    		}
    		
    		if(infos[0]==N-1) {
    			ans=infos[1];
    			break;
    		}
    		int sum=0;
    		for (int i = infos[0]; i < N-1; i++) {
				sum+=dist[i];
				int total=infos[1]+sum*price[infos[0]];
				if(djik[i+1]>total) {		
					djik[i+1]=total;
					pq.add(new int[] {i+1, total});
				}
			}
    	}
    	
    	return ans;
    }
    
    
    
}