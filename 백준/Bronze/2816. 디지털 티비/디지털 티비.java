import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
	
	static int N, oIdx, tIdx;
	static ArrayList<String> info;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    }

	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	info=new ArrayList<>();
    	
    	for (int i = 0; i < N; i++) {
			String s=br.readLine();
			info.add(s);
		}
    }
	
	
    public static void proc() {
    	StringBuilder sb=new StringBuilder();
    	int point=0;
    	
    	while(!info.get(point).equals("KBS1")) {
    		point++;
    		sb.append(1);
    	}
    	
    	while(point>0) {
    		sb.append(4);
//    		System.out.println(info.get(point));
    		point--;
    	}
    	
    	if(!info.get(0).equals("KBS1") && !info.get(0).equals("KBS2")) sb.append(1);
    	
    	while(!info.get(point).equals("KBS2")) {
    		point++;
    		if(info.get(point).equals("KBS1")) continue;
    		sb.append(1);
    	}
    	
    	while(point>0) {
    		point--;
    		if(info.get(point).equals("KBS1")) continue;
    		sb.append(4);
    	}
    	
    	System.out.println(sb);
    }

    
}