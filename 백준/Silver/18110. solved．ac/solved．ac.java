import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	
	static int N;
	static int[] arr, sum;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	System.out.println(init());
    	
//    	chk();
    }
    
    public static int init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N];
    	sum=new int[N];
    	
    	if(N==0) {
    		return 0;
    	}
    	
    	for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
    	
    	Arrays.sort(arr);
    	sum[0]=arr[0];
    	
    	for (int i = 1; i < N; i++) {
			sum[i]=sum[i-1]+arr[i];
		}
    	
    	long person = Math.round(N * 0.15);
    	
    	if((N-person)<1) {
    		return 0;
    	}
    	
    	int total=sum[(int) (N-person) -1];
    	if(person>=1) total-= sum[(int) person-1];
    	int cnt=(int) (N-(person*2));
    	
//    	System.out.println(total);
    	
    	return (int) Math.round((double) total/cnt);
    	
    }
    
    public static void chk() {
    	for (int i = 0; i < N; i++) {
			System.out.print(sum[i]+" ");
		}
    	System.out.println();
    }

}