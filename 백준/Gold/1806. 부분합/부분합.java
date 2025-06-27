import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static int N, S, ans=1000_000_000;
	static int[] arr, sum;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    	System.out.println(ans);
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	S=Integer.parseInt(st.nextToken());
    	arr=new int[N+1];
    	sum=new int[N+1];
    	
    	st=new StringTokenizer(br.readLine());
    	for (int i = 1; i <= N; i++) {
			int num=Integer.parseInt(st.nextToken());
			arr[i]=num;
			sum[i]=num+sum[i-1];
		}
    	
    }

    public static void proc() {
    	int f=1, l=1;
    	
    	while(l<=N) {
    		int value=sum[l]-sum[f-1];
    		if(value>=S) {
    			ans=Math.min(ans, l-f+1);
//    			System.out.println(f+" "+l+" "+ans);
    			f++;
    		}
    		else {
    			l++;
    		}
    	}
    	
    	if(ans==1000_000_000) {
    		ans=0;
    	}
    }
    
}