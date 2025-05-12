import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static int T, N;
	static String[] arr;
	static int f, l;
	static boolean isReverse, error;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
//    	chk();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	T=Integer.parseInt(br.readLine());
    	
    	for (int testCase = 0; testCase < T; testCase++) {
			String cmd=br.readLine();
			N=Integer.parseInt(br.readLine());
			String s=br.readLine();
			s=s.replace("[", "").replace("]", "");
			arr = s.equals("") ? new String[0] : s.split(",");
//			chk();
			f=0; l=N-1; isReverse=false; error=false;
			
			for (int i = 0; i < cmd.length(); i++) {
//				System.out.println(cmd.charAt(i));
				switch(cmd.charAt(i)) {
					case 'R':
						reverse();
						break;
					case 'D':
						if(!discard()) {
							error=true;
							break;
						}
						break;
					}
			}
			
			print();
		}
    }
    
    public static void print() {
    	if(error) {
    		System.out.println("error");
    	}
    	else if(l<f) {
    		System.out.println("[]");
    	}
    	else {
    		System.out.print("[");
    		if(isReverse) {
    			for (int i = l; i > f; i--) {
					System.out.print(arr[i]+",");
				}
    			System.out.println(arr[f]+"]");
    		}
    		else {
    			for (int i = f; i < l; i++) {
					System.out.print(arr[i]+",");
				}
    			System.out.println(arr[l]+"]");
    		}
    		
    	}
    }
    
    public static void chk() {
    	for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]+" ");
		}
    	System.out.println("\n");
    }
    
    public static void reverse() {
    	isReverse=!isReverse;
    }
    
    public static boolean discard() {
    	if(f>l) return false;
    	if(f>=N || l<0) return false;
    	if(isReverse) {
    		l--;
    	}
    	else {
    		f++;
    	}
    	return true;
    }
    
    public static void proc() {
    	
    }
   
    
}