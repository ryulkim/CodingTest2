import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Main {
	
	static int R, C, T, air=-1; 
	static int[][] arr;
	static ArrayDeque<int[]> q;
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	
    	for (int testCase = 0; testCase < T; testCase++) {
    		findMunji();
    		spread();
			circular();
		}
    	
    	total();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	R=Integer.parseInt(st.nextToken());
    	C=Integer.parseInt(st.nextToken());
    	T=Integer.parseInt(st.nextToken());
    	arr=new int[R][C];
    	q=new ArrayDeque<>();
    	
    	for (int i = 0; i < R; i++) {
    		st=new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(air==-1&&arr[i][j]==-1) {
					air=i;
				}
			}
		}
    	
    }
    
    public static void total() {
    	int sum=0;
    	for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sum+=Math.max(0, arr[i][j]);
			}
		}
    	System.out.println(sum);
    }

    public static void findMunji() {
    	for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j]>0) {
					q.add(new int[] {i,j,arr[i][j]});
//					System.out.println(i+" "+j);
				}
			}
		}
//    	System.out.println(q.size());
    }
    
    public static void circular() {
    	int[][] clock={{-1,0},{0,1},{1,0},{0,-1}};
    	int[] pos= {air,0};
    	
    	for (int i = 0; i < 4; i++) {
			pos=proc(pos[0], pos[1], clock[i][0], clock[i][1], 0, air);
		}
//    	chk();
    	
//    	System.out.println("---");
    	
    	int[][] rClock= {{1,0},{0,1},{-1,0},{0,-1}};
    	int[] rPos= {air+1,0};
    	for (int i = 0; i < 4; i++) {
			rPos=proc(rPos[0], rPos[1], rClock[i][0], rClock[i][1], air+1, R-1);
		}
//    	chk();
    }
    
    private static int[] proc(int r, int c, int dirR, int dirC, int start, int end) {
//    	System.out.println(r+" "+c+" "+dirR+" "+dirC);
//    	System.out.println(start+" "+end);
    	
    	while(valid(r,c)) {
    		int temp=arr[r][c];
    		int nr=r+dirR;
    		int nc=c+dirC;
    		
    		
    		if(!valid(nr,nc)) break;
    		if(start>nr||end<nr) break;
    		
//    		System.out.println(r+" "+c+" "+nr+" "+nc);
    		
    		if(temp==-1) {

    		}
    		else if(arr[nr][nc]==-1) {
    			arr[r][c]=0;
    		}
    		else {
    			arr[r][c]=arr[nr][nc];
    		}
    		
    		r=nr; c=nc;
    	}
    	
    	return new int[] {r,c};
    }
    
    public static void chk() {
    	StringBuilder sb=new StringBuilder();
    	
    	for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
    	
    	System.out.println(sb);
    }
    
    public static void spread() {
    	while(!q.isEmpty()) {
    		int[] pos=q.poll();
    		int r=pos[0];
    		int c=pos[1];
    		int sum=0;
    		int value=pos[2]/5;
    		
    		for (int k = 0; k < 4; k++) {
				int nr=r+dr[k];
				int nc=c+dc[k];
				
				if(!valid(nr,nc)||arr[nr][nc]==-1) continue;
				
				sum+=value;
				arr[nr][nc]+=value;
			}
    		arr[r][c]-=sum;
    	}
    }
    
    public static boolean valid(int i, int j) {
    	return i>=0&&i<R&&j>=0&&j<C;
    }
    
}