import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M, person, ans=0;
	static ArrayList<int[]> info[]; // 번호, 그래프 번호
	static ArrayDeque<Integer> know;
	static boolean party[];
	static boolean chk[];
	

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
//    	chk();
    	proc();
    	System.out.println(getCount());
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	info=new ArrayList[N+1];
    	know=new ArrayDeque<>();
    	party=new boolean[M];
    	chk=new boolean[N+1];
    	
    	st=new StringTokenizer(br.readLine());
    	person=Integer.parseInt(st.nextToken());
    	
    	for (int i = 0; i <= N; i++) {
			info[i]=new ArrayList<>();
		}
    	    	
    	for (int i = 0; i < person; i++) {
    		int num=Integer.parseInt(st.nextToken());
    		know.add(num);
    		chk[num]=true;
		}
    	
    	for (int i = 0; i < M; i++) {
    		st=new StringTokenizer(br.readLine());
    		int cnt=Integer.parseInt(st.nextToken());
    		int[] temp=new int[cnt];
    		
    		for (int j = 0; j < cnt; j++) {
    			int num=Integer.parseInt(st.nextToken());
    			temp[j]=num;
    		}
    		
    		for (int j = 0; j < cnt; j++) {
    			int A=temp[j];
    			if(chk[A]) party[i]=true;
    			
    			info[temp[j]].add(new int[] {temp[j],i});
    			
				for (int k = j+1; k < cnt; k++) {
					int B=temp[k];
					if(chk[B]) party[i]=true;
					
					info[A].add(new int[] {B,i});
					info[B].add(new int[] {A,i});
				}
			}
		}
    	
    }
    
    public static void chk() {
    	for (int i = 0; i <= N; i++) {
			for (int[] ele : info[i]) {
				System.out.print(ele[0]+" ");
			}
			System.out.println();
		}
    }
    
    
    public static void proc() {
    	while(!know.isEmpty()) {
    		int num=know.poll();
    		
    		for (int[] ele : info[num]) {
    			if(ele[0]==num) party[ele[1]]=true;
    			
				if(!chk[ele[0]]) {
					chk[ele[0]]=true;
					party[ele[1]]=true;
					know.add(ele[0]);
				}
			}
    	}
    }
    
    public static int getCount() {
    	int ans=0;
    	for (int i = 0; i < M; i++) {
			if(!party[i]) ans++;
		}
    	return ans;
    }
    
    
}