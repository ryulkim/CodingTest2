import java.io.*;
import java.util.*;

/*
 * 18,400 kb
 * 113 ms
 */
public class Solution {
    
    public static int T,N,M,a,b,ans,cnt;
    public static ArrayList<Integer> graph[];
    public static Queue<Integer> q;
    public static boolean smallThanMe[][];
    public static int indegree[];
    public static boolean visited[];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        T = Integer.parseInt(br.readLine());
        
        for (int testCase = 1; testCase <= T; testCase++) {
            N=Integer.parseInt(br.readLine());
            M=Integer.parseInt(br.readLine());
            graph=new ArrayList[N+1]; 
            smallThanMe=new boolean[N+1][N+1];
            indegree=new int[N+1];
            visited=new boolean[N+1];
            q=new LinkedList<>();
            ans=0; cnt=0;
            
            for (int i = 1; i <=N; i++) {
				graph[i]=new ArrayList<>();
			}
            
            for (int i = 0; i < M; i++) {
            	st=new StringTokenizer(br.readLine()," ");
            	a=Integer.parseInt(st.nextToken());
            	b=Integer.parseInt(st.nextToken());
            	
            	graph[a].add(b);
            	indegree[b]++;
            }
            
            for (int i = 1; i <= N; i++) {
            	if(indegree[i]==0) {
            		q.add(i);
            		cnt++;
            		visited[i]=true;
            	}
            }
            
            while(!q.isEmpty()) {
            	int num=q.poll();
            	int sum=0;
            	boolean flag=true;
            	for (int i = 1; i <= N; i++) {
            		if(i==num) continue;
//            		if(smallThanMe[num][i]!=visited[i])	flag=false;
            		if(smallThanMe[num][i]) sum++;
				}
            	
//            	visited[num]=true;
//            	if(flag) ans++;
            	if(sum==cnt-1) ans++;
            	
            	for (int element  : graph[num]) {
					if(--indegree[element]==0) {
						q.add(element);
						cnt++;
					}
					
					for (int i = 1; i <= N; i++) {	
						if(smallThanMe[num][i]) smallThanMe[element][i]=true;
					}
					smallThanMe[element][num]=true;
				}
            }
            
            sb.append("#"+testCase+" "+ans+'\n');
        }
        System.out.println(sb);
    }
    
}
