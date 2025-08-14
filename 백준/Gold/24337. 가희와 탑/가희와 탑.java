import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int N, L, R;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
		proc();
    }

	public static void init() throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		arr=new int[N];
		
	}
	
	public static void proc() {
		StringBuilder sb=new StringBuilder();
		
		if(L+R-1>N) {
			System.out.println(-1);
			return;
		}
		
		int num=0;
		if(L<R) {
			num=R;
		}
		else {
			num=L;
		}
		
		if(L==1) {
			arr[0]=num;
			
			int num1=1;
			for (int i = N-1; i >= 1; i--) {
				if(num1==num) arr[i]=1;
				else arr[i]=num1++;
			}
		}
		else {
			arr[N-R]=num;
			for (int i = N-R-1; i >= 0; i--) {
				if(L==1) arr[i]=1;
				else arr[i]=--L;
			}
			
			int num1=1;
			for (int i = N-1; i >= N-R+1; i--) {
				if(num1==num) arr[i]=1;
				else arr[i]=num1++;
			}
		}
		
		
		
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]+" ");
		}
		System.out.println(sb);

	}
	
}