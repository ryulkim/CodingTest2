import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] par;

    public static void main(String[] args) throws Exception {
    	init();
    	proc();
    }

    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        par=new int[N+1];
        
        for (int i = 1; i <= N; i++) {
			par[i]=i;
		}
        
        for (int i = 0; i < M; i++) {
        	st=new StringTokenizer(br.readLine());
			int cmd=Integer.parseInt(st.nextToken());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			if(cmd==0) {
				union(a,b);
			}
			else if(cmd==1) {
				System.out.println(find(a)==find(b)?"YES":"NO");
			}
		}
    }
    
    public static void proc() {
    	
    }
    
    public static boolean union(int numA, int numB) {
    	int parA=find(numA);
    	int parB=find(numB);
    	
    	if(parA==parB) {
    		return false;
    	}
    	
    	par[parA]=parB;
    	return true;
    }
    
    public static int find(int num) {
    	if(par[num]==num) {
    		return num;
    	}
    	return par[num]=find(par[num]);
    }
}
