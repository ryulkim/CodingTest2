import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	static int N, B, C;
	static int[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    }
    
    
    public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N];
    	
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		int A=Integer.parseInt(st.nextToken());
    		arr[i]=A;
		}
    	    	
    	st=new StringTokenizer(br.readLine());
    	B=Integer.parseInt(st.nextToken());
    	C=Integer.parseInt(st.nextToken());
    }
    
    public static void proc() {
    	long sum=0;
    	for (int i = 0; i < N; i++) {
			arr[i]-=B;
			sum++;
			if(arr[i]>0) {
				sum+=arr[i]/C;
				if(arr[i]%C>0) sum++;
			}
		}
    	System.out.println(sum);
    }
}