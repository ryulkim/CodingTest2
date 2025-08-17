import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i++) {
			String s=br.readLine();
			StringBuilder sb = new StringBuilder();
			
			for (int j = 0; j < M; j++) {
				sb.append(s.charAt(j));
			}
			
			sb.reverse();
			System.out.println(sb);
		}
    }
}
