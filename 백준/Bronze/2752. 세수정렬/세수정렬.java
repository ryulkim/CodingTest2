import java.io.*;
import java.util.*;

public class Main {

	static int a,b,c;
	static int[] arr;
	
    public static void main(String[] args) throws Exception {
    	init();
    }

    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	StringBuilder sb=new StringBuilder();
    	a=Integer.parseInt(st.nextToken());
    	b=Integer.parseInt(st.nextToken());
    	c=Integer.parseInt(st.nextToken());
    	arr= new int[]{a,b,c};
    	
    	Arrays.sort(arr);
    	
    	System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);
    }
    
   
}
