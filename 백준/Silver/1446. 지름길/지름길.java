import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, D;
	static int[] djik;
	static HashMap<Integer, ArrayList<int[]>> m;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	D=Integer.parseInt(st.nextToken());
    	m=new HashMap<Integer, ArrayList<int[]>>();
    	djik=new int[10001];
    	Arrays.fill(djik, 1000_000_000);
    	
    	for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int l=Integer.parseInt(st.nextToken());
			ArrayList<int[]> arr=m.getOrDefault(s, new ArrayList<int[]>());
			arr.add(new int[] {d,l});
			m.put(s, arr);
		}
    }
    
    public static void proc() {
    	PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->{
    		if(a[0]==b[0]) return Integer.compare(a[1], b[1]);
    		return Integer.compare(a[0], b[0]);
    	});
    	pq.add(new int[] {0,0});
    	djik[0]=0;
    	
    	while(!pq.isEmpty()) {
    		int[] info=pq.poll();
    		if(info[0]>D) continue;
    		if(info[1]!=djik[info[0]]) continue;
    		if(info[0]==D) break;
    		
    		pq.add(new int[] {info[0]+1, info[1]+1}); // 한 칸씩만 갈 때
    		djik[info[0]+1]=Math.min(djik[info[0]+1], info[1]+1);
    		ArrayList<int[]> arr=m.get(info[0]);
    		if(arr!=null) {
    			for (int[] temp : arr) {
//    				System.out.println(temp[0]+" "+temp[1]);
    				
    				int v=info[1]+temp[1];
    				if(v<djik[temp[0]]) {
    					pq.add(new int[] {temp[0], v});
    					djik[temp[0]]=v;
    				}
					
				}
    		}
    	}
    	
    	System.out.println(djik[D]);
    }
    
}