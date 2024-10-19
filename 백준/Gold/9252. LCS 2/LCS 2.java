import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 시간: 96ms  메모리: 16148KB */

public class Main {

	public static String A, B;
	public static int[][] LCS;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		A=br.readLine();
		B=br.readLine();
		int ASz=A.length();
		int BSz=B.length();
		LCS=new int[BSz+1][ASz+1];
		
		for (int i = 1; i <= BSz; i++) {
			for (int j = 1; j <= ASz; j++) {
				if(A.charAt(j-1)==B.charAt(i-1)) LCS[i][j]=LCS[i-1][j-1]+1;
				else LCS[i][j]=Math.max(LCS[i-1][j], LCS[i][j-1]);
			}
		}
		
		int i=BSz, j=ASz;

		while(LCS[i][j]!=0) {
			if(LCS[i][j]==LCS[i-1][j]) {
				i--;
			}
			else if(LCS[i][j]==LCS[i][j-1]) {
				j--;
			}
			else {
				sb.append(B.charAt(i-1));
				i--;
				j--;
			}
		}
		
		sb.reverse();
		
		System.out.println(LCS[BSz][ASz]);
		System.out.println(sb);
		
	}
	

}
