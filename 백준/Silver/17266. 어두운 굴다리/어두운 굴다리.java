import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static boolean[] road;
	static ArrayList<Integer> lamp;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	binary();
//    	chk();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	road=new boolean[N+1];
    	M=Integer.parseInt(br.readLine());
    	lamp=new ArrayList<>();
    	
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < M; i++) {
			int x=Integer.parseInt(st.nextToken());
			lamp.add(x);
		}
    }
     
    public static boolean proc(int h) {
    	int end=0;
    	for(int num : lamp) {
    		if(num-h>end) return false;
    		end=num+h;
    	}
    	if(end<N) return false;
    	return true;
    }
    
    public static void binary() {
    	int start=0;
    	int end=100_000;
    	int mid=(start+end)/2;
    	int ans=100_000;
    	
    	while(start<=end) {
    		mid=(start+end)/2;
    		
    		if(proc(mid)) {
    			end=mid-1;
    			ans=Math.min(mid, ans);
//    			System.out.println(ans);
    		}
    		else {
    			start=mid+1;
    		}
    	}
    	
    	System.out.println(ans);
    }
    
}