import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 시간: 676ms	메모리: 58,544KB
 */
public class Main {
	
	static int N, M, P, L, G, x;
	static long ans=0, K;
	//키: 알고리즘, 값: treeset(난이도) 
	//키: 난이도, 값: treeset(문제번호) 
	static TreeMap<Integer, TreeMap<Integer, TreeSet<Integer>>> algo; //알고리즘, 난이도, 문제번호
	static TreeMap<Integer, TreeSet<Integer>> level;
	//키: 문제번호, 값: 난이도
	//키: 난이도, 값: 알고리즘
	static TreeMap<Integer, Integer> reLevel, reAlgo; 
	static long[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		N=Integer.parseInt(br.readLine());
		algo=new TreeMap<>();
		level=new TreeMap<>();
		reAlgo=new TreeMap<>();
		reLevel=new TreeMap<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			P=Integer.parseInt(st.nextToken());
			L=Integer.parseInt(st.nextToken());
			G=Integer.parseInt(st.nextToken());
			add(L, P, G);
		}
		
		M=Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			String op=st.nextToken();
			
			if(op.equals("recommend")) {
				G=Integer.parseInt(st.nextToken());
				x=Integer.parseInt(st.nextToken());
				if(x==-1) {
					int lev=algo.get(G).firstKey();
					sb.append(algo.get(G).get(lev).first()+"\n");
				}
				else {
					int lev=algo.get(G).lastKey();
					sb.append(algo.get(G).get(lev).last()+"\n");
				}
			}
			else if(op.equals("recommend2")) {
				x=Integer.parseInt(st.nextToken());
				if(x==-1) {
					sb.append(level.get(level.firstKey()).first()+"\n");
				}
				else {
					sb.append(level.get(level.lastKey()).last()+"\n");
				}
			}
			else if(op.equals("recommend3")) {
				x=Integer.parseInt(st.nextToken());
				L=Integer.parseInt(st.nextToken());
				if(x==-1) {
					Integer key=level.lowerKey(L);
					if(key==null) sb.append("-1\n"); 
					else sb.append(level.get(key).last()+"\n"); 
				}
				else {
					Integer key=level.ceilingKey(L);
					if(key==null) sb.append("-1\n"); 
					else sb.append(level.get(key).first()+"\n"); 
				}
			}
			else if(op.equals("add")) {
				P=Integer.parseInt(st.nextToken());
				L=Integer.parseInt(st.nextToken());
				G=Integer.parseInt(st.nextToken());
				add(L, P, G);
			}
			else {
				P=Integer.parseInt(st.nextToken());
				int lev=reLevel.get(P);
				level.get(lev).remove(P);
				reLevel.remove(P);
				if(level.get(lev).isEmpty()) {
					level.remove(lev);
				}
				int g=reAlgo.get(P);
				algo.get(g).get(lev).remove(P);
				if(algo.get(g).get(lev).isEmpty()) {
					algo.get(g).remove(lev);
				}
				if(algo.get(g).isEmpty()) {
					algo.remove(g);
				}
			}
		}
		System.out.println(sb);
	}
	
	static void add(int L, int P, int G) {
		if(algo.get(G)==null) {
			algo.put(G, new TreeMap<>());
		}
		if(algo.get(G).get(L)==null) {
			algo.get(G).put(L, new TreeSet<>());
		}
		if(level.get(L)==null) {
			level.put(L, new TreeSet<>());
		}
//		if(reAlgo.get(L)==null) {
//			reAlgo.put(L, new TreeSet<>());
//		}
		algo.get(G).get(L).add(P);
		level.get(L).add(P);
		reAlgo.put(P, G);
		reLevel.put(P, L);
	}
}

