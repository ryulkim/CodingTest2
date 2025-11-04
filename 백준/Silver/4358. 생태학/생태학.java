import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	
	static int num;
	static TreeMap<String, Integer> tm;

    public static void main(String[] args) throws IOException {
    	init();
    	proc();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	tm=new TreeMap<>();
    	
    	num=0;
    	while(true) {
    		String s=br.readLine();
    		if(s==null||s.isEmpty()||s.isBlank()) {
    			break;
    		}
    		
    		tm.put(s, tm.getOrDefault(s, 0)+1);
    		num++;
    	}
    }
    
    public static void proc() {
    	StringBuilder sb=new StringBuilder();
    	
    	for (Entry<String, Integer> entry : tm.entrySet()) {
			sb.append(entry.getKey()).append(" ")
			.append(String.format("%.4f", (double) entry.getValue()*100/num))
			.append('\n');
		}
    	
    	System.out.println(sb);
    }
}
