import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws Exception{
        init();
        System.out.println(proc(0,0,N));
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

    public static String proc(int sr, int sc, int sz) {
        if(sz==1){
            return String.valueOf(arr[sr][sc]);
        }

        String first=proc(sr,sc,sz/2);
        String second=proc(sr,sc+sz/2,sz/2);
        String third=proc(sr+sz/2,sc,sz/2);
        String fourth=proc(sr+sz/2,sc+sz/2,sz/2);

        String ans="("+first+second+third+fourth+")";
        // System.out.println(ans);

        if(first.equals("0")&&second.equals("0")&&third.equals("0")&&fourth.equals("0")){
            ans="0";
        }
        else if(first.equals("1")&&second.equals("1")&&third.equals("1")&&fourth.equals("1")){
            ans="1";
        }
        // System.out.println(sr+" "+sc+" "+ans+" "+sz);


        return ans;
    }

}