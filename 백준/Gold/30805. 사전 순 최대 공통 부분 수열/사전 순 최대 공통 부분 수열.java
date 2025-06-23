import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M;
	static int[] A, B;
	static int[][] lcs;
	static PriorityQueue<int[]> q;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
//    	chk();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	A=new int[N+1];
    	q=new PriorityQueue<>((a,b)->{
    		if(a[0]==b[0]) return Integer.compare(a[1], b[1]);
    		return Integer.compare(b[0],a[0]);
    	});
    		
    	
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		int x=Integer.parseInt(st.nextToken());
    		A[i]=x;
    		q.add(new int[] {x,i});
		}
    	
    	M=Integer.parseInt(br.readLine());
    	B=new int[M+1];
    	lcs=new int[N+1][M+1];
    	
    	st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < M; i++) {
			int x=Integer.parseInt(st.nextToken());
			B[i]=x;
		}
    	
    }
      
    
    public static void proc() {
    	StringBuilder sb=new StringBuilder();
    	
    	int start=0;
    	int ans=0;
    	int aIdx=-1;
    	
    	while(!q.isEmpty()) {
    		int[] info=q.poll();
    		if(aIdx>info[1]) continue;
//    		System.out.println(info[0]+" "+info[1]+" "+start);
    		
    		for (int i = start; i < M; i++) {
				if(B[i]==info[0]) {
					aIdx=info[1];
					ans++;
					sb.append(info[0]+" ");
					start=i+1;
					break;
				}
			}
    	}
    	
    	System.out.println(ans);
    	System.out.println(sb);
    }
    
    public static void chk() {
    	for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.print(lcs[i][j]+" ");
			}
			System.out.println();
		}
    }
    
}