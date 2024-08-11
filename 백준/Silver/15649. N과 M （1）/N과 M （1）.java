import java.util.Scanner;

public class Main {
	
	public static int input[];
	public static int numbers[];
	public static int N;
	public static int R;
	public static boolean isSelected[];
	
	public static void permutation(int depth, int flag) {
		if(depth==R) {
			for (int i = 0; i < R; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if((flag&1<<i)!=0) continue;
			numbers[depth]=input[i];
			permutation(depth+1, flag|1<<i);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N=sc.nextInt();
		R=sc.nextInt();
		input= new int[N];
		numbers= new int[R];
		
		for (int i = 0; i < N; i++) {
			input[i]=i+1;
		}
		
		permutation(0,0);
	}	
	
	
}

