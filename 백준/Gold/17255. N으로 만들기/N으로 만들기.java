import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 시간: 872ms	메모리: 83,760KB
 */
public class Main {
	
	static String s;
	static int N, ans=0;
	static HashMap<String, Integer> num; //키: 문자열, 값: 개수 
//	static HashSet<String> visited;
	static HashSet<ArrayList<String>> visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		s=br.readLine();
		N=s.length();
		num=new HashMap<>();
		visited=new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			String temp=s.substring(i, i+1);
			num.put(temp, num.getOrDefault(temp, 0)+1);
//			visited=new HashSet<>();
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
			num.put(temp, num.getOrDefault(temp, 0)+1);
			ArrayList<String> arr=new ArrayList<>(path);
			arr.add(temp);
			dfs(first, last+1, temp, cnt+1, arr);
		}
		if(first-1>=0) {
			String temp=s.charAt(first-1)+str;
			num.put(temp, num.getOrDefault(temp, 0)+1);
			ArrayList<String> arr=new ArrayList<>(path);
			arr.add(temp);
			dfs(first-1, last, temp, cnt+1, arr);
		}
	}
}

