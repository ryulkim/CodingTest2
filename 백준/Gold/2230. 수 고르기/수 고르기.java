import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {
	
	static int N, M;
	static long ans=2000_000_001;
	static long[] arr;
	static TreeMap<Long, Integer> tm;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    	System.out.println(ans);
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	arr=new long[N];
    	tm=new TreeMap<>();
    	
    	for (int i = 0; i < N; i++) {
			long num=Long.parseLong(br.readLine());
			arr[i]=num;
			tm.put(num, tm.getOrDefault(num, 0)+1);
		}
    	
    	Arrays.sort(arr);
    }

    public static void proc() {
//    	int start=0, end=start+1;
    	
    	for (int i = 0; i < N; i++) {
			Long num=tm.ceilingKey(arr[i]+M);
			if(num!=null) {
				ans=Math.min(ans, num-arr[i]);
			}
		}
    }
    
}