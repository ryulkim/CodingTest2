import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M, B, ans=0, minTime=1000_000_000;
	static int[][] info;
	
	//1,7,19,37,61
	// 6,12,18,24

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    	System.out.println(minTime+" "+ans);
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	B=Integer.parseInt(st.nextToken());
    	info=new int[N][M];
    	
    	for (int i = 0; i < N; i++) {
    		st=new StringTokenizer(br.readLine());
    		
			for (int j = 0; j < M; j++) {
				info[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    }
    
    public static void proc() {
    	for (int k = 0; k <= 256; k++) {
    		int inventory=0;
    		int time=0;
    		for (int i = 0; i < N; i++) {
    			for (int j = 0; j < M; j++) {
    				if(info[i][j]<k) {
    					int cnt=(k-info[i][j]);
    					inventory-=cnt;
    					time+=cnt;
    				}
    				else {
    					int cnt=(info[i][j]-k);
    					inventory+=cnt;
    					time+=2*cnt;
    				}
    			}
    		}
    		if(inventory+B>=0&&minTime>=time&&ans<=k) {
    			minTime=time;
    			ans=k;
    		}
		}
    }
    
    

    
    
   
}