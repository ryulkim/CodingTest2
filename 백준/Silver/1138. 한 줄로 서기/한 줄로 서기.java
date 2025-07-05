import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] info, ans, idx;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    	print();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	N=Integer.parseInt(br.readLine());
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	ans=new int[N];
    	info=new int[N];
    	idx=new int[N];
    	
    	for (int i = 0; i < N; i++) {
			info[i]=Integer.parseInt(st.nextToken());
		}
    	
    }
    
    public static void proc() {
    	for (int i = 0; i < N; i++) {
    		int cnt=0;
			for (int j = 0; j < N; j++) {
				if(cnt==info[i]&&ans[j]==0) {
					ans[j]=i+1;
					break;
				}
				else if(ans[j]==0) {
					cnt++;
				}
			}
		}
    }
    
    public static void print() {
    	StringBuilder sb=new StringBuilder();
    	for (int i = 0; i < N; i++) {
			sb.append(ans[i]+" ");
		}
    	System.out.println(sb);
    }
}