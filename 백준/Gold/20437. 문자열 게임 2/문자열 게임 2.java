import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	static int T, W, K;
	static String s;
	static int[] cnt;
	static HashMap<Character, ArrayList<Integer>> info;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    }

    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	T=Integer.parseInt(br.readLine());
    	cnt=new int[26];
    	
    	for (int testCase = 0; testCase < T; testCase++) {
    		Arrays.fill(cnt, 0);
			s=br.readLine();
			W=s.length();
			K=Integer.parseInt(br.readLine());
			info=new HashMap<>();
			
			pre();
			proc(sb);
			
		}
    	System.out.println(sb);
    }
    
    public static void pre() {
    	for (int i = 0; i < W; i++) {
			ArrayList<Integer> arr=info.getOrDefault(s.charAt(i), new ArrayList<>());
			arr.add(i);
			info.put(s.charAt(i), arr);
		}
    }
    
    public static void proc(StringBuilder sb) {
    	int three=1_000_000, four=-1;
    	
    	for(char c: info.keySet()) {
    		ArrayList<Integer> arr=info.get(c);
//    		System.out.println(c+" "+arr.size());
    		for (int i = 0; i <= arr.size()-K; i++) {
				int value=arr.get(i+K-1)-arr.get(i)+1;
				three=Math.min(three, value);
				four=Math.max(value, four);
			}
    	}
    	if(four==-1) {
    		sb.append(-1);
    	}
    	else {
    		sb.append(three+" "+four);
    	}
    	sb.append("\n");
    }
    
    public static int proc1() {
    	int f=0,l=0;
    	int three=1_000_000, four=-1;
    	cnt[change(l)]++;
    	
    	while(l<W) {
    		if(cnt[change(l)]==K) {
    			three=Math.min(three, l-f+1);
    			System.out.println(f+" "+l+" "+cnt[change(l)]);
    			if(s.charAt(f)==s.charAt(l)) {
    				four=Math.max(l-f+1, four);
    			}
    			cnt[change(f++)]--;
    		}
    		else {
    			if(++l<W) cnt[change(l)]++;
    		}
    	}
    	
    	return three;
    }

    public static int change(int idx) {
    	return s.charAt(idx)-'a';
    }
}