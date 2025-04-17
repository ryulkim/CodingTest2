import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, x;
	static ArrayList<Integer> arr;
	static int[] ans;
	static Stack<int[]> stk;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
        
    	N=Integer.parseInt(br.readLine());
    	arr=new ArrayList<>();
    	ans=new int[N];
    	stk=new Stack<>();//숫자, 인덱스
    	
    	Arrays.fill(ans, -1);
    	
    	StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	x=Integer.parseInt(st.nextToken());
        	arr.add(x);
		}
        
        for (int i = 0; i < N; i++) {
        	x=arr.get(i);
        	while(!stk.isEmpty()&&x>stk.peek()[0]) {
        		ans[stk.peek()[1]]=x;
        		stk.pop();
        	}
        	stk.add(new int[] {x,i});
		}
        
        for (int i = 0; i < N; i++) {
			sb.append(ans[i]);
			sb.append(" ");
		}
        System.out.println(sb);
    }

    
}
