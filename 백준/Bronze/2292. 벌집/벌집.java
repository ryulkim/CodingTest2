import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
	
	static int N, MAX=20000;
	static int arr[];
	
	//1,7,19,37,61
	// 6,12,18,24

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	arr=new int[MAX];
    	arr[0]=1;
    	int plus=6;
    	
    	if(N==1) {
    		System.out.println(1);
    		return;
    	}
    	
    	for (int i = 1; i < MAX; i++) {
			arr[i]+=arr[i-1]+plus;
			plus+=6;
			if(arr[i]>=N) {
				System.out.println(i+1);
				break;
			}
		}
    	
//    	proc();
    }
    
    public static void proc() {
//    	for (int i = 0; i < MAX; i++) {
//			System.out.print(arr[i]+" ");
//		}
    	System.out.println(arr[MAX-1]);
    }
    
    

    
    
   
}