import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


/*
 * 모든 경우의 수 - 1
 * 
 */

public class Main {
	
	static int T, N, sum=0;
	static HashMap<String, Integer> clothesIdx;
	static int[] cnt;
	static int[] status;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	T=Integer.parseInt(br.readLine());
    	clothesIdx=new HashMap<String, Integer>();

    	for (int i = 0; i < T; i++) {
    		clothesIdx.clear();
    		N=Integer.parseInt(br.readLine());
    		sum=0;
    		int seq=0;
        	cnt=new int[30];
        	status=new int[30];
    		
			for (int j = 0; j < N; j++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				st.nextToken();
				String type=st.nextToken();
				
				
				if(clothesIdx.containsKey(type)) {
					int idx=clothesIdx.get(type);
					cnt[idx]++;
//					System.out.println(idx+": "+cnt[idx]);
				}
				else {
					cnt[seq]++;
					clothesIdx.put(type, seq++);
//					System.out.println(seq+": "+cnt[seq]);
				}
			}
			
			proc();
			

		}
    }
    
//    public static void proc(int depth) {
//    	if(depth==clothesIdx.size()) {
//    		int value=1;
//    		for (int i = 0; i < clothesIdx.size(); i++) {
//				value*=status[i];
//			}
////    		System.out.println("value: "+value);
//    		sum+=value;
//    		return;
//    	}
//    	status[depth]=1;
//    	proc(depth+1);
//    	status[depth]=cnt[depth];
//    	proc(depth+1);
//    }
    
    public static void proc() {
    	int value=1;
    	for (int i = 0; i < clothesIdx.size(); i++) {
			value*=(cnt[i]+1);
		}
		System.out.println(value-1);
    }
    
    

    
    
   
}