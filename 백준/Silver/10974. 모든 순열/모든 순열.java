import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int input[];
	public static int N;
	public static int R;
	public static int numbers[];
	
	public static void permutation(int depth, int flag) {
		if(depth==N) {			
			for (int i = 0; i < N; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if((flag&(1<<i))!=0) { 
				continue;
			}
			numbers[depth]=input[i];
			permutation(depth+1, flag|1<<i);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N=sc.nextInt();
		input= new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i]=i+1;
		}
		
		numbers=new int[N];
		
		permutation(0, 0);
	}	
	
	
}

