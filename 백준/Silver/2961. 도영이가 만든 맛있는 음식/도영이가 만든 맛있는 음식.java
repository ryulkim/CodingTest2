import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static int n;
	public static long ans=1000000000;
	public static List<Long> sour, bitter;
	public static int[] numbers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		numbers=new int[n+1];
		sour=new ArrayList<>();
		bitter=new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine(), " ");
			sour.add(Long.parseLong(st.nextToken()));
			bitter.add(Long.parseLong(st.nextToken()));
		}
		
		generateSubset(0, 0);
		
		System.out.println(ans);
		
	}
	
	public static void generateSubset(int depth, int len) {
		if(depth==n&&len==0) return;
		if(depth==n) {
			long s=1, b=0;
			
			for (int i = 0; i < len; i++) {
				int idx=numbers[i];
//				System.out.print(idx+" ");
				s*=sour.get(idx);
				b+=bitter.get(idx);
			}
//			System.out.println();
			
			long diff=Math.abs(s-b);
			if(diff<ans) {
				ans=diff;
			}
			return;
		}
		
		numbers[len]=depth;
		generateSubset(depth+1, len+1);
		
		generateSubset(depth+1, len);
	}

}
