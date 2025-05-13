import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int[] arr;
	static int sum=0;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	arr=new int[9];
    	
    	for (int i = 0; i < 9; i++) {
			arr[i]=Integer.parseInt(br.readLine());
			sum+=arr[i];
		}
    	
    	proc();
    	
    	Arrays.sort(arr);
    	
    	for (int i = 2; i < 9; i++) {
			System.out.println(arr[i]);
		}
    }
    
    
    public static void proc() {
    	for (int i = 0; i < 9; i++) {
			for (int j = i+1; j < 9; j++) {
				if(sum-(arr[i]+arr[j])==100) {
					arr[i]=0;
					arr[j]=0;
					return;
				}
			}
		}
    }
    
    
}