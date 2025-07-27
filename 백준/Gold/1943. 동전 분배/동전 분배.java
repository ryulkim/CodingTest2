import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static int N, sum=0;
	static ArrayList<int[]> arr;
	static int[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < 3; i++) {
			init(br, sb);
		}
		System.out.println(sb);
//    	proc();
    }
    
	public static void init(BufferedReader br, StringBuilder sb) throws NumberFormatException, IOException {
    	N=Integer.parseInt(br.readLine());
    	arr=new ArrayList<>();
    	dp=new int[N+1][100_001];
    	sum=0;
    	
    	for (int i = 0; i < N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int price=Integer.parseInt(st.nextToken());
			int cnt=Integer.parseInt(st.nextToken());
			arr.add(new int[] {price, cnt});
			sum+=price*cnt;
		}
    	
    	for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
    	
    	if(proc()) {
    		sb.append(1);
    	}
    	else {
    		sb.append(0);
    	}
    	sb.append("\n");
	}

	public static boolean proc() {
		if(sum%2!=0) return false;
		
		for (int i = 0; i < N; i++) {
			int price=arr.get(i)[0];
			int cnt=arr.get(i)[1];
			dp[i][0]=0;
			for (int j = price; j <= sum/2; j++) {
				if(i>0&&dp[i-1][j]!=-1) {
					dp[i][j]=0;
				}
				else if(dp[i][j-price]!=-1&&dp[i][j-price]<cnt){
					dp[i][j]=dp[i][j-price]+1;
				}
			}
		}
		
		if(dp[N-1][sum/2]!=-1) {
			return true;
		}
		return false;
	}
	
}
