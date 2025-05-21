import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;


class Objects implements Comparable<Objects>{
	public int[] arr;
	
	public Objects(int[] arr) {
		super();
		this.arr = arr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(arr);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Objects other = (Objects) obj;
		return Arrays.equals(arr, other.arr);
	}

	public int[] getArr() {
		return arr;
	}


	@Override
	public int compareTo(Objects o) {
		return Arrays.compare(this.arr, o.arr);
	}
	
}

public class Main {
	
	static int N, M;
	static int[] arr, ans;
	static TreeSet<Objects> hs;


    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc(0,0);
    	
    	StringBuilder sb=new StringBuilder();
    	for (Objects obj : hs) {
			int[] temp=obj.getArr();
			for (int num : temp) {
				sb.append(num+" ");
			}
			sb.append("\n");
		}
    	System.out.println(sb);
    	

    	
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	arr=new int[N];
    	ans=new int[M];
    	hs=new TreeSet<Objects>();
    	
    	st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}

    	Arrays.sort(arr);
    }
    
    public static void proc(int depth, int start) {
    	if(depth==M) {
    		int[] temp=new int[M];
    		
    		for (int i = 0; i < M; i++) {
    			temp[i]=ans[i];
			}
    		
    		hs.add(new Objects(temp));
    		return;
    	}
    	
    	for (int i = start; i < N; i++) {
    		ans[depth]=arr[i];
//    		System.out.println(depth+": "+arr[i]);
			proc(depth+1, i);
		}
    }
    
}