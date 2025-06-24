import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Info{
	int idx;
	int score;
	
	public Info(int idx, int score) {
		super();
		this.idx = idx;
		this.score = score;
	}
}

public class Main {
	
	static int T, N;
	static HashMap<Integer, Integer> cnt;
	static HashMap<Integer, Info> score;
	static int[] arr, five;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	
//    	chk();
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	T=Integer.parseInt(br.readLine());
    	cnt=new HashMap<>();
    	score=new HashMap<>();
    	
    	for (int i = 0; i < T; i++) {
    		N=Integer.parseInt(br.readLine());
    		arr=new int[N];
    		five=new int[201];
    		cnt.clear();
    		score.clear();
    		
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		for (int j = 0; j < N; j++) {
				int x=Integer.parseInt(st.nextToken());
				cnt.put(x, cnt.getOrDefault(x, 0)+1);
				arr[j]=x;
			}
    		
    		getScore();
        	proc();
		}
    }
     
    public static void getScore() {
    	int rank=1;

    	for (int i = 0; i < N; i++) {
    		int num=arr[i];
			if(cnt.get(num)!=6) continue;
			
			Info infos=score.getOrDefault(num, new Info(0,0));
			
			if(infos.idx==4) {
				five[num]=rank++;
				infos.idx++;
				continue;
			}
			else if(infos.idx>4) {
				rank++;
				continue;
			}
			
			infos.score+=rank++;
			infos.idx++;

    		score.put(num,infos);
    		
//    		System.out.println(num+" "+(rank-1)+" "+score.get(num));
		}
    	
    }
    
    public static void proc() {
    	int ans=1000_000_000;
    	int ansNum=0;
    	
    	for(int num: score.keySet()) {
//    		System.out.println(num+" "+score.get(num).score+" "+five[num]);
    		
    		if(ans==score.get(num).score&&five[num]<five[ansNum]) {
    			ansNum=num;
    		}
    		else if(ans>score.get(num).score) {
    			ans=score.get(num).score;
    			ansNum=num;
    		}
    	}
    	
    	System.out.println(ansNum);
    }
    
}