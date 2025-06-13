import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	static int N, M, H, ans=-1;
	static boolean[][] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
//    	init();
//    	print();
    	proc();
    }

	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	H=Integer.parseInt(st.nextToken());
    	arr=new boolean[100][100];
    	
    	arr[12][12]=true;
    	arr[12][13]=true;
    	arr[13][12]=true;
    }
    
    public static void proc() {
    	String s="NFC West       W   L  T\n"
    			+ "-----------------------\n"
    			+ "Seattle        13  3  0\n"
    			+ "San Francisco  12  4  0\n"
    			+ "Arizona        10  6  0\n"
    			+ "St. Louis      7   9  0\n"
    			+ "\n"
    			+ "NFC North      W   L  T\n"
    			+ "-----------------------\n"
    			+ "Green Bay      8   7  1\n"
    			+ "Chicago        8   8  0\n"
    			+ "Detroit        7   9  0\n"
    			+ "Minnesota      5  10  1";
    	System.out.println(s);
    }
}