import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 시간: 144ms	메모리: 16,560KB
 */
public class Main {
	
	static String s;
	static int N, ans=0;
	static HashSet<ArrayList<String>> visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		s=br.readLine();
		N=s.length();
		visited=new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			String temp=s.substring(i, i+1);
			ArrayList<String> arr=new ArrayList<>();
			arr.add(temp);
			dfs(i,i,temp,1,arr);
		}
		
		System.out.println(ans);
	}
	
	public static void dfs(int first, int last, String str, int cnt, ArrayList<String> path) {
		if(cnt==N) {
			if(!visited.contains(path)) {
				ans++;
				visited.add(path);
			}
			return;
		}
		
		if(last+1<N) {
			String temp=str+s.charAt(last+1);
			ArrayList<String> arr=new ArrayList<>(path);
			arr.add(temp);
			dfs(first, last+1, temp, cnt+1, arr);
		}
		if(first-1>=0) {
			String temp=s.charAt(first-1)+str;
			ArrayList<String> arr=new ArrayList<>(path);
			arr.add(temp);
			dfs(first-1, last, temp, cnt+1, arr);
		}
	}
}

