import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {

	public static int N, X;
	public static long ans=3000000005L, a,b,c;
	public static ArrayList<Long> numbers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		numbers=new ArrayList<>();
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers.add(Long.parseLong(st.nextToken()));
		}
		
		numbers.sort(Comparator.naturalOrder());
		
		for (int i = 0; i < N; i++) {
			search(numbers.get(i), i+1, N-1);
		}
		
		System.out.println(a+" "+b+" "+c);
	}
	
	public static void search(long num, int start, int end) {
		while(start<end) {
			long one=numbers.get(start);
			long two=numbers.get(end);
			long sum=num+one+two;
			
			if(ans>Math.abs(sum)) {
				ans=Math.abs(sum);
				a=num;
				b=one;
				c=two;
			}
			
			if(sum>0) {
				end--;
			}
			else start++;
		}
	}
	
	
}
