import java.io.*;
import java.util.*;

public class Main {

    static int T, N, M;
    static HashSet<Integer> one;

    public static void main(String[] args) throws Exception {
        init();
    }

    public static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        
        for (int testCase = 0; testCase < T; testCase++) {
        	N = Integer.parseInt(br.readLine());
        	one=new HashSet<>();
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int i = 1; i <= N; i++) {
        		one.add(Integer.parseInt(st.nextToken()));
        	}
        	
        	M = Integer.parseInt(br.readLine());        
        	st = new StringTokenizer(br.readLine());
        	for (int i = 1; i <= M; i++) {
        		sb.append(one.contains(Integer.parseInt(st.nextToken()))?1:0);
        		sb.append("\n");
        	}
        }
			
        System.out.println(sb);
    }
}
