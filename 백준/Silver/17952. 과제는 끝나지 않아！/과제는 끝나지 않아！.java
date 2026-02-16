import java.util.*;
import java.io.*;

public class Main {

    static int N, ans=0;
    static ArrayDeque<int[]> work;

    public static void main(String[] args) throws Exception {
        init();
    }

    public static void init() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        work=new ArrayDeque<>();

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int cmd=Integer.parseInt(st.nextToken());
            if(cmd==1){
                int A=Integer.parseInt(st.nextToken());
                int T=Integer.parseInt(st.nextToken());
                work.addFirst(new int[]{A,T});
            }
            if(!work.isEmpty()&&--work.peek()[1]==0){
                ans+=work.pop()[0];
            }
        }
        
        System.out.println(ans);
    }
}