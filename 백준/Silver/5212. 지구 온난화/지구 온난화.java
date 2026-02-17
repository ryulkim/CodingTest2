import java.util.*;
import java.io.*;

public class Main {

    static int R, C;
    static char arr[][];
    static int[] dr={0,0,1,-1};
    static int[] dc={1,-1,0,0};

    public static void main(String[] args) throws Exception {
        init();
        after50();
        ans();
    }

    public static void init() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        arr=new char[R][C];
        
        for(int i=0;i<R;i++){
            String s=br.readLine();
            for(int j=0;j<C;j++){
                char c=s.charAt(j);
                arr[i][j]=c;
            }
        }
    }

    public static void ans(){
        int sr=0,sc=0,er=R-1,ec=C-1;
        boolean flag=false;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(arr[i][j]=='X'){
                    flag=true;
                    break;
                }
            }
            if(flag) break;
            sr=i+1;
        }

        flag=false;
        for(int i=R-1;i>=0;i--){
            for(int j=0;j<C;j++){
                if(arr[i][j]=='X'){
                    flag=true;
                    break;
                }
            }
            if(flag) break;
            er=i-1;
        }

        flag=false;
        for(int j=0;j<C;j++){
            for(int i=0;i<R;i++){
                if(arr[i][j]=='X'){
                    flag=true;
                    break;
                }
            }
            if(flag) break;
            sc=j+1;
        }

        flag=false;
        for(int j=C-1;j>=0;j--){
            for(int i=0;i<R;i++){
                if(arr[i][j]=='X'){
                    flag=true;
                    break;
                }
            }
            if(flag) break;
            ec=j-1;
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

    public static void after50(){
        char[][] temp=new char[R][C];
        for(int i=0;i<R;i++){
            temp[i]=arr[i].clone();
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                char c=arr[i][j];
                if(c=='X'){
                    int cnt=0;
                    for(int k=0;k<4;k++){
                        int nr=i+dr[k];
                        int nc=j+dc[k];

                        if(!valid(nr,nc)){
                            cnt++;
                            continue;
                        }

                        if(arr[nr][nc]=='.') cnt++;
                    }
                    if(cnt>=3){
                        temp[i][j]='.';
                    }
                }
            }
        }

        arr=temp;
    }

    private static boolean valid(int i, int j){
        return i>=0&&i<R&&j>=0&&j<C;
    }
}