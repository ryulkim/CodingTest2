import java.io.*;
import java.util.*;

public class Main {
	
	static int N, bCnt=0, rCnt=0, ans=1000_000;
	static String s;
	
    public static void main(String[] args) throws IOException {
    	init();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	s=br.readLine();
    	
    	int cnt=0;
    	for (int i = 0; i < N; i++) {
			if(s.charAt(i)=='B') {
				if(cnt==0) bCnt++;
				cnt++;
			}
			else {
				cnt=0;
			}
		}
    	
    	cnt=0;
    	for (int i = 0; i < N; i++) {
			if(s.charAt(i)=='R') {
				if(cnt==0) rCnt++;
				cnt++;
			}
			else {
				cnt=0;
			}
		}
    	
		ans=Math.min(bCnt, rCnt);
		
		System.out.println(ans+1);
    }
}