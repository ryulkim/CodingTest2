import java.io.*;
import java.util.*;

public class Main {
	
	static int T, N, M;
	static long ans=0;
	static int[] sumA, sumB;
	static HashMap<Integer, Integer> hm;
	static ArrayList<Integer> arr;
	
    public static void main(String[] args) throws IOException {
    	init();
    	make();
    	proc();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	
    	T=Integer.parseInt(br.readLine());
    	N=Integer.parseInt(br.readLine());
    	sumA=new int[N+1];
    	hm=new HashMap<>();
    	arr=new ArrayList<>();
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			int num=Integer.parseInt(st.nextToken());
			sumA[i]=sumA[i-1]+num;
		}
		
		M=Integer.parseInt(br.readLine());
		sumB=new int[M+1];
		st=new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= M; i++) {
			int num=Integer.parseInt(st.nextToken());
			sumB[i]=sumB[i-1]+num;
		}
    }
    
    public static void proc() {
    	for (int i = 0; i < arr.size(); i++) {
    		int num=arr.get(i);
    		ans+=hm.getOrDefault(T-num, 0);
		}
    	
    	System.out.println(ans);
    }
    
    public static void make() {
    	for (int i = 1; i <= N; i++) {
    		for (int j = i; j <= N; j++) {
    			int value=sumA[j]-sumA[i-1];
    			arr.add(value);
			}
		}
    	
    	for (int i = 1; i <= M; i++) {
			for (int j = i; j <= M; j++) {
				int value=sumB[j]-sumB[i-1];
				hm.put(value, hm.getOrDefault(value, 0)+1);
			}
		}
    }
    
}