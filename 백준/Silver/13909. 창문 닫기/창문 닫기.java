import java.io.*;
import java.util.*;

public class Main {
	
	static int N, ans=0;
	
    public static void main(String[] args) throws IOException {
    	init();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	for (int i = 1; i*i <= N; i++) {
			ans++;
		}
    	
    	System.out.println(ans);
    }
}