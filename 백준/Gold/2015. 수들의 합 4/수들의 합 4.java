import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

/*
 * 시간: 356ms	메모리: 42,640KB
 */
public class Main {
	
	static int N, V;
	static long ans=0, K;
	static HashMap<Long, Integer> mp;
	static long[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		mp=new HashMap<>();
		arr=new long[N+1];
		mp.put(0L, 1);
		
		st=new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			V=Integer.parseInt(st.nextToken());
			arr[i]=arr[i-1]+V;
			ans+=mp.getOrDefault(arr[i]-K,0);
			
			mp.put(arr[i], mp.getOrDefault(arr[i],0)+1);
		}
		
		System.out.println(ans);
		
	}
}

