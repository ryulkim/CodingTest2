import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        init();
    }

    public static void init() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        arr=new int[5][5];

        for(int i=0;i<5;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int bingo=0;
        int idx=1;
        int ans=25;
        for(int i=0;i<5;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                int num=Integer.parseInt(st.nextToken());
                bingo+=proc(num);

                if(bingo>=3){
                    ans=Math.min(ans,idx);
                }

                // System.out.println(idx+" "+bingo);
                // print();

                idx++;
            }
        }
        
        System.out.println(ans);
    }

    public static void print(){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int proc(int num) {
        int[] info=find(num);
        return chk(info[0], info[1]);
    }

    private static int chk(int r, int c) {
        int row=1;
        for(int i=0;i<5;i++){
            if(arr[r][i]!=0) {
                row=0;
                break;
            }
        }

        int col=1;
        for(int i=0;i<5;i++){
            if(arr[i][c]!=0) {
                col=0;
                break;
            }
        }

        int diagonalRight=0;
        if(r==c){
            diagonalRight=1;
            for(int i=0;i<5;i++){
                if(arr[i][i]!=0) {
                    diagonalRight=0;
                    break;
                }
            }
        }
        
        int diagonalLeft=0;
        if(r==4-c){
            diagonalLeft=1;
            for(int i=0;i<5;i++){
                if(arr[i][4-i]!=0) {
                    diagonalLeft=0;
                    break;
                }
            }
        }

        return row+col+diagonalRight+diagonalLeft;
    }

    private static int[] find(int num) {
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(arr[i][j]==num){
                    arr[i][j]=0;
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}