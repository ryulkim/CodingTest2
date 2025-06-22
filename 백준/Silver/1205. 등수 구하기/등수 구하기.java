import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, taesu, P;
	static int[] arr;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    }

	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	taesu=Integer.parseInt(st.nextToken());
    	P=Integer.parseInt(st.nextToken());
    	arr=new int[N];
    	
    	if(N>0) {
    		st=new StringTokenizer(br.readLine());
        	for (int i = 0; i < N; i++) {
    			arr[i]=Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	
    	Arrays.sort(arr);
    }
	
	
    public static void proc() {
    	int cnt=0;
    	int rank=1;
    	int num=-1;
    	boolean chk=false;
    	
    	for (int i = N-1; i >= 0; i--) {
			if(arr[i]>taesu) {
				rank++;
			}
			else if(arr[i]<taesu) {
				if(N-i<=P) {
					System.out.println(rank);
				}
				else System.out.println(-1);
				return;
			}
		}
    	
    	if(N<P) {
    		System.out.println(rank);
    	}
    	else {
    		System.out.println(-1);
    	}
    }
}