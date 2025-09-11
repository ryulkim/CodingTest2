import java.io.*;
import java.util.*;

public class Main {

	static String s;
	static int q, len;
	static int[][] cnt;
	
    public static void main(String[] args) throws Exception {
    	init();	
    	proc();
    }
    
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	s=br.readLine();
    	q=Integer.parseInt(br.readLine());
    	len=s.length();
    	cnt=new int[len][26];
    	
    	proc();
    	
    	for (int i = 0; i < q; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			char c=st.nextToken().charAt(0);
			int l=Integer.parseInt(st.nextToken());
			int r=Integer.parseInt(st.nextToken());
			int value=s.charAt(l)==c?1:0;
			
			sb.append(cnt[r][c-'a']-cnt[l][c-'a']+value).append('\n');
		}
    	
    	System.out.println(sb);
    }
    
    public static void proc() {
    	for (int i = 0; i < len; i++) {
    		int idx=s.charAt(i)-'a';
			cnt[i][idx]++;
		}
    	
    	for (int i = 0; i < 26; i++) {
			for (int j = 1; j < len; j++) {
				cnt[j][i]+=cnt[j-1][i];
			}
		}
    }
    
}
