import java.io.*;
import java.util.*;

public class Main {

	static int N, K;
	static int[] arr;
	static boolean[] chk;
	
    public static void main(String[] args) throws Exception {
    	init();	
    }
    
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	K=Integer.parseInt(st.nextToken());
    	
    	arr=new int[N];
    	chk=new boolean[N];
    	
    	st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		arr[i]=Integer.parseInt(st.nextToken());
		}
    	
    	proc();
    	
//    	System.out.println(sb);
    }
    
    public static void proc() {
    	int f=0, l=0;
    	int max=0, len=0, cnt=0;
    	int first=0, last=0;
    	
    	while(l<N) {
    		if(arr[l]%2!=0) {
    			if(cnt<K) {
    				cnt++;
    				l++;
    			}
    			else {
    				if(arr[f]%2!=0) {
    					cnt--;
    				}
    				else {
    					len--;
    				}
    				f++;
    			}
    		}
    		else {
    			len++;
    			l++;
    			max=Math.max(len, max);
    		}
    	}
    	
    	System.out.println(max);
    	
    }
    
}
