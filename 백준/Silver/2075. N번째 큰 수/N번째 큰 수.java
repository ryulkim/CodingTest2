import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] arr;
	static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	N=Integer.parseInt(br.readLine());
    	pq=new PriorityQueue<>((a,b)->Integer.compare(b[0], a[0]));
    	arr=new int[N][N];
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		for (int j = 0; j < N; j++) {
    			int x=Integer.parseInt(st.nextToken());
    			arr[i][j]=x;
    			pq.add(new int[] {x, i, j});
			}
		}
    	
    }
    
    public static void proc() {
    	while(N-->1) {
    		pq.poll();
    	}
    	System.out.println(pq.poll()[0]);
    }

}