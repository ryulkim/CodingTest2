import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static int T,N,M,X,top;
    public static int[] player, sortPlayer, tree, position;
    public static HashMap<Integer, Integer> rankMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        T=Integer.parseInt(br.readLine());
        
        for (int testCase = 0; testCase < T; testCase++) {
        	StringTokenizer st=new StringTokenizer(br.readLine());
        	N=Integer.parseInt(st.nextToken());
        	M=Integer.parseInt(st.nextToken());
        	
        	tree=new int[N+M+1];
        	position=new int[N+1];
        	top=M;
        	
        	for (int i = M+1; i <= N+M; i++) {
        		update(i,1);
        		position[i-M]=i;
			}
        	
        	st=new StringTokenizer(br.readLine());
        	for (int i = 0; i < M; i++) {
				X=Integer.parseInt(st.nextToken());
				sb.append(query(position[X])-1);
				sb.append(" ");
				
				update(position[X], -1);
				position[X]=top--;
				update(position[X], 1);
			}
        	sb.append("\n");
		}
        
        System.out.println(sb);
        
    }
    
    public static int query(int idx) {
    	int sum=0;
    	
    	while(idx>0) {
    		sum+=tree[idx];
    		idx-=(idx&-idx);
    	}
    	
    	return sum;
    }
    
    public static void update(int idx, int value) {
    	while(idx<tree.length) {
    		tree[idx]+=value;
    		idx+=(idx&-idx);
    	}
    }
}