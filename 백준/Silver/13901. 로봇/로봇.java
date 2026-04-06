import java.util.*;
import java.io.*;

public class Main {

    static int R, C, K, sr, sc, cnt=0, dir=0;
    static int[][] arr;
    static int[] dr={0,-1,1,0,0};
    static int[] dc={0,0,0,-1,1};
    static int[] mv;

    public static void main(String[] args) throws Exception {
        init();
    }

    public static void init() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(br.readLine());
        arr=new int[R][C];
        mv=new int[4];

        for(int i=0;i<K;i++){
            st=new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            arr[r][c]=-1;
        }

        st=new StringTokenizer(br.readLine());
        sr=Integer.parseInt(st.nextToken());
        sc=Integer.parseInt(st.nextToken());
        arr[sr][sc]=1;

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            mv[i]=Integer.parseInt(st.nextToken());
        }

        int idx=0;
        while(cnt<4){
            if(!move(mv[idx])) idx=(idx+1)%4;
            // print();
        }

        System.out.println(sr+" "+sc);
    }

    public static boolean move(int go) {
        int nr=sr+dr[go];
        int nc=sc+dc[go];

        if(valid(nr,nc)){
            sr=nr;
            sc=nc;
            arr[nr][nc]=1;
            cnt=0;
            return true;
        }
        cnt++;
        return false;
    }

    private static boolean valid(int i, int j){
        return i>=0&&i<R&&j>=0&&j<C&&arr[i][j]==0;
    }

    private static void print(){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}