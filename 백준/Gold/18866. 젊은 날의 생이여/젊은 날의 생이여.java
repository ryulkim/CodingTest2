import java.io.*;
import java.util.*;

public class Main {

	static int N, ans=-1;
	static int[] happy, sad;
	static int[] Lmin, Rmin, Lmax, Rmax;
	
    public static void main(String[] args) throws Exception {
    	init();
    }
        
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	N=Integer.parseInt(br.readLine());
    	happy=new int[N+1];
    	sad=new int[N+1];
    	Lmin=new int[N+1];
    	Rmin=new int[N+1];
    	Lmax=new int[N+1];
    	Rmax=new int[N+1];
    	
    	Arrays.fill(Lmin, 1000_000_000);
    	Arrays.fill(Rmin, 1000_000_000);
    	Arrays.fill(Lmax, -1000_000_000);
    	Arrays.fill(Rmax, -1000_000_000);

    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int u=Integer.parseInt(st.nextToken());
    		int v=Integer.parseInt(st.nextToken());
    		
    		happy[i]=u;
    		sad[i]=v;
		}
    	
    	for (int i = 1; i <= N; i++) {
			if(happy[i-1]>0) Lmin[i]=Math.min(Lmin[i-1],happy[i-1]);
			else Lmin[i]=Lmin[i-1];
			
			if(sad[i-1]>0) Lmax[i]=Math.max(Lmax[i-1], sad[i-1]);
			else Lmax[i]=Lmax[i-1];
		}
    	
    	for (int i = N-1; i >= 0; i--) {
    		if(sad[i]>0) Rmin[i]=Math.min(Rmin[i+1], sad[i]);
    		else Rmin[i]=Rmin[i+1];
    		
    		if(happy[i]>0) Rmax[i]=Math.max(Rmax[i+1], happy[i]);
    		else Rmax[i]=Rmax[i+1];
		}
    	
    	for (int i = 0; i < N-1; i++) {
			if(Lmin[i+1]>Rmax[i+1]&&Lmax[i+1]<Rmin[i+1]) {
				ans=i+1;
			}
		}
    	
    	System.out.println(ans);
    }
    
}
