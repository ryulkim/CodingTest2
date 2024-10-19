import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static String A, B;
	public static int[][] LCS;
	public static int ans=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		A=br.readLine();
		B=br.readLine();
		int ASz=A.length();
		int BSz=B.length();
		LCS=new int[BSz+1][ASz+1];
		
		for (int i = 1; i <= BSz; i++) {
			for (int j = 1; j <= ASz; j++) {
				if(A.charAt(j-1)==B.charAt(i-1)) LCS[i][j]=LCS[i-1][j-1]+1;
				else LCS[i][j]=Math.max(LCS[i-1][j], LCS[i][j-1]);
				Math.max(ans, LCS[i][j]);
			}
		}
		
		System.out.println(LCS[BSz][ASz]);
		
	}
	

}
