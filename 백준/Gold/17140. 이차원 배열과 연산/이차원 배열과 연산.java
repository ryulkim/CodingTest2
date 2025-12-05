import java.io.*;
import java.util.*;

public class Main {
	
	static int N, R, C, K, r=2, c=2;
	static HashMap<Integer, Integer> hm;
	static int[][] arr;
	
    public static void main(String[] args) throws IOException {
    	init();
    	System.out.println(proc());
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	R=Integer.parseInt(st.nextToken());
    	C=Integer.parseInt(st.nextToken());
    	K=Integer.parseInt(st.nextToken());
    	hm=new HashMap<>();
    	arr=new int[202][202];
    	N=3;
    	
    	for (int i = 0; i < 3; i++) {
    		st=new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    }
    
    public static int proc() {
    	for (int i = 0; i <= 100; i++) {
    		if(arr[R-1][C-1]==K) {
				return i;
			}
    		
			if(judge()==0) {
				R();
			}
			else {
				C();
			}
		}
    	
    	return -1;
    }
    
    public static int judge() {
    	int row=0, col=0;
    	
    	for (int i = 0; i < 200; i++) {
			for (int j = 0; j < 200; j++) {
				if(arr[i][j]>0) {
					row=Math.max(row, i);
					col=Math.max(col, j);
				}
			}
		}
    	
    	r=row; c=col;
    	
    	if(row>=col) return 0;
    	return 1;
    }
    
    public static void R() {
    	int[][] temp=new int[202][202];
    	
    	for (int i = 0; i <= r; i++) {
    		hm.clear();
    		
			for (int j = 0; j <= c; j++) {
				int num=arr[i][j];
				
				if(num==0) continue;
				
				hm.put(num, hm.getOrDefault(num, 0)+1);
			}
			
			ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
			
			list.sort((a,b)->{
				if(a.getValue()==b.getValue()) {
					return Integer.compare(a.getKey(), b.getKey()); 
				}
				return Integer.compare(a.getValue(), b.getValue());
			});
			
			int col=0;
			for (Map.Entry<Integer, Integer> entry : list) {
				temp[i][col++]=entry.getKey();
				temp[i][col++]=entry.getValue();
			}
		}
    	
    	arr=temp;
    }
    
    public static void C() {
    	int[][] temp=new int[202][202];
    	
    	for (int i = 0; i <= c; i++) {
    		hm.clear();
    		
			for (int j = 0; j <= r; j++) {
				int num=arr[j][i];
				
				if(num==0) continue;
				
				hm.put(num, hm.getOrDefault(num, 0)+1);
			}
			
			ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
			
			list.sort((a,b)->{
				if(a.getValue()==b.getValue()) {
					return Integer.compare(a.getKey(), b.getKey()); 
				}
				return Integer.compare(a.getValue(), b.getValue());
			});
			
			int row=0;
			for (Map.Entry<Integer, Integer> entry : list) {
				temp[row++][i]=entry.getKey();
				temp[row++][i]=entry.getValue();
			}
		}
    	arr=temp;
    }
}