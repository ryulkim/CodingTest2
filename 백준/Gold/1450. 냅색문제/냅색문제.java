import java.io.*;
import java.util.*;

public class Main {
	
	static int N, C;
	static long ans;
	static int[] arr;
	static ArrayList<Long> temp, left, right;

    public static void main(String[] args) throws IOException {
		init();
		int mid=N/2;
		proc(0,mid,0,0,left);
		proc(mid+1,N-1,mid+1,0,right);
		ans=0;

		Object[] rightToArray=right.toArray();
		Arrays.sort(rightToArray);
		
		for (long num : left) {
			int idx=upperBound(rightToArray, C-num);
			if(idx<0) {
				ans-=(idx+1);
			}
			else {
				ans+=(idx+1);
			}
		}
		
		System.out.println(ans);
	}
    
    public static int upperBound(Object[] arr, long value) {
    	int f=0, l=arr.length-1;
    	int ans=0;
    	
    	while(f<=l) {
    		int mid=(f+l)/2;
    		
    		if((long) arr[mid]<=value) {
    			ans=mid;
    			f=mid+1;
    		}
    		else {
    			l=mid-1;
    		}
    	}
    	
    	return ans;
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		arr=new int[N];
		left=new ArrayList<>();
		right=new ArrayList<>();
		
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
    }
    
    public static void proc(int s, int e, int i, long sum, ArrayList<Long> tmp) {
    	if(i>e) {
    		if(sum<=C) tmp.add(sum);
    		return;
    	}
    	
    	proc(s,e,i+1,sum,tmp);
    	proc(s,e,i+1,sum+arr[i],tmp);
    }

}
