import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair{
	int r, c;

	public Pair(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}

	@Override
	public int hashCode() {
		return Objects.hash(c, r);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		return c == other.c && r == other.r;
	}
}

public class Main {
	static int N, K, L;
	static int[][] apples;
	static ArrayDeque<Pair> dq;
	static Map<Integer, String> change;
	static int[] dr= {-1,0,1,0}; //위,오,아,왼
	static int[] dc= {0,1,0,-1};
	
    public static void main(String[] args) throws IOException {
    	init();
    	
    	int ans=proc();
    	System.out.println(ans);
    }
    
    public static int proc() {
    	dq.add(new Pair(1, 1));
    	int time=0;
    	int dir=1;
    	int headR=1;
    	int headC=1;
    	
    	while(true) {
    		// 시간 1초 증가
    		time++;
    		// 머리를 한 칸 이동
    		int nr=dr[dir]+headR;
    		int nc=dc[dir]+headC;
    		
    		// 벽 또는 자기 몸과 부딪혔는가?
    		if(!valid(nr,nc)||dq.contains(new Pair(nr, nc))) {
    			break;
    		}
    		headR=nr;
    		headC=nc;
    		dq.addFirst(new Pair(nr, nc));
    		// 사과가 있는지 확인
			// 	사과 있으면 -> 몸길이 증가(꼬리 안줄임)
    		if(apples[nr][nc]==1) {
    			apples[nr][nc]=0;
    		}
			// 	사과 없으면 -> 꼬리 한 칸 줄이기
    		else {
				dq.removeLast();
			}
    		// 방향 전환이 있는가? -> 회전
    		if(change.get(time)!=null) {
    			String changeDir=change.get(time);
    			dir=dicideDir(dir, changeDir);
    		}
    	}
    	return time;
    }
    
    public static boolean valid(int r, int c) {
    	return r>=1&&r<=N&&c>=1&&c<=N;
    }
    
    public static int dicideDir(int dir, String change) {
    	switch (change) { 
			case "D": {
				// 위->오: 0->1
				// 오->아 1->2
				// 아->왼 2->3
				// 왼->위 3->0
				// (x+1)%4
				return (dir+1)%4;
			}
			default: {
				// 위->왼: 0->3
				// 오->위 1->0
				// 아->오 2->1
				// 왼->아 3->2
				// (x+3)%4
				return (dir+3)%4;
			}
    	}
    }
    
    public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
        
    	N=Integer.parseInt(br.readLine());
    	K=Integer.parseInt(br.readLine());
    	
    	dq=new ArrayDeque<>();
    	change=new HashMap<>();
    	apples=new int[N+1][N+1];
    	
    	for (int i = 0; i < K; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			apples[r][c]=1;
		}
    	
    	L=Integer.parseInt(br.readLine());
    	for (int i = 0; i < L; i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		int x=Integer.parseInt(st.nextToken());
    		String c=st.nextToken();
    		
    		change.put(x, c);
    	}
    }
}
