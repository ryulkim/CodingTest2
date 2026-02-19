import java.util.*;
import java.io.*;

public class Main {

    static int N, cr, cc, cd;//동남서북
    static char[][] arr;
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0};

    public static void main(String[] args) throws Exception {
        init();
        print();
    }

    public static void init() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new char[N*2+1][N*2+1];
        for(int i=0;i<=2*N;i++){
            for(int j=0;j<=2*N;j++){
                arr[i][j]='#';
            }
        }
        cr=N;cc=N;cd=1;
        arr[cr][cc]='.';
        String s=br.readLine();
        for(int i=0;i<N;i++){
            move(s.charAt(i));
        }
    }

    private static void print(){
        int sr=0,er=2*N,sc=0,ec=2*N;
        boolean flag=false;
        for(int i=0;i<=2*N;i++){
            for(int j=0;j<=2*N;j++){
                if(arr[i][j]=='.') {
                    sr=i;
                    flag=true;
                    break;
                }
            }
            if(flag) break;
        }

        flag=false;
        for(int i=2*N;i>=0;i--){
            for(int j=0;j<=2*N;j++){
                if(arr[i][j]=='.') {
                    er=i;
                    flag=true;
                    break;
                }
            }
            if(flag) break;
        }

        flag=false;
        for(int i=0;i<=2*N;i++){
            for(int j=0;j<=2*N;j++){
                if(arr[j][i]=='.') {
                    sc=i;
                    flag=true;
                    break;
                }
            }
            if(flag) break;
        }

        flag=false;
        for(int i=2*N;i>=0;i--){
            for(int j=0;j<=2*N;j++){
                if(arr[j][i]=='.') {
                    ec=i;
                    flag=true;
                    break;
                }
            }
            if(flag) break;
        }

        StringBuilder sb=new StringBuilder();
        for(int i=sr;i<=er;i++){
            for(int j=sc;j<=ec;j++){
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void move(char cmd){
        if(cmd=='F'){
            cr=cr+dr[cd];
            cc=cc+dc[cd];
            arr[cr][cc]='.';
        }
        else if(cmd=='L'){
            cd=(cd+3)%4;
        }
        else if(cmd=='R'){
            cd=(cd+1)%4;
        }
    }
}