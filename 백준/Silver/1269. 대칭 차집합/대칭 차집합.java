import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	
	public static int n,m,AdB,BdA;
	public static Set<Integer> A;
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		A=new HashSet<>();
		AdB=n;
		BdA=m;
		
		st=new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < n; i++) {
			int num=Integer.parseInt(st.nextToken());
			A.add(num);
		}
		
		st=new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < m; i++) {
			int num=Integer.parseInt(st.nextToken());
			if(A.contains(num)) {
				AdB--;
				BdA--;
			}
		}
		
		System.out.println(AdB+BdA);
	}

}
