import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	
	public static int n,m,AdB,BdA;
	public static Set<String> subCombi;
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		subCombi=new HashSet<>();
		String s=br.readLine();
		int len=s.length();
		
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				subCombi.add(s.substring(i, j+1));
			}
		}
		
		System.out.println(subCombi.size());
		
	}

}
