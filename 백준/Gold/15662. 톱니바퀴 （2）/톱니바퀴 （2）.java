import java.util.*;
import java.io.*;

public class Main {

    static int N, K;
    static int[][] topni;
    static int[] twelve;

    public static void main(String[] args) throws Exception {
        init();
        ans();
    }

    public static void ans(){
        int ans=0;
        for(int i=1;i<=N;i++){
            if(topni[i][twelve[i]]==1) ans++;
        }
        System.out.println(ans);
    }

    public static void init() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        topni=new int[N+1][8];
        twelve=new int[N+1];
        
        for(int i=1;i<=N;i++){
            String info=br.readLine();
            for(int j=0;j<8;j++){
                topni[i][j]=info.charAt(j)-'0';
            }
        }

        K=Integer.parseInt(br.readLine());
        for(int i=0;i<K;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int num=Integer.parseInt(st.nextToken());
            int clock=Integer.parseInt(st.nextToken());

            proc(num, clock);
            // print();
        }
    }

    public static void proc(int num, int clock){
        boolean bClock=true;
        if(clock==-1) bClock=false;
        boolean left=false, right=false;
        int posi=twelve[num];
        int curLeft=(posi+6)%8;
        int curRight=(posi+2)%8;

        left=isLeftTopniRotate(num);
        right=isRightTopniRotate(num);

        rotate(num, bClock);
        if(left) dfs(num-1, !bClock, -1);
        if(right) dfs(num+1, !bClock, 1);
    }

    private static void print(){
        for(int i=1;i<=N;i++){
            for(int j=0;j<8;j++){
                System.out.print(topni[i][(twelve[i]+j)%8]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isLeftTopniRotate(int num){
        if(!valid(num-1)) return false;

        int posi=twelve[num];
        int curLeft=(posi+6)%8;
        int curRight=(posi+2)%8;
        int leftRight=(twelve[num-1]+2)%8;
        if(topni[num][curLeft]!=topni[num-1][leftRight]){
            return true;
        }

        return false;
    }

    private static boolean isRightTopniRotate(int num){
        if(!valid(num+1)) return false;

        int posi=twelve[num];
        int curLeft=(posi+6)%8;
        int curRight=(posi+2)%8;
        int rightLeft=(twelve[num+1]+6)%8;
        if(topni[num][curRight]!=topni[num+1][rightLeft]){
            return true;
        }

        return false;
    }

    public static void dfs(int num, boolean clock, int dir){
        if(!valid(num)) return;

        boolean chk=false;
        if(dir==-1){
            chk=isLeftTopniRotate(num);
        }
        else{
            chk=isRightTopniRotate(num);
        }
        rotate(num, clock);
        if(chk) dfs(num+dir, !clock, dir);
    }

    public static void rotate(int num, boolean clock){
        int posi=twelve[num];
        if(clock){
            twelve[num]=(posi+7)%8;
        }
        else{
            twelve[num]=(posi+1)%8;
        }
    }

    public static boolean valid(int num){
        return num>=1&&num<=N;
    }
}