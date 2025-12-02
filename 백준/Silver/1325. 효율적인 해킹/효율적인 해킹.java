import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static ArrayList<Integer>[] arr;
	static int[] area, cnt, min;
	static int[][] chk;
	
    public static void main(String[] args) throws IOException {
    	init();
    	proc();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	arr=new ArrayList[N+1];
    	cnt=new int[N+1];
    	min=new int[N+1];
    	Arrays.fill(min, 100_000);
    	
    	for (int i = 0; i <= N; i++) {
			arr[i]=new ArrayList<>();
		}
    	
    	for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int A=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
//			arr[A].add(B);
			arr[B].add(A);			
		}
    }
    
    public static void proc() {
    	int num=0, ans=0;
    	PriorityQueue<Integer> pq=new PriorityQueue<>();

    	for (int i = 1; i <= N; i++) {
			bfs(i, ++num);
			ans=Math.max(ans, cnt[i]);
		}
    	
    	for (int i = 1; i <= num; i++) {
			if(ans==cnt[i]) {
				pq.add(i);
			}
		}
    	
    	while(!pq.isEmpty()) {
    		System.out.print(pq.poll()+" ");
    	}
    }
    
    public static void bfs(int cur, int num) {
    	ArrayDeque<Integer> q=new ArrayDeque<>();
    	q.add(cur);
    	area=new int[N+1];
    	area[cur]=num;
    	cnt[num]++;
    	min[num]=cur;
    	
    	while(!q.isEmpty()) {
    		cur=q.poll();
    		
    		for (int nxt : arr[cur]) {
				if(area[nxt]!=0) {
					continue;
				}
				area[nxt]=num;
				cnt[num]++;
				min[num]=Math.min(min[num], nxt);
				q.add(nxt);
			}
    	}
    }
}