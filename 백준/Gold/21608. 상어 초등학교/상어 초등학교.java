import java.io.*;
import java.util.*;

public class Main {
	
	static int N, SZ;
	static HashSet<Integer>[] info;
	static ArrayList<Integer> students;
	static int[][] arr;
	static int[] dr= {0,0,1,-1};
	static int[] dc= {-1,1,0,0};
	
    public static void main(String[] args) throws IOException {
    	init();
    	proc();
    	result();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	SZ=N*N;
    	info=new HashSet[SZ+1];
    	students=new ArrayList<>();
    	arr=new int[N][N];
    	
    	for (int i = 0; i <= SZ; i++) {
			info[i]=new HashSet<>();
		}
    	
    	for (int i = 0; i < SZ; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int num=parseInt(st);
			students.add(num);
			info[num].add(parseInt(st)); 
			info[num].add(parseInt(st)); 
			info[num].add(parseInt(st)); 
			info[num].add(parseInt(st)); 
		}
    }
    
    public static void proc() {
    	PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
			if(a[0]==b[0]&&a[1]==b[1]&&a[2]==b[2]) {
				return Integer.compare(a[3], b[3]);
			}
			if(a[0]==b[0]&&a[1]==b[1]) {
				return Integer.compare(a[2], b[2]);
			}
			if(a[0]==b[0]) {
				return Integer.compare(b[1], a[1]);
			}
			return Integer.compare(b[0], a[0]);
		});
    	
    	for (int i = 0; i < SZ; i++) {
			int num=students.get(i);
			
			pq.clear();
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(arr[j][k]!=0) continue;

					pq.add(count(num, j, k));					
				}
			}
			
			int[] value=pq.poll();
			arr[value[2]][value[3]]=num;
		}
    }
    
    public static void result() {
    	int sum=0;
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {				
				int cnt=countLike(arr[i][j], i, j);
				if(cnt==1) {
					sum++;
				}
				else if(cnt==2) {
					sum+=10;
				}
				else if(cnt==3) {
					sum+=100;
				} 
				else if(cnt==4){
					sum+=1000;
				}
			}
		}
    	
    	System.out.println(sum);
    }
    
    public static int countLike(int num, int r, int c) {
    	int likeCnt=0;
    	
    	for (int k = 0; k < 4; k++) {
			int nr=r+dr[k];
			int nc=c+dc[k];
			if(!valid(nr,nc)) continue;
			
			if(info[num].contains(arr[nr][nc])) {
				likeCnt++;
			}
		}
    	
    	return likeCnt;
    }
    
    public static int[] count(int num, int r, int c) {
    	int likeCnt=0, blankCnt=0;
    	
    	for (int k = 0; k < 4; k++) {
			int nr=r+dr[k];
			int nc=c+dc[k];
			if(!valid(nr,nc)) continue;
			if(arr[nr][nc]==0) {
				blankCnt++;
			}
			else if(info[num].contains(arr[nr][nc])) {
				likeCnt++;
			}
			
		}
    	
    	return new int[] {likeCnt, blankCnt, r, c};
    }
    
    public static boolean valid(int i, int j) {
    	return i>=0&&i<N&&j>=0&&j<N;
    }
    
    public static int parseInt(StringTokenizer s) {
    	return Integer.parseInt(s.nextToken());
    }

}