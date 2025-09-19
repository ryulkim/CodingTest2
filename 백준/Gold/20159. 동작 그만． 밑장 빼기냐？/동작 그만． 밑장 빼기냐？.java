import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] arr, A, B;
	
    public static void main(String[] args) throws Exception {
    	init();
    	proc();
    }
        
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N];
    	A=new int[N/2+1];
    	B=new int[N/2+1];
    	
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			if(i%2==0) {
				A[i/2+1]+=A[i/2]+arr[i];				
			}
			else {
				B[i/2+1]+=B[i/2]+arr[i];
			}
		}
    }
    
    public static void proc() {
    	int ans=0;
    	for (int i = 0; i <= N/2; i++) {
			int sum=A[i]+(B[N/2]-B[i]); // 정훈이가 밑장 가져갈 때
			ans=Math.max(ans, sum);	
			if(i>1) {
				sum=A[i]+(B[N/2]-B[i-1])-arr[N-1]; // 상대가 밑장 가져갈 때
				ans=Math.max(ans, sum);	
			}
		}
    	
    	System.out.println(ans);
    }
}
