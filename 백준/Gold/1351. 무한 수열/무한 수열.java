import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 시간: 128ms	메모리: 15,052KB
 */
public class Main {
	
	static long N;
	static int P, Q;
	static HashMap<Long, Long> dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Long.parseLong(st.nextToken());
		P=Integer.parseInt(st.nextToken());
		Q=Integer.parseInt(st.nextToken());
		dp=new HashMap<>();
		dp.put(0L, 1L);
		
		if(N>0)	topDown(N);
		
		System.out.println(dp.get(N));
		
		
	}
	
	public static void topDown(long num) {
		long a=num/P;
		long b=num/Q;
		
		if(dp.get(a)==null) {
			topDown(a);
		}
		if(dp.get(b)==null) {
			topDown(b);
		}
		dp.put(num, dp.get(a)+dp.get(b));
		
	}
}

