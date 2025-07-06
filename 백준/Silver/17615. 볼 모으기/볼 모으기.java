import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
	

public class Main {
	
	static int N, R=0, B=0, ans=1000_000_000;
	static String s;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    	System.out.println(ans);
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	s=br.readLine();
    	
    	for (int i = 0; i < N; i++) {
			if(s.charAt(i)=='R') R++;
			else B++;
		}
    }
    
    public static void proc() {
    	frontRed();
    	backRed();
    	frontBlue();
    	backBlue();
    }
    
    public static void frontRed() {
    	int cnt=0;
    	for (int i = 0; i < N; i++) {
			if(s.charAt(i)=='B') break;
			cnt++;
		}
    	ans=Math.min(ans, R-cnt);
    }
    
    public static void backRed() {
    	int cnt=0;
    	for (int i = N-1; i >= 0; i--) {
			if(s.charAt(i)=='B') break;
			cnt++;
		}
    	ans=Math.min(ans, R-cnt);
    }
    
    public static void frontBlue() {
    	int cnt=0;
    	for (int i = 0; i < N; i++) {
			if(s.charAt(i)=='R') break;
			cnt++;
		}
    	ans=Math.min(ans, B-cnt);
    }
    
    public static void backBlue() {
    	int cnt=0;
    	for (int i = N-1; i >= 0; i--) {
			if(s.charAt(i)=='R') break;
			cnt++;
		}
    	ans=Math.min(ans, B-cnt);
    }
    
}