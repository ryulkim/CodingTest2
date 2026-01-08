import java.io.*;
import java.util.*;

public class Main {
	
	static int T;
	static int[] seventeenPrice = {500,300,200,50,30,10};
	static int[] seventeenPerson = {1,2,3,4,5,6};
	static int[] eighteenPrice = {512,256,128,64,32};
	static int[] eighteenPerson = {1,2,4,8,16};
	
    public static void main(String[] args) throws IOException {
    	init();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	T=Integer.parseInt(br.readLine());
    	
    	for (int i = 0; i < T; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int sum=0;
			
			if(a>0) {
				for (int j = 0; j < 6; j++) {
					a-=seventeenPerson[j];
					if(a<=0) {
						sum+=seventeenPrice[j];
						break;
					}
				}
			}
			
			if(b>0) {
				for (int j = 0; j < 5; j++) {
					b-=eighteenPerson[j];
					if(b<=0) {
						sum+=eighteenPrice[j];
						break;
					}
				}
			}
			System.out.println(sum*10000);
		}
    	
    	
    }
    
    public static void proc() {
    	
    }
    
    
    
    

}