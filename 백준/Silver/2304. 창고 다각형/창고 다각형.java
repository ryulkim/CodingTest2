import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, L, H;
	static int[] arr;
	static ArrayList<int[]> infos;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	N=Integer.parseInt(br.readLine());
    	infos=new ArrayList<>();
    	
    	for (int i = 0; i < N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			L=Integer.parseInt(st.nextToken());
			H=Integer.parseInt(st.nextToken());
			infos.add(new int[] {L,H});
		}
    	
    	infos.sort((a,b)->Integer.compare(a[0],b[0]));
    	
    }
    
    public static void proc() {
    	int l=0,u=0;
    	int sum=0;
    	for (int[] info : infos) {
			if(info[1]>u) {
				sum+=(info[0]-l)*u;
				u=info[1];
				l=info[0];
			}
		}
    	if(u==infos.get(N-1)[1]) { //오름차순일 경우
    		sum+=u*(infos.get(N-1)[0]+1-l);
    		System.out.println(sum);
    		return;
    	}
    	
    	int r=0;u=0;
    	int sum1=0;
    	for (int i = N-1; i >= 0; i--) {
			int[] info=infos.get(i);
			if(info[1]>u) {
				sum1+=(r-info[0]-1)*u;
				u=info[1];
				r=info[0]+1;
			}
		}
    	if(u==infos.get(0)[1]) { //내림차순일 경우
    		sum1+=u*(r-infos.get(0)[0]);
    		System.out.println(sum1);
    		return;
    	}
    	
//    	sum+=(r-l)*u;
    	System.out.println(sum+sum1+(r-l)*u);
    	
    }
    

}