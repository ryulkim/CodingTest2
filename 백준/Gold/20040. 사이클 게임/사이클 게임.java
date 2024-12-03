import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;


public class Main {

    public static int N,M,ans=0;
    public static int[] parents;
    public static boolean flag=true;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        parents=new int[N];
        
        for (int i = 0; i < N; i++) {
			parents[i]=i;
		}
        
        for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			if(flag&&!union(a,b)) {
				ans=i+1;
				flag=false;
			}
		}
        
        System.out.println(ans);
        
    }
    
    private static boolean union(int a, int b) {
    	int aRoot=find(a);
    	int bRoot=find(b);
    	
    	if(aRoot==bRoot) {
    		return false;
    	}
    	parents[bRoot]=aRoot;
    	return true;
    }
    
    private static int find(int num) {
    	if(parents[num]==num) return num;
    	return parents[num]=find(parents[num]);
    }
}