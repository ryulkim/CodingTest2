import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static int A, N;
	static ArrayList<Integer>[] info;
	static int[] inBound, times, start;
	static ArrayDeque<Integer> q;
	

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	info=new ArrayList[N+1];
    	inBound=new int[N+1];
    	times=new int[N+1];
    	start=new int[N+1];
    	q=new ArrayDeque<Integer>();
    	
//    	Arrays.fill(start, 1000_000_000);
    	
    	for (int i = 1; i <= N; i++) {
			info[i]=new ArrayList<>();
		}
    	
    	for (int i = 1; i <= N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int time = Integer.parseInt(st.nextToken());
    		int cnt = Integer.parseInt(st.nextToken());
    		times[i] = time;
    		
    		for (int j = 0; j < cnt; j++) {
    			int num = Integer.parseInt(st.nextToken());
	    		info[num].add(i);
	    		inBound[i]++;
			}
    	}
    	
    	for (int i = 1; i <= N; i++) {
			if(inBound[i]==0) {
				q.add(i);
			}
		}
    }
    
    public static void chk() {
    	for (int i = 1; i <= N; i++) {
			System.out.print(start[i]+" ");
		}
    	System.out.println();
    }
    
    public static void proc() {
    	int ans=0;
    	
    	while(!q.isEmpty()) {
    		int num=q.poll();
    		ans=Math.max(ans, start[num]+times[num]);
    		
    		
    		for (int i = 0; i < info[num].size(); i++) {
				int nxt=info[num].get(i);
				start[nxt]=Math.max(start[nxt], start[num]+times[num]);
				
//				System.out.println(nxt+" "+start[nxt]);
				
				if(--inBound[nxt]==0) q.add(nxt);
			}
    		
    	}
    	
    	System.out.println(ans);
    }
    
    
}