import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node {
	String s;
	int cnt;
	
	public Node(String s, int cnt) {
		super();
		this.s = s;
		this.cnt = cnt;
	}
}

public class Main {

	static int N, M, ans=0, max=0;
	static int[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    	System.out.println(ans);
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N];
    	
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
			int num=Integer.parseInt(st.nextToken());
			arr[i]=num;
			max=Math.max(max, num);
		}
    	
    	M=Integer.parseInt(br.readLine());
    }
    
    public static void proc() {
    	int f=0,l=max;
    	
    	while(f<=l) {
    		int mid=(f+l)/2;
    		int flag=chk(mid);
    		
    		if(flag==0) {
    			ans=Math.max(ans, mid);
    			break;
    		}
    		else if(flag>0) {
    			ans=Math.max(ans, mid);
    			f=mid+1;
    		}
    		else {
    			l=mid-1;
    		}
    		
    	}
    }
    
    public static int chk(int value) {
    	int sum=0;
    	for (int i = 0; i < N; i++) {
			if(arr[i]<value) {
				sum+=arr[i];
			}
			else {
				sum+=value;
			}
		}
    	
    	if(sum==M) return 0;
    	else if(sum>M) return -1;
    	else return 1;
    }

}