import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 시간: 1028ms    메모리: 98,944KB
 */
public class Main {
    
    static int N, M, K, u, v, w, ans;
    static ArrayList<Node>[] graph;
    static boolean visited[];
    static int INF=Integer.MAX_VALUE;
    static PriorityQueue<Integer>[] shortest;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        graph=new ArrayList[N+1];
        shortest=new PriorityQueue[N+1];
        
        ans=0;
        
        for (int i = 0; i <= N; i++) {
            graph[i]=new ArrayList<>();
            shortest[i]=new PriorityQueue(Collections.reverseOrder());
        }
        
        for (int i = 0; i < M; i++) {
            st=new StringTokenizer(br.readLine());
            u=Integer.parseInt(st.nextToken());
            v=Integer.parseInt(st.nextToken());
            w=Integer.parseInt(st.nextToken());
            
            graph[u].add(new Node(v,w));
        }
        
        djik(1);
        
        for (int i = 1; i <= N ; i++) {
            if(shortest[i].size()<K) System.out.println(-1);
            else System.out.println(shortest[i].peek());
        }
    }
    
    public static void djik(int start) {
        PriorityQueue<Vertex> q=new PriorityQueue<>();
        q.add(new Vertex(0,start));
        shortest[start].add(0);
        
        while(!q.isEmpty()) {
            Vertex v=q.poll();
            int num=v.node;
            int value=v.weight;
            int sz=graph[num].size();
       
            for (int i = 0; i < sz; i++) {
                Node to=graph[num].get(i);
                if(shortest[to.v].size()<K) {
                	shortest[to.v].add(to.weight+value);
                	q.add(new Vertex(to.weight+value, to.v));
                }
                else if(shortest[to.v].peek()>to.weight+value) {
                    q.add(new Vertex(to.weight+value, to.v));
                    shortest[to.v].add(to.weight+value);
                    shortest[to.v].poll();
                    
                }
            }
        }
    }
    
    public static class Node{
        int v, weight;

        public Node(int v, int weight) {
            super();
            this.v = v;
            this.weight = weight;
        }
    }
    
    public static class Vertex implements Comparable<Vertex>{
        int weight, node;

        public Vertex(int weight, int node) {
            super();
            this.weight = weight;
            this.node = node;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.weight-o.weight;
        }
    }
}
