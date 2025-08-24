import java.io.*;
import java.util.*;

public class Main {

	static int N, L, P;
	static LinkedList<Character> arr;

    public static void main(String[] args) throws Exception {
    	init();
//    	proc();
    }

    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(br.readLine());
    	StringBuilder sb=new StringBuilder();
    	
    	for (int i = 0; i < N; i++) {
			String s=br.readLine();
			int len=s.length();
			P=0; L=0;
			arr=new LinkedList<>();
			ListIterator<Character> it=arr.listIterator();
			
			for (int j = 0; j < len; j++) {
				char c=s.charAt(j);
				
				if(c=='<') {
					if(it.hasPrevious()) it.previous();
				}
				else if(c=='>') {
					if(it.hasNext()) it.next();
				}
				else if(c=='-') {
					if(it.hasPrevious()) {
						it.previous();
						it.remove();
					}
				}
				else {
					it.add(c);
				}
			}
			
			for (char num : arr) {
//				System.out.print(num);
				sb.append(num);
			}
			
			sb.append("\n");
		}        
    	System.out.println(sb);
    }
    
    public static void proc() {
    	
    }
    
}
