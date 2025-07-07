import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int A, N, ans=10000;
	static String s;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	s=br.readLine();
    	N=s.length();
    	A=0;
    	for (int i = 0; i < N; i++) {
			if(s.charAt(i)=='a') {
				A++;
			}
		}
    }
    
    public static void proc() {
    	int cnt=0;
    	
    	for (int i = 0; i < A; i++) {
			if(s.charAt(i)=='b') {
				cnt++;
			}
		}
    	ans=Math.min(ans, cnt);
    	
    	int f=0,l=A%N;
    	while(f<N) {
    		if(s.charAt(f++)=='b') cnt--;
    		if(s.charAt(l)=='b') cnt++;
    		l=(l+1)%N;
    		ans=Math.min(ans, cnt);
    	}
    	System.out.println(ans);
    }
}