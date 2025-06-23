import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, people;
	static int[] switches;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    }

	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	switches=new int[N+1];
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	for (int i = 1; i <= N; i++) {
			switches[i]=Integer.parseInt(st.nextToken());
		}
    	people=Integer.parseInt(br.readLine());
    	for (int i = 0; i < people; i++) {
			st=new StringTokenizer(br.readLine());
			int sex=Integer.parseInt(st.nextToken());
			int num=Integer.parseInt(st.nextToken());
			proc(sex, num);
		}
    	print();
    }
	
	public static void print() {
		for (int i = 1; i <= N; i++) {
			System.out.print(switches[i]+" ");
			if(i%20==0) {
				System.out.println();
			}
		}
	}
	
	
    public static void proc(int sex, int num) {
    	if(sex==1) {
    		man(num);
    	}
    	else {
    		woman(num);
    	}
    }
    
    public static void man(int num) {
    	for (int i = num; i <= N; i+=num) {
			switches[i]=(switches[i]+1)%2;
		}
    }
    
    public static void woman(int num) {
    	switches[num]=(switches[num]+1)%2;
    	int f=num-1, l=num+1;
    	while(f>0&&l<=N) {
    		if(switches[f]!=switches[l]) {
    			break;
    		}
    		int value=(switches[f]+1)%2;
    		switches[f--]=value;
    		switches[l++]=value;
    	}
    }
}