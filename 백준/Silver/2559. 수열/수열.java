import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int N, K, ans=-1000_000_000;
	static int[] arr, sum;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    	System.out.println(ans);
    }

	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	K=Integer.parseInt(st.nextToken());
    	arr=new int[N+1];
    	sum=new int[N+1];
    	
    	st=new StringTokenizer(br.readLine());
    	for (int i = 1; i <= N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			sum[i]=arr[i]+sum[i-1];
			
//			System.out.println(i+" "+arr[i]);
		}
    }
    
    public static void proc() {
    	int end=K;
    	int start=1;
    	while(end<=N) {
    		ans=Math.max(ans, sum[end++]-sum[start++-1]);
    	}
    }
}