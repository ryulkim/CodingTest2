import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] arr;
	static int N, M, ans=0; 
	static boolean[] visit;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
        
    	for (int i = 1; i <= N; i++) {
    		if(!visit[i]) proc(i);
		}
    	
        
        System.out.println(ans);
        
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	arr=new ArrayList[N+1];
    	visit=new boolean[N+1];
    	
    	for (int i = 0; i <= N; i++) {
			arr[i]=new ArrayList<Integer>();
		}
    	
    	for (int i = 0; i < M; i++) {
    		st=new StringTokenizer(br.readLine());
    		int a=Integer.parseInt(st.nextToken());
    		int b=Integer.parseInt(st.nextToken());
    		
    		arr[a].add(b);
    		arr[b].add(a);
		}
    }
    
    public static void proc(int start) {
    	ArrayDeque<Integer> q=new ArrayDeque<Integer>();
    	q.add(start);
    	ans++;
    	
    	while(!q.isEmpty()) {
    		int num=q.poll();
    		
    		for (int i = 0; i < arr[num].size(); i++) {
    			int nxt=arr[num].get(i);
    			
				if(visit[nxt]) {
					continue;
				}
				
				visit[nxt]=true;
				q.add(nxt);
			}
    	}
    }
    
    
}