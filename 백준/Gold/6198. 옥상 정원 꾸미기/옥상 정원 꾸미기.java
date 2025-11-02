import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] arr;
	static ArrayDeque<int[]> stack;

    public static void main(String[] args) throws IOException {
    	init();
    	proc();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N];
    	stack=new ArrayDeque<>();
    	for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
    }
    
    public static void proc() {
    	long ans=0;
    	for (int i = N-1; i >= 0; i--) {
			int num=arr[i];
			int cnt=1;
			while(!stack.isEmpty()&&stack.peek()[0]<num) {
				int[] info=stack.pop();
				cnt+=info[1];
				ans+=info[1];
			}
			if(!stack.isEmpty()&&stack.peek()[0]==num) {
				cnt+=stack.pop()[1];
			}
			stack.push(new int[] {num, cnt});
		}
    	
    	System.out.println(ans);
    }
}
