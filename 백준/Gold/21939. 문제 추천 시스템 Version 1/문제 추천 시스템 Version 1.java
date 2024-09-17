import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

/*
 * 시간: 356ms	메모리: 35,044KB
 */
public class Main {
	
	static int N, M, P, L, x;
	static long ans=0, K;
	static TreeMap<Integer, TreeSet<Integer>> mp; //키: 난이도, 값: treeset(문제번호) 
	static TreeMap<Integer, Integer> pro; //키: 문제번호, 값: 난이도
	static long[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		mp=new TreeMap<>();
		pro=new TreeMap<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			P=Integer.parseInt(st.nextToken());
			L=Integer.parseInt(st.nextToken());
			add(L, P);
		}
		
		M=Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			String op=st.nextToken();
			
			if(op.equals("recommend")) {
				x=Integer.parseInt(st.nextToken());
				if(x==-1) {
					System.out.println(mp.get(mp.firstKey()).first());
				}
				else {
					System.out.println(mp.get(mp.lastKey()).last());
				}
			}
			else if(op.equals("add")) {
				P=Integer.parseInt(st.nextToken());
				L=Integer.parseInt(st.nextToken());
				add(L, P);
			}
			else {
				P=Integer.parseInt(st.nextToken());
				mp.get(pro.get(P)).remove(P);
				if(mp.get(pro.get(P)).isEmpty()) {
					mp.remove(pro.get(P));
				}
			}
		}
	}
	
	static void add(int L, int P) {
		if(mp.get(L)==null) {
			mp.put(L, new TreeSet<>());
		}
		mp.get(L).add(P);
		pro.put(P, L);
	}
}

