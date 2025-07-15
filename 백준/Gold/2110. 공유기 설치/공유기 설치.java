import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N, C, ans=0;
	static ArrayList<Integer> houses;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	binarySearch();
    	System.out.println(ans);
    }
    
	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	C=Integer.parseInt(st.nextToken());
    	houses=new ArrayList<>();
    	
    	for (int i = 0; i < N; i++) {
			houses.add(Integer.parseInt(br.readLine()));
		}
    	
    	houses.sort((a,b)->Integer.compare(a, b));
	}
	
	public static void binarySearch() {
		int f=1, l=houses.get(N-1);
		int mid=(f+l)/2;
		
		while(f<l) {
			mid=(f+l)/2;
			
			int cnt=1;
			int select=houses.get(0);
			int min=1000_000_000;
			for (int i = 1; i < N; i++) {
				int diff=houses.get(i)-select;
				if(diff>=mid) {
					select=houses.get(i);
					cnt++;
					min=Math.min(min, diff);
				}
			}
			
			if(cnt>=C) {
				ans=Math.max(ans, min);
				f=mid+1;
			}
			else {
				l=mid;
			}
		}
	}
	
}
