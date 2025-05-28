import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class Main {
	
	static int A, N;
	static ArrayList<Integer>[] info;
	static int[] inBound;
	static PriorityQueue<Integer> q;
	

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	info=new ArrayList[8];
    	inBound=new int[8];
    	q=new PriorityQueue<Integer>();
    	
    	for (int i = 1; i <= 7; i++) {
			info[i]=new ArrayList<>();
		}
    	
    	info[1].add(7);
    	info[1].add(4);
    	info[2].add(1);
    	info[3].add(4);
    	info[3].add(5);
    	
    	inBound[7]++;
    	inBound[4]+=2;
    	inBound[1]++;
    	inBound[5]++;
    	
    	while(true) {
    		int prev=Integer.parseInt(br.readLine());
    		int nxt=Integer.parseInt(br.readLine());
    		
    		if(prev==0&&nxt==0) break;
    		
    		info[prev].add(nxt);
    		inBound[nxt]++;
    		
    	}
    	
    	for (int i = 1; i <= 7; i++) {
			if(inBound[i]==0) q.add(i);
		}
    }
    
    public static void proc() {
    	int cnt=0;
    	StringBuilder sb=new StringBuilder();
    	
    	while(!q.isEmpty()) {
    		int num=q.poll();
    		cnt++;
    		sb.append(num+" ");
    		
    		for (int i = 0; i < info[num].size(); i++) {
				int nxt=info[num].get(i);
				
				if(--inBound[nxt]==0) q.add(nxt);
			}
    		
    	}
    	
    	if(cnt!=7) {
    		System.out.println("Cannot complete these tasks. Going to bed.");
    	}
    	else {
    		System.out.println(sb);
    	}
    }
    
    
}