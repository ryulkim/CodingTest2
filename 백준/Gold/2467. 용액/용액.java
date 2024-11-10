import java.util.*;
import java.io.*;

public class Main {
    public static int n, MAX=2000000003, ans=MAX, num1, num2, cnt=0;
    public static int[] numbers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		n=Integer.parseInt(br.readLine());
		numbers=new int[n];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numbers[i]=Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < n ; i++) {
			if(numbers[i]>0) {
				if(cnt>0) break;
				cnt++;
			}
			int idx=Arrays.binarySearch(numbers, 0, n, Math.abs(numbers[i]));
			if(idx<0) idx=-idx-1;
			else if(idx>=0&&idx!=i) {
				ans=0;
				num1=numbers[i];
				num2=numbers[idx];
				break;
			}
			else {
				idx=idx+1;
			}
			int f=idx, s=idx-1;
			if(f!=i&&f<n&&ans>Math.abs(numbers[f]+numbers[i])) {
				ans=Math.abs(numbers[f]+numbers[i]);
				num1=numbers[i];
				num2=numbers[f];
			}
			if(s!=i&&s>=0&&ans>Math.abs(numbers[s]+numbers[i])) {
				ans=Math.abs(numbers[s]+numbers[i]);
				num1=numbers[i];
				num2=numbers[s];
			}
			
//			System.out.println(f+" "+s);
		}
		
		if(ans==MAX) {
			num1=numbers[0];
			num2=numbers[1];
		}
		
		
		System.out.println(num1+" "+num2);
		
	}
}

