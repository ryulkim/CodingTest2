import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] ans, arr;

    public static void main(String[] args) throws IOException {
    	init();
    	back(0,0);
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N];
		ans=new int[M];
		
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
    }
    
    public static void back(int depth, int idx) {
    	if(depth==M) {
    		StringBuilder sb=new StringBuilder();
    		for (int i = 0; i < M; i++) {
				sb.append(ans[i]+" ");
			}
    		System.out.println(sb);
    		return;
    	}
    	for (int i = idx; i < N; i++) {
    		ans[depth]=arr[i];
    		back(depth+1, i+1);
		}
    }
    
    
}
