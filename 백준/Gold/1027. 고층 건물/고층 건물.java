import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	static int N;
	static int[] arr;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    }
    
	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N];
    	
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		int x=Integer.parseInt(st.nextToken());
    		arr[i]=x;
		}
    	
    	System.out.println(proc());
	}
	
	public static int proc() {
		int ans=0;
		
		for (int i = 0; i < N; i++) {
			int cnt=0;
			
			for (int j = 0; j < i; j++) {
				double a=(double) (arr[i]-arr[j])/(i-j);
				boolean flag=true;
				for (int k = 1; k < i-j; k++) {
					if((double) a*k+arr[j] <= arr[j+k]) {
						flag=false;
						break;
					}
				}
				if(flag) {
					cnt++;
				}
			}
			
			for (int j = i+1; j < N; j++) {
				double a=(double) (arr[j]-arr[i])/(j-i);
				boolean flag=true;
				for (int k = 1; k < j-i; k++) {
					if((double) a*k+arr[i] <= arr[i+k]) {
						flag=false;
						break;
					}
				}
				if(flag) {
					cnt++;
				}
			}
			
			ans=Math.max(ans, cnt);
		}
		
		return ans;
	}
	
}
