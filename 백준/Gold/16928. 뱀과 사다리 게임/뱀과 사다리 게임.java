import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M;
	static int[] dp, move;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    	System.out.println(dp[100]);
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	dp=new int[101];
    	move=new int[101];
    	
    	Arrays.fill(dp, 1000_000_000);
    	
    	for (int i = 0; i < N; i++) {
    		st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			move[x]=y;
		}
    	
    	for (int i = 0; i < M; i++) {
    		st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			
			move[u]=v;
		}
    }
    
    public static void proc() {
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	q.add(new int[] {1,0});
    	
    	while(!q.isEmpty()){
    		int[] temp=q.poll();
//			System.out.println(temp[0]+" "+move[temp[0]]+" "+temp[1]);
    		
    		if(move[temp[0]]!=0) {
    			if(dp[move[temp[0]]]>temp[1]) {
    				dp[move[temp[0]]]=temp[1];
    				q.add(new int[] {move[temp[0]], temp[1]});
    			}
    			
    			continue;
    		}
    		
    		for (int i = 1; i <= 6; i++) {
    			if(temp[0]+i>100) break;
    			if(dp[temp[0]+i]>temp[1]+1) {
    				dp[temp[0]+i]=temp[1]+1;
    				q.add(new int[] {temp[0]+i, temp[1]+1});
    			}
				
    		}
    	}
    }
    
}