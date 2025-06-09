import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

	static int N, ans=1000_000_000;
	static int[][] infos;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc(0,new ArrayList<Integer>(), new ArrayList<Integer>());
    	System.out.println(ans);
    }
    
    
    public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	infos=new int[N][N];
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				infos[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    	
    }
    
    public static void proc(int idx, ArrayList<Integer> start, ArrayList<Integer> link) {
    	if(idx==N) {
    		if(start.size()==N/2) {
    			int v1=cal(start);
    			int v2=cal(link);
//    			System.out.println(v1+" "+v2);
    			ans=Math.min(ans, Math.abs(v2-v1));
    		}
    		return;
    	}
    	start.add(idx);
    	proc(idx+1, start, link);
    	start.remove(start.size()-1);
    	
    	link.add(idx);
    	proc(idx+1, start, link);
    	link.remove(link.size()-1);
    }
    
    public static int cal(ArrayList<Integer> arr) {
    	int sum=0;
    	int sz=arr.size();
    	
    	for (int i = 0; i < sz; i++) {
    		int num1=arr.get(i);
			for (int j = 0; j < sz; j++) {
				int num2=arr.get(j);
				if(i==j) continue;
				sum+=infos[num1][num2];
			}
		}
    	
    	return sum;
    }
}