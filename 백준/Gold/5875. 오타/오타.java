import java.io.*;
import java.util.*;

public class Main {

	static String s;
	static int N;
	static int[] cnt, rCnt;
	
    public static void main(String[] args) throws Exception {
    	init();
    	System.out.println(proc());
    }
        
    public static void init() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	s=br.readLine();
    	N=s.length();
    	cnt=new int[N+1];
    	rCnt=new int[N+1];
    	
    	for (int i = 1; i <= N; i++) {
			if(s.charAt(i-1)=='(') {
				cnt[i]=cnt[i-1]+1;
			}
			else {
				cnt[i]=cnt[i-1]-1;
			}
		}
    	

    	for (int i = N-1; i >= 0; i--) {
			if(s.charAt(i)=='(') {
				rCnt[i]=rCnt[i+1]-1;
			}
			else {
				rCnt[i]=rCnt[i+1]+1;
			}
		}
    }
    
    public static int proc() {
    	int num=0;
    	if(cnt[N]==0) {
    		return 0;
    	}
    	else if(cnt[N]<0) {
    		for (int i = 1; i <= N; i++) {
    			if(cnt[i]==-1) {
    				for (int j = 0; j < i; j++) {
						if(s.charAt(j)==')') {
							num++;
						}
					}
    				return num;
    			}
    		}
    	}
    	else {
    		for (int i = N-1; i >= 0; i--) {
				if(rCnt[i]==-1) {
					for (int j = N-1; j >= i; j--) {
						if(s.charAt(j)=='(') {
							num++;
						}
					}
					return num;
				}
			}
    	}
    	
    	return num;
    }
    
}
