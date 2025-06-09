import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	static int N, ans=0;
	static int[][] infos;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc(0,0);
    	System.out.println(ans);
    }
    
    
    public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	infos=new int[N][2];
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		int T=Integer.parseInt(st.nextToken());
    		int P=Integer.parseInt(st.nextToken());
    		
			infos[i][0]=T;
			infos[i][1]=P;
		}
    }
    
    public static void proc(int start, int sum) {
    	if(start>N) {
    		return;
    	}
    	ans=Math.max(ans, sum);
    	if(start==N) return;
    	// 이 상담을 할 때
    	proc(start+infos[start][0], sum+infos[start][1]);
    	// 이 상담을 안 할 때
    	proc(start+1, sum);
    }
}