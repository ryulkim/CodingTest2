import java.io.*;
import java.util.*;

public class Main {
	
	static int N, ans=40000, total=0;
	static int[][] arr;
	static int[] values;
	static int[] dr= {-1,1,1,-1};
	static int[] dc= {1,1,1,1};
	
    public static void main(String[] args) throws IOException {
    	init();
    	proc();
    	System.out.println(ans);
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N][N];
    	values=new int[5];
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				total+=arr[i][j];
			}
		}
    }
    
    public static void proc() {
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int d1 = 1; d1*d1 <= 2*N*N; d1++) {
					for (int d2 = 1; d2*d2 <= 2*N*N; d2++) {
						int[] pos=one(i,j,d1);
						if(pos==null) continue;
						pos=two(pos[0],pos[1],d2);
						if(pos==null) continue;
						pos=three(i,j,d2);
						if(pos==null) continue;
						pos=four(pos[0],pos[1],d1);
						if(pos==null) continue;
						
						values[4]=total-values[0]-values[1]-values[2]-values[3];
						
						Arrays.sort(values);
						
						ans=Math.min(ans, values[4]-values[0]);
					}
				}
			}
		}
    }
    
    public static int[] one(int r, int c, int d) {
    	int sum=0;
    	
    	for (int i = 0; i < d; i++) {
			r+=dr[0];
			c+=dc[0];
			
			if(!valid(r,c)) return null;
			
			for (int j = 0; j < c; j++) {
				sum+=arr[r][j];
			}
		}
    	
    	for (int i = 0; i < r; i++) {
			for (int j = 0; j <= c; j++) {
				sum+=arr[i][j];
			}
		}
    	
    	if(sum==0) return null;
    	
    	values[0]=sum;
    	
    	return new int[] {r,c};
    }
    
    public static int[] two(int r, int c, int d) {
    	int sum=0;
    	
    	for (int i = 0; i <= r; i++) {
			for (int j = c+1; j < N; j++) {
				sum+=arr[i][j];
			}
		}
    	
    	for (int i = 0; i < d; i++) {
			r+=dr[1];
			c+=dc[1];
			
			if(!valid(r,c)) return null;
			
			for (int j = c+1; j < N; j++) {
				sum+=arr[r][j];
			}
		}
    	
    	if(sum==0) return null;
    	
    	values[1]=sum;
    	
    	return new int[] {r,c};
    }
    
    public static int[] three(int r, int c, int d) {
    	int sum=0;
    	
    	for (int i = 0; i < d; i++) {
    		for (int j = 0; j < c; j++) {
				sum+=arr[r][j];
			}
    		
			r+=dr[2];
			c+=dc[2];
			
			if(!valid(r,c)) return null;
		}
    	
    	for (int i = r; i < N; i++) {
			for (int j = 0; j < c; j++) {
				sum+=arr[i][j];
			}
		}
    	
    	if(sum==0) return null;
    	
    	values[2]=sum;
    	
    	return new int[] {r,c};
    }
    
    public static int[] four(int r, int c, int d) {
    	int sum=0;
    	
    	for (int i = r+1; i < N; i++) {
			for (int j = c; j < N; j++) {
				sum+=arr[i][j];
			}
		}
    	
    	for (int i = 0; i < d; i++) {
    		for (int j = c+1; j < N; j++) {
				sum+=arr[r][j];
			}
    		
			r+=dr[3];
			c+=dc[3];
			
			if(!valid(r,c)) return null;
		}
    	
    	if(sum==0) return null;
    	
    	values[3]=sum;
    	
    	return new int[] {r,c};
    }
    
    private static boolean valid(int r, int c) {
    	return r>=0&&r<N&&c>=0&&c<N;
    }
    
}