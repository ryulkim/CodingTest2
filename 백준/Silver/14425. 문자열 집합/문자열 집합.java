import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
	
	public static int n, m, ans=0;
	public static Set<String> s;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		s=new HashSet<>();
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			s.add(br.readLine());
		}
		
		for (int i = 0; i < m; i++) {
			if(s.contains(br.readLine())) ans++;
		}
		
		System.out.println(ans);
		
	}
	
}

/*
1
4
I 4
I 2
D 1
D -1

*/