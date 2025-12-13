import java.io.*;
import java.util.*;


class Galary{
	int num, cnt, idx;

	public Galary(int num, int cnt, int idx) {
		super();
		this.num = num;
		this.cnt = cnt;
		this.idx = idx;
	}
}

public class Main {
	
	static int N, M, numbering=1;
	static Galary[] arr;
//	static PriorityQueue<Galary> pq;
	static PriorityQueue<Galary> post;
	
	
    public static void main(String[] args) throws IOException {
    	init();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	M=Integer.parseInt(br.readLine());
    	arr=new Galary[102];
//    	pq=new PriorityQueue<>((a,b)->Integer.compare(a.cnt, b.cnt));
    	post=new PriorityQueue<>((a,b)->{
    		if(a.cnt==b.cnt) {
    			return Integer.compare(a.idx, b.idx);
    		}
    		return Integer.compare(a.cnt, b.cnt);
    	});
    	
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < M; i++) {
			int num=Integer.parseInt(st.nextToken());
			if(arr[num]==null) {
				Galary newNode=new Galary(num, 1, numbering++);
				arr[num]=newNode;
				if(post.size()<N) {
					post.add(newNode);
				}
				else {
					Galary node = post.poll();
					arr[node.num]=null;
					post.add(newNode);
				}
			}
			else {
				Galary node=arr[num];
				node.cnt++;
				post.remove(node);
				post.add(node);
			}
		}
    	
    	ArrayList<Galary> ans=new ArrayList<>();
    	while(!post.isEmpty()) {
    		ans.add(post.poll());
    	}
    	ans.sort((a,b)->Integer.compare(a.num, b.num));
    	
    	for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i).num+" ");
		}
    	System.out.println();
    }
    
    public static void proc() {
    	
    }
  
}