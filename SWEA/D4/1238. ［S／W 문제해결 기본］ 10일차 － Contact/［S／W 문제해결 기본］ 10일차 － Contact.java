import java.io.*;
import java.util.*;

public class Solution {
    
	public static ArrayList<Integer> graph[];
	public static int[] indegree;
	public static boolean[] visited;
	public static int ansCnt, ansNum;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
//        int T = Integer.parseInt(st.nextToken());
        StringBuilder answer = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
        	StringTokenizer st=new StringTokenizer(br.readLine()," ");
        	int len=Integer.parseInt(st.nextToken());
        	len/=2;
        	int start=Integer.parseInt(st.nextToken());
        	st=new StringTokenizer(br.readLine()," ");
        	graph=new ArrayList[101];
        	indegree=new int[101];
        	visited=new boolean[101];
        	
        	for (int i = 0; i <= 100; i++) {
				graph[i]=new ArrayList<>();
			}
        	
        	for (int i = 0; i < len; i++) {
				int from=Integer.parseInt(st.nextToken());
				int to=Integer.parseInt(st.nextToken());
				
				graph[from].add(to);
				indegree[to]++;
			}
        	
        	ArrayDeque<int[]> q=new ArrayDeque<>();
        	q.add(new int[] {start,0});
        	ansCnt=0;
        	ansNum=start;
        	while(!q.isEmpty()) {
        		int[] v=q.poll();
        		int num=v[0];
        		int cnt=v[1];
        		int sz=graph[num].size();
        		
        		for (int i = 0; i < sz; i++) {
        			int go=graph[num].get(i);
        			
        			if(!visited[go]) {        				
        				q.add(new int[] {go,cnt+1});
        				visited[go]=true;
        				if(ansCnt<cnt+1) {
        					ansNum=go;
        					ansCnt=cnt+1;
        				}
        				else if(ansCnt==cnt+1&&ansNum<go) {
        					ansNum=go;
        					ansCnt=cnt+1;
        				}
        			}
				}
        	}
        	
        	answer.append("#"+tc+" "+ansNum+'\n');
        }
        System.out.println(answer);
    }
}

/*
2 7 11 6 6 2 2 15 15 4 4 2 4 10 7 1 1 7 1 8 1 17 3 22
*/