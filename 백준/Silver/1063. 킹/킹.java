import java.util.*;
import java.io.*;

public class Main {

    static int[] dr={-1,-1,-1,0,0,1,1,1};
    static int[] dc={-1,0,1,-1,1,-1,0,1};
    static String[] mv={"LT","T","RT","L","R","LB","B","RB"};
    static int[] kingPos, stonePos;

    public static void main(String[] args) throws Exception {
        init();
        ans();
    }

    public static void init() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        String king=st.nextToken();
        String stone=st.nextToken();
        int num=Integer.parseInt(st.nextToken());
        kingPos=parsePosition(king);
        stonePos=parsePosition(stone);

        for(int i=0;i<num;i++){
            String cmd=br.readLine();
            proc(cmd);
        }
    }

    public static void ans(){
        // System.out.println(kingPos[0]+" "+kingPos[1]);
        // System.out.println(stonePos[0]+" "+stonePos[1]);

        StringBuilder king=new StringBuilder();
        int kj=kingPos[1]+'A';
        king.append((char) kj);
        king.append(8-kingPos[0]);

        StringBuilder stone=new StringBuilder();
        stone.append((char) (stonePos[1]+'A'));
        stone.append(8-stonePos[0]);

        System.out.println(king);
        System.out.println(stone);
    }

    public static int[] parsePosition(String pos){
        int j=pos.charAt(0)-'A';
        int i=7-(pos.charAt(1)-'1');

        // System.out.println(i+" "+j);

        return new int[]{i,j};
    }

    public static void proc(String cmd){
        for(int k=0;k<8;k++){
            if(cmd.equals(mv[k])){
                move(dr[k], dc[k]);
            }
        }
    }

    public static void move(int mr, int mc) {
        int nr=kingPos[0]+mr;
        int nc=kingPos[1]+mc;

        if(!valid(nr,nc)){
            return;
        }

        if(stonePos[0]==nr&&stonePos[1]==nc){
            int snr=stonePos[0]+mr;
            int snc=stonePos[1]+mc;

            if(!valid(snr, snc)) return;

            stonePos[0]=snr;
            stonePos[1]=snc;
        }

        kingPos[0]=nr;
        kingPos[1]=nc;
    }

    private static boolean valid(int i, int j){
        return i>=0&&i<8&&j>=0&&j<8;
    }
}