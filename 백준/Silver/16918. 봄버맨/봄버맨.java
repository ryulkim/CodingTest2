import java.util.*;
import java.io.*;

public class Main {

    static int R,C,N;
    static boolean[][] arr;
    static int[][] installTime;
    static int[] dr={0,0,1,-1};
    static int[] dc={-1,1,0,0};

    public static void main(String[] args) throws Exception {
        init();
        proc();
        ans();
    }

    public static void ans(){
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(arr[i][j]){
                    sb.append('O');
                }
                else{
                    sb.append('.');
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void init() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        arr=new boolean[R][C];
        installTime=new int[R][C];

        for(int i=0;i<R;i++){
            String s=br.readLine();
            for(int j=0;j<C;j++){
                char c=s.charAt(j);
                if(c=='.'){
                    arr[i][j]=false;
                }
                else{
                    arr[i][j]=true;
                }
            }
        }
    }

    public static void proc(){
        int time=1;
        while(time<N){
            installBomb(++time);
            // print();
            if(time==N) break;
            bomb(++time);
            // print();
            if(time==N) break;
        }
    }

    private static void print(){
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                sb.append(installTime[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void bomb(int time){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(arr[i][j]&&installTime[i][j]+3==time){
                    for(int k=0;k<4;k++){
                        int nr=i+dr[k];
                        int nc=j+dc[k];
                        if(!valid(nr,nc)||(arr[nr][nc]&&installTime[nr][nc]==installTime[i][j])) continue;
                        arr[nr][nc]=false;
                        installTime[nr][nc]=0;
                    }
                    arr[i][j]=false;
                    installTime[i][j]=0;
                }
            }
        }
    }

    public static void installBomb(int time){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(!arr[i][j]){
                    arr[i][j]=true;
                    installTime[i][j]=time;
                }
            }
        }
    }

    private static boolean valid(int i, int j){
        return i>=0&&i<R&&j>=0&&j<C;
    }

}