import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 시간: 124ms  메모리: 12028kb */

public class Main {

	public static String s;
	public static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		s=br.readLine();
		int sz=s.length();
		dp=new int[sz+1];
		
		Arrays.fill(dp, 3000);
		dp[0]=0;
		
		for (int i = 1; i < sz; i++) {
			for (int j = i; j <= sz; j++) {
				if(isPalindrome(i-1, j-1)) {
					dp[j]=Math.min(dp[j], dp[i-1]+1);
				}
				else {
					dp[j]=Math.min(dp[j], dp[j-1]+1);
				}
			}
		}
		
		System.out.println(dp[sz]);
		
	}
	
	public static boolean isPalindrome(int i, int j) {
		while(i<=j) {
			if(s.charAt(i++)!=s.charAt(j--)) return false;
		}
		return true;
	}

}
