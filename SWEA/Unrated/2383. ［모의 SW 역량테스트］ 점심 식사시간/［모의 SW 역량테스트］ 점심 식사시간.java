import java.io.*;
import java.util.*;

/*
 * 97,004 kb
 * 363 ms
 */
public class Solution {
	
	public static int T, N, X;
	public static ArrayList<Pos> people, stair;
	public static PriorityQueue<Integer> one, two;
	public static int answerValue;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			N=Integer.parseInt(br.readLine());
			answerValue=1000000;
			people=new ArrayList<>();
			stair=new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					int num=Integer.parseInt(st.nextToken());
					
					if(num==1) {
						people.add(new Pos(i,j,0,-1));
					}
					else if(num>1) {
						stair.add(new Pos(i,j,num,-1));
					}
				}
			}
			
			perm(0);
			
			answer.append("#"+tc+" "+answerValue+'\n');
		}
		
		System.out.println(answer);
	}
	
	public static void perm(int depth) {
		if(depth==people.size()) {
			one=new PriorityQueue<>();
			two=new PriorityQueue<>();
			
			for (Pos p : people) {
				if(p.type==0) {
					one.add(p.len);
				}
				else {
					two.add(p.len);
				}
			}
			
			answerValue=Math.min(answerValue, simul());
			
			return;
		}
		
		for (int i = 0; i < 2; i++) {
			Pos s=stair.get(i);
			Pos p=people.get(depth);
			
			p.len=Math.abs(s.r-p.r)+Math.abs(s.c-p.c);
			p.type=i;
			
			perm(depth+1);
		}
	}
	
	public static int simul() {
		
		int resultOne=0, resultTwo=0;
		
		if(!one.isEmpty()) {
			int time[] = new int[one.size()];
			int i=1, cnt=1;
			time[0]=one.poll();
			
			while(!one.isEmpty()) {
				int num=one.poll();
				
				if(cnt<3) {
					time[i++]=num;
					cnt++;
				}
				else {
					int temp=time[i-3]+stair.get(0).len;
					time[i]=Math.max(temp, num);
					i++;
				}
			}
			
			resultOne=time[i-1]+stair.get(0).len;
		}
		
		if(!two.isEmpty()) {
			int time[]=new int[two.size()];
			int i=1, cnt=1;
			time[0]=two.poll();
			
			while(!two.isEmpty()) {
				int num=two.poll();
				
				if(cnt<3) {
					time[i++]=num;
					cnt++;
				}
				else {
					int temp=time[i-3]+stair.get(1).len;
					time[i]=Math.max(temp, num);
					i++;
				}
			}
			
			resultTwo=time[i-1]+stair.get(1).len;
		}
		
		return Math.max(resultOne, resultTwo)+1;
	}
	
	static class Pos{
		int r,c,len,type;

		public Pos(int r, int c, int len, int type) {
			super();
			this.r = r;
			this.c = c;
			this.len = len;
			this.type = type;
		}
	}
	
}
