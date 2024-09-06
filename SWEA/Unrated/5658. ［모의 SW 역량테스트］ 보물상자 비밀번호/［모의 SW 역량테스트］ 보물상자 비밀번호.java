import java.io.*;
import java.util.*;

/*
 * 18,380 kb
 * 72 ms
 */
public class Solution {
	
	public static int T,N,K,ans;
	public static ArrayList<Character> arr; 
	public static TreeSet<Integer> ts;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			String input=br.readLine();
			arr=new ArrayList<>();
			ts=new TreeSet<>(Collections.reverseOrder());
			int cnt=N/4;
			int len=N/4;
			
			for (int i = 0; i < N; i++) {
				arr.add(input.charAt(i));
			}
			
			while(cnt-->0) {
				for (int i = 1; i <= 4; i++) {
					int sum=0;
					for (int j = 1; j <= len; j++) {
						char c=arr.get(i*len-j);
						
						if(c>='0'&&c<='9') {
							c-='0';
						}
						else {
							c-='A';
							c+=10;
						}
						sum+=c<<(4*(j-1));
					}
					ts.add(sum);
				}
				
				Collections.rotate(arr, 1);
			}
			
			Integer[] ans=ts.toArray(new Integer[0]);
			
			sb.append("#"+testCase+" "+ans[K-1]+'\n');
		}
		System.out.println(sb);
	}
	
}
