import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int N; 
	static long B;
	static int[][] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	int[][] ans=square(arr,B);
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	B=Long.parseLong(st.nextToken());
    	arr=new int[N][N];
    	
    	for (int i = 0; i < N; i++) {
    		st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    	
    }
    
    public static int[][] square(int[][] arr, long num) {
    	if(num==1) {
    		int[][] temp=new int[N][N];
    		for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					temp[i][j]=arr[i][j]%1000;
				}
			}
    		return temp; 
    	}
    	
    	int[][] temp=new int[N][N];
    	int[][] ans=square(arr,num/2);
		temp=cal(ans,ans);
    	
    	if(num%2==1) {
    		temp=cal(temp,arr);
    	}
    	return temp;
    }
    
    public static int[][] cal(int[][] arr1, int[][] arr2){
    	int[][] temp=new int[N][N];
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				long sum=0;
				for (int k = 0; k < N; k++) {
					sum+=arr1[i][k]*arr2[k][j];
				}
				temp[i][j]=(int) (sum%1000);
			}
		}
    	
    	return temp;
    }
}