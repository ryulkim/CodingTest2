import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int N, K, ans=0;
	static boolean[] chk;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	N=Integer.parseInt(st.nextToken());
    	K=Integer.parseInt(st.nextToken());
    	chk=new boolean[N];
    	
    	String info=br.readLine();
    	
    	for (int i = 0; i < N; i++) {
    		if(info.charAt(i)=='H') continue;
			for (int j = Math.max(0, i-K); j < Math.min(N, i+K+1); j++) {
				if(info.charAt(j)=='H'&&!chk[j]) {
					ans++;
					chk[j]=true;
//					System.out.print(i+" ");
					break;
				}
			}
		}
    	
    	System.out.println(ans);
    	
    }
    
}