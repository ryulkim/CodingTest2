import java.util.*;
import java.io.*;

public class Main {

    static int N, M, cnt = 0;
    static char[][] arr, temp;
    static ArrayList<int[]> ans;
    static int[] dr={0,0,1,-1};
    static int[] dc={1,-1,0,0};

    public static void main(String[] args) throws Exception {
        init();
        proc();
        printAns();
    }

    public static void init() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new char[N][M];
        temp=new char[N][M];
        ans=new ArrayList<>();

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j]=s.charAt(j);
                temp[i][j]='.';
            }
        }
    }

    public static void proc(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]=='.') continue;
                putStar(i,j);
            }
        }
    }

    public static void printAns(){
        boolean isSame=true;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]!=temp[i][j]) {
                    isSame=false;
                    break;
                }
            }
            if(!isSame) break;
        }
        if(!isSame) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb=new StringBuilder();
        int num=ans.size();
        sb.append(num).append('\n');

        for(int i=0;i<num;i++){
            int[] info=ans.get(i);
            sb.append(info[0]).append(' ').append(info[1]).append(' ').append(info[2]).append('\n');
        }

        System.out.println(sb);
    }

    public static void putStar(int r, int c){
        for(int i=1;i<=100;i++){
            boolean chk=true;
            for(int k=0;k<4;k++){
                int nr=r+i*dr[k];
                int nc=c+i*dc[k];

                if(!valid(nr,nc)||arr[nr][nc]=='.') {
                    chk=false;
                    break;
                }
            }

            if(chk){
                temp[r][c]='*';
                for(int k=0;k<4;k++){
                    int nr=r+i*dr[k];
                    int nc=c+i*dc[k];

                    temp[nr][nc]='*';
                }
            }
            else if(i>1){
                ans.add(new int[]{r+1,c+1,i-1});
                break;
            }
            else{
                break;
            }
        }
    }

    private static void print(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(temp[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean valid(int i, int j){
        return i>=0&&i<N&&j>=0&&j<M;
    }
}