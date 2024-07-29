import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		List<Integer> arr=new ArrayList<Integer>();
		boolean check[]=new boolean[1000001];
		int score[]=new int[1000001];
		int n=sc.nextInt();
		int m=0;
		
		for (int i = 0; i < n; i++) {
			int x=sc.nextInt();
			arr.add(x);
			check[x]=true;
			if(m<x)m=x;
		}
		
		for (int i = 0; i < n; i++) {
			int num=arr.get(i);
			for(int j=num*2;j<=m;j+=num) {
				if(check[j]) {
					score[j]--;
					score[arr.get(i)]++;
				}
			}
			
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(score[arr.get(i)]+" ");
		}
	}

}
