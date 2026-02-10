import java.util.*;
import java.io.*;

public class Main {
    
    static int N, K, MAX=100_000;
    static int[] dp;

    static class Node {
        public int cur, time;
        public ArrayList<Integer> arr;

        Node(int num){
            this.cur=num;
            this.time=0;
            this.arr=new ArrayList<>();
            this.arr.add(num);
        }

        Node(int num, int t, ArrayList<Integer> temp){
            this.cur=num;
            this.time=t+1;
            this.arr=temp;
            this.arr.add(num);
        }
    }

    public static void main(String[] args) throws Exception{
        init();
        System.out.println(proc());
        print();
    }

    public static void init() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        dp=new int[MAX+1];
    }

    public static void print(){
        int cur=N;

        while(cur!=K){
            System.out.print(cur+" ");
            cur=dp[cur];
        }
        System.out.println(K);
    }

    public static Integer proc() {
        ArrayDeque<int[]> q=new ArrayDeque<>();
        boolean[] chk=new boolean[MAX+1];
        q.add(new int[]{K,0});
        chk[K]=true;

        while(!q.isEmpty()){
            int[] cur=q.poll();

            // System.out.println(info.cur+" "+info.time);

            if(cur[0]==N){
                return cur[1];
            }

            int nxt=cur[0]-1;
            if(valid(nxt)&&!chk[nxt]) {
                q.add(new int[]{nxt,cur[1]+1});
                dp[nxt]=cur[0];
                chk[nxt]=true;
            }
            
            nxt=cur[0]+1;
            if(valid(nxt)&&!chk[nxt]){
                q.add(new int[]{nxt,cur[1]+1});
                dp[nxt]=cur[0];
                chk[nxt]=true;
            }

            nxt=cur[0]/2;
            if(valid(nxt)&&cur[0]%2==0&&!chk[nxt]) {
                q.add(new int[]{nxt,cur[1]+1});
                dp[nxt]=cur[0];
                chk[nxt]=true;
            }
        }

        return null;
    }

    private static boolean valid(int i){
        return i>=0&&i<=MAX;
    }

}