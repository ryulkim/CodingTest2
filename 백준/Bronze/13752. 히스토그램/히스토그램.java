import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;

    public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		N=Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			K=Integer.parseInt(br.readLine());
			for (int j = 0; j < K; j++) {
				sb.append('=');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

}
