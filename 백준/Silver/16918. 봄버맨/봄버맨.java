import java.util.*;
import java.io.*;

public class Main {

    static int R,C,N;
    static int[][] arr;
    static int[][] installTime;
    static int[] dr={0,0,1,-1};
    static int[] dc={-1,1,0,0};

    public static void main(String[] args) throws Exception {
        init();
        proc();
    }

    public static void init() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        arr=new int[R][C];
        installTime=new int[R][C];

        for(int i=0;i<R;i++){
            String s=br.readLine();
            for(int j=0;j<C;j++){
                char c=s.charAt(j);
                if(c=='.'){
                    arr[i][j]=0;
                }
                else{
                    arr[i][j]=1;
                }
            }
        }
    }

    public static void proc(){
        if(N<=1){
            print();
        }
        else if(N%2==0){
            fullBomb();
        }
        else if(N%4==3){
            bomb();
        }
        else{
            secondBomb();
        }
    }

    private static void fullBomb(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                sb.append('O');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }


    private static void print(){
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(arr[i][j]==1) sb.append('O');
                else sb.append('.');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void secondBomb(){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(arr[i][j]==1){
                    for(int k=0;k<4;k++){
                        int nr=i+dr[k];
                        int nc=j+dc[k];
                        if(!valid(nr,nc)||arr[nr][nc]==1) continue;
                        arr[nr][nc]=2;
                    }
                }
            }
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(arr[i][j]==0){
                    for(int k=0;k<4;k++){
                        int nr=i+dr[k];
                        int nc=j+dc[k];
                        if(!valid(nr,nc)||arr[nr][nc]==0) continue;
                        arr[nr][nc]=3;
                    }
                }
            }
        }

        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(arr[i][j]==1||arr[i][j]==2) sb.append('O');
                else sb.append('.');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void bomb(){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(arr[i][j]==1){
                    for(int k=0;k<4;k++){
                        int nr=i+dr[k];
                        int nc=j+dc[k];
                        if(!valid(nr,nc)||arr[nr][nc]==1) continue;
                        arr[nr][nc]=2;
                    }
                }
            }
        }

        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(arr[i][j]==0) sb.append('O');
                else sb.append('.');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static boolean valid(int i, int j){
        return i>=0&&i<R&&j>=0&&j<C;
    }

}