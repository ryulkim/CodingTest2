import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	
    	for (int i = 1; i <= 1_000_000; i++) {
			if(N==proc(i)+i) {
				System.out.println(i);
				return;
			}
		}
    	
    	System.out.println(0);
    }
    
    public static int proc(int num) {
    	int sum=0;
    	while(num>0) {
    		sum+=num%10;
    		num/=10;
    	}
    	return sum;
    }
}