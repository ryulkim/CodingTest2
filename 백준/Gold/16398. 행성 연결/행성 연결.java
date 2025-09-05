import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] arr;
	static ArrayList<int[]> edges;
	static int[] par;
	
    public static void main(String[] args) throws Exception {
    	init();
    }
    
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N][N];
    	edges=new ArrayList<>();
    	par=new int[N];
    	
    	for (int i = 0; i < N; i++) {
			par[i]=i;
		}
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num=Integer.parseInt(st.nextToken());
				if(num!=0) edges.add(new int[] {i,j,num});
			}
		}
    	
    	edges.sort((a,b)->Integer.compare(a[2], b[2]));
    	
    	long sum=0;
    	for (int[] info: edges){
			if(union(info[0], info[1])) {
				sum+=info[2];
			}
		}
    	
    	System.out.println(sum);
    }
    
    public static boolean union(int a, int b) {
    	int parA=find(a);
    	int parB=find(b);
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
