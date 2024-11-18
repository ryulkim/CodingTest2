import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static long ans=0;
    public static long numbers[][];
    public static long[] totalA, totalB;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        numbers=new long[4002][4];
        totalA=new long[N*N];
        totalB=new long[N*N];
        
        for (int i = 0; i < N; i++) {
        	StringTokenizer st=new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                numbers[i][j]=Long.parseLong(st.nextToken());
            }
        }
        
        int idx=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
            	totalA[idx]=(numbers[i][0]+numbers[j][1]);
            	totalB[idx]=(numbers[i][2]+numbers[j][3]);
            	idx++;
            }
        }
        
        Arrays.sort(totalA);
        Arrays.sort(totalB);
        
        for (int i = 0; i < N*N; i++) {
			long num=-totalA[i];
			int lower=lowerBound(totalB, num);
			int upper=upperBound(totalB, num);
			ans+=(upper-lower);
		}
        
        System.out.println(ans);
    }
    
    private static int lowerBound(long[] array, long key) {
    	int low=0,high=array.length;
    	while(low<high) {
    		int mid=(low+high)/2;
    		if(array[mid]>=key) high=mid;
    		else low=mid+1;
    	}
    	return low;
    }
    
    private static int upperBound(long[] array, long key) {
    	int low=0,high=array.length;
    	while(low<high) {
    		int mid=(low+high)/2;
    		if(array[mid]>key) high=mid;
    		else low=mid+1;
    	}
    	return low;
    }
}