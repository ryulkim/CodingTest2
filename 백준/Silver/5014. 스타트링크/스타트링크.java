import java.util.*;
import java.io.*;

public class Main {
    static int f,s,g,u,d;
    static boolean[] chk;

    public static void main(String[] args) throws Exception{
        init();
        int ans=bfs(s);
        System.out.println(ans==-1?"use the stairs":ans);
    }

    public static void init() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        f=Integer.parseInt(st.nextToken());
        s=Integer.parseInt(st.nextToken());
        g=Integer.parseInt(st.nextToken());
        u=Integer.parseInt(st.nextToken());
        d=Integer.parseInt(st.nextToken());
        chk=new boolean[f+1];
    }

    public static int bfs(int num){
        ArrayDeque<int[]> q=new ArrayDeque<>();
        q.add(new int[]{num,0});
        chk[num]=true;

        while(!q.isEmpty()){
            int[] cur=q.poll();

            // System.out.println(cur[0]+" "+cur[1]);

            if(cur[0]==g){
                return cur[1];
            }

            int nxt=cur[0]+u;
            if(valid(nxt)&&!chk[nxt]){
                chk[nxt]=true;
                q.add(new int[]{nxt,cur[1]+1});
            }
            nxt=cur[0]-d;
            if(valid(nxt)&&!chk[nxt]){
                chk[nxt]=true;
                q.add(new int[]{nxt,cur[1]+1});
            }
        }

        return -1;
    }

    private static boolean valid(int num){
        return num>=1&&num<=f;
    }
}