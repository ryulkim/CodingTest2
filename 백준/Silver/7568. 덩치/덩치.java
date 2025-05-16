import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	
	static int N;
	static int[][] arr;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    	
//    	chk();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N][2];
    	
    	for (int i = 0; i < N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			arr[i][0]=x;
			arr[i][1]=y;
		}
    	
    }
    
    public static void proc() {
    	for (int i = 0; i < N; i++) {
    		int cnt=0;
			for (int j = 0; j < N; j++) {
				if(i==j) continue;
				
				if(arr[i][0]<arr[j][0]&&arr[i][1]<arr[j][1]) {
					cnt++;
				}
			}
			System.out.print(cnt+1+" ");
		}
    }

}