import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws Exception{
        init();
        System.out.println(proc(0,0,N,N));
    }

    public static void init() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<N;j++){
                arr[i][j]=s.charAt(j)-'0';
            }
        }
    }

    public static String proc(int sr, int sc, int er, int ec) {
        boolean flag=true;
        int num=arr[sr][sc];

        for(int i=sr;i<er;i++){
            for(int j=sc;j<ec;j++){
                if(num!=arr[i][j]){
                    flag=false;
                }
            }
        }

        if(flag==true){
            return String.valueOf(num);
        }

        int mr=(sr+er)/2;
        int mc=(sc+ec)/2;
        String first=proc(sr,sc,mr,mc);
        String second=proc(sr,mc,mr,ec);
        String third=proc(mr,sc,er,mc);
        String fourth=proc(mr,mc,er,ec);
        return "("+first+second+third+fourth+")";
    }

}