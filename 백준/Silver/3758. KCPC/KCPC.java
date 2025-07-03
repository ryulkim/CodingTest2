import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;


public class Main {

	static int T, N, K, M, mId;
	static int[][] scores;
	static int[] latest, cnt;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
//    	proc();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	T=Integer.parseInt(br.readLine());
    	
    	for (int testCase = 0; testCase < T; testCase++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		N=Integer.parseInt(st.nextToken());
    		K=Integer.parseInt(st.nextToken());
    		mId=Integer.parseInt(st.nextToken());
    		M=Integer.parseInt(st.nextToken());
    		scores=new int[N+1][K+1];
    		latest=new int[N+1];
    		cnt=new int[N+1];
    		
    		for (int i = 0; i < M; i++) {
				st=new StringTokenizer(br.readLine());
				int id=Integer.parseInt(st.nextToken());
				int num=Integer.parseInt(st.nextToken());
				int score=Integer.parseInt(st.nextToken());
				scores[id][num]=Math.max(scores[id][num], score);
				latest[id]=i;
				cnt[id]++;
			}
    		proc();
		}
    	
    }
    
    public static void proc() {
    	int[] sum=new int[N+1];
    	
    	for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= K; j++) {
				sum[i]+=scores[i][j];
			}
		}
    	
    	int target=sum[mId];
    	int rank=1;
    	for (int i = 1; i <= N; i++) {
    		if(i==mId) continue;
			if(target<sum[i]) {
				rank++;
			}
			else if(target==sum[i]) {
				if(cnt[i]==cnt[mId]) {
					if(latest[i]<latest[mId]) {
						rank++;
					}
				}
				else if(cnt[i]<cnt[mId]) {
					rank++;
				}
			}
		}
    	
    	System.out.println(rank);
    }
  
}