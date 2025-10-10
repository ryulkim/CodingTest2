import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static ArrayList<int[]> arr;
	static int[] chk;

	public static void main(String[] args) throws Exception {
    	init();
    	proc();
    }
        
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	arr=new ArrayList<>();
    	chk=new int[N+1];
    	
    	for (int i = 0; i < N; i++) {
    		st=new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int x=Integer.parseInt(st.nextToken());
				arr.add(new int[] {x,i});
			}
		}
    	
    	arr.sort((a,b)->Integer.compare(a[0], b[0]));
    }
    
    public static void proc() {
    	int f=0, l=0;
    	int ans=1000_000_000;
    	chk[arr.get(l)[1]]=1;
    	chk[N]=1;
    	
    	while(l<N*M) {
    		int diff=arr.get(l)[0]-arr.get(f)[0];
    		
    		if(chk[N]==N) {
    			ans=Math.min(ans, diff);
    			if(chk[arr.get(f)[1]]==1) {
    				chk[arr.get(f)[1]]=0;
    				chk[N]--;
    			}
    			else {
    				chk[arr.get(f)[1]]--;
    			}
    			f++;
    		}
    		else if(chk[N]<N) {
    			l++;
    			if(l==N*M) break;
    			
    			if(chk[arr.get(l)[1]]==0) {
    				chk[arr.get(l)[1]]=1;
    				chk[N]++;
        		}    		
        		else {
        			chk[arr.get(l)[1]]++;
        		}
    		}
    	}
    	
    	System.out.println(ans);
    }
}


