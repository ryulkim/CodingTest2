import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	static HashSet<Integer> hs;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    }
    

	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int N=Integer.parseInt(br.readLine());
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	StringBuilder sb=new StringBuilder();
    	hs=new HashSet<>();
    	
    	for (int i = 0; i < N; i++) {
			hs.add(Integer.parseInt(st.nextToken()));
		}
    	
    	int M=Integer.parseInt(br.readLine());
    	st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < M; i++) {
    		sb.append(hs.contains(Integer.parseInt(st.nextToken()))?1:0);
    		sb.append(" ");
		}
    	
    	System.out.println(sb);
    }
	
}