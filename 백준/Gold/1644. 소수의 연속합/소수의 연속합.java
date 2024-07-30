import java.util.*;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		boolean arr[]=new boolean[n+1];
		List<Integer> arr2=new ArrayList<Integer>();
		int sum=0, idx=0, cnt=0;
		
		for (int i = 2; i*i <= n; i++) {
			if(arr[i]) continue;

			for (int j = i+i; j <= n; j+=i) {
				arr[j]=true;
			}
		}
		
		
		for (int i = 2; i <= n; i++) {
			if(arr[i]) continue;
			sum+=i;
			arr2.add(i);
			
//			System.out.println(i);
			
			while(sum>n) {
//				System.out.println("-"+arr2.get(idx));
				sum-=arr2.get(idx++);
				
			}
			
			if(sum==n) {
				cnt++;
//				System.out.println(i);
			}
		}
		
		System.out.println(cnt);
		
	}

}