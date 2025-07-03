import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;


public class Main {

	static int N, ans=0, len;
	static int[] basic;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
//    	proc();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(br.readLine());
    	String first=br.readLine();
    	basic=proc(first);
    	len=first.length();
    	
    	for (int i = 1; i < N; i++) {
			String s=br.readLine();
			int[] cnt=proc(s);
			if(chk(cnt)) {
				ans++;
			}
		}
    	
    	System.out.println(ans);
    	
    }
    
    public static int[] proc(String s) {
    	int[] cnt=new int[26];
    	
    	for (int i = 0; i < s.length(); i++) {
    		int idx=s.charAt(i)-'A';
    		cnt[idx]++;
		}
    	
    	return cnt;
    }
    
    public static boolean chk(int[] cnt) {
    	
    	boolean flag=true;
    	int status=0;
    	
    	for (int i = 0; i < 26; i++) {
			if(cnt[i]!=basic[i]) {
				if(Math.abs(cnt[i]-basic[i])==1) {
					if(flag) {
						status=cnt[i]-basic[i];
						flag=false;
					}
					else {
						if(status+cnt[i]-basic[i]==0) {
							status=0;
						}
						else return false;
					}
				}
				else {
					return false;
				}
			}
		}
    	
    	return true;
    }
  
}