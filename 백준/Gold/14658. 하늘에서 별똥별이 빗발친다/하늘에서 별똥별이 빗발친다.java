import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M, L, K;
	static ArrayList<int[]> arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
		proc();
    }

	public static void init() throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		arr=new ArrayList<>();
		
		for (int i = 0; i < K; i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			arr.add(new int[] {x,y});
		}
		
	}
	
	public static void proc() {
    int max = 0;
    
    for (int i = 0; i < K; i++) {
        int sr = arr.get(i)[0];
        int er = sr + L;
        for (int j = 0; j < K; j++) {
            int sc = arr.get(j)[1];
            int ec = sc + L;
            int cnt = 0;
            
            for (int k = 0; k < K; k++) {
                int[] next = arr.get(k);
                if (sr <= next[0] && next[0] <= er &&
                    sc <= next[1] && next[1] <= ec) {
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
        }
    }
    System.out.println(K - max);
}
}
