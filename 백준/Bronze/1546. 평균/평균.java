import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static int N;
	static int[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
//    	System.out.println(ans);
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N];
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
    }
    
    public static void proc() {
    	Arrays.sort(arr);
    	double sum=0;
    	
    	for (int i = 0; i < N; i++) {
			sum+=(double) ((double) arr[i]/arr[N-1]) *100;
//			System.out.println(sum);
		}
    	
    	sum/=N;
    	
    	System.out.println(sum);
    }
}