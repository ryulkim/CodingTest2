import java.util.*;
import java.io.*;

public class Main {

    static int N, M, K, ans=0;
    static int[][] info;
    static ArrayDeque<Integer>[] lines;

    public static void main(String[] args) throws Exception {
        init();
        line();
        simul();
        System.out.println(ans);
    }

    public static void init() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        info=new int[N][2];
        lines=new ArrayDeque[M];

        for(int i=0;i<M;i++){
            lines[i]=new ArrayDeque<>();
        }

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int D=Integer.parseInt(st.nextToken());
            int H=Integer.parseInt(st.nextToken());
            info[i][0]=D;
            info[i][1]=H;
        }
    }

    public static void line(){
        for(int i=0;i<M;i++){
            for(int j=i;j<N;j+=M){
                lines[i].add(j);
            }
        }
    }
    
    public static void simul(){
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->{
                if(a[1]==b[1]&&a[2]==b[2]){
                    return Integer.compare(a[3], b[3]);
                }
                if(a[1]==b[1]){
                    return Integer.compare(b[2], a[2]);
                }
                return Integer.compare(b[1], a[1]);
            }
        );

        for(int i=0;i<M&&i<N;i++){
            pq.add(new int[]{i, info[i][0], info[i][1], i}); // 번호, 근무 일수, 급한 정도, 라인 번호
        }

        while(true){
            int[] human=pq.poll();
            int humanNum=human[0];
            int lineNum=human[3];

            // System.out.println(humanNum);

            if(humanNum==K){
                return;
            }

            lines[lineNum].poll();
            ans++;

            if(!lines[lineNum].isEmpty()){
                int num=lines[lineNum].peek();
                pq.add(new int[]{num, info[num][0], info[num][1], lineNum});
            }
            
        }
    }

    
}