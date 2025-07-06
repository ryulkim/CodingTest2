import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
	

public class Main {
	
	static int N, D, K, C, ans=0;
	static int[] arr, cnt;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    	System.out.println(ans);
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	D=Integer.parseInt(st.nextToken());
    	K=Integer.parseInt(st.nextToken());
    	C=Integer.parseInt(st.nextToken());
    	arr=new int[N];
    	cnt=new int[D+1];
    	cnt[C]++;
    	
    	for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
    	
    }
    
    public static void proc() {
    	int count=1;
    	for (int i = 0; i < K; i++) {
			if(cnt[arr[i]]++==0) {
				count++;
			}
		}
    	
    	ans=Math.max(ans, count);
    	
    	int f=0,l=K;
    	while(f<N) {
    		if(cnt[arr[l]]++==0) {
				count++;
			}
    		l=(l+1)%N;
    		if(--cnt[arr[f++]]==0) {
    			count--;
    		}
    		ans=Math.max(ans, count);
    	}
    }
}