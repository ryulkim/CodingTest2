import java.io.*;
import java.util.*;

/*
 * 96,760 kb
 * 1,022 ms
 */
public class Solution {
    
    public static int T,N,M,a,b,ans,cnt;
    public static ArrayList<Integer> graph[];
    public static Queue<Integer> q;
    public static Set<Integer> smallThanMe[];
    public static int indegree[];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        T = Integer.parseInt(br.readLine());
        
        for (int testCase = 1; testCase <= T; testCase++) {
            N=Integer.parseInt(br.readLine());
            M=Integer.parseInt(br.readLine());
            graph=new ArrayList[N+1]; 
            smallThanMe=new HashSet[N+1];
            indegree=new int[N+1];
            q=new LinkedList<>();
            ans=0; cnt=0;
            
            for (int i = 1; i <=N; i++) {
				graph[i]=new ArrayList<>();
				smallThanMe[i]=new HashSet<>();
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
            	}
            }
            
            while(!q.isEmpty()) {
            	int num=q.poll();
            	int sum=0;
            	for (int i = 1; i <= N; i++) {
            		if(i==num) continue;
//            		if(smallThanMe[num][i]) sum++;
				}
            	
            	if(smallThanMe[num].size()==cnt-1) ans++;
            	
            	for (int element  : graph[num]) {
					if(--indegree[element]==0) {
						q.add(element);
						cnt++;
					}
					
					for (Integer v : smallThanMe[num]) {
						smallThanMe[element].add(v);
					}
//					for (int i = 1; i <= N; i++) {	
//						if(smallThanMe[num][i]) smallThanMe[element][i]=true;
//					}
//					smallThanMe[element][num]=true;
					smallThanMe[element].add(num);
				}
            }
            
            sb.append("#"+testCase+" "+ans+'\n');
        }
        System.out.println(sb);
    }
    
}
