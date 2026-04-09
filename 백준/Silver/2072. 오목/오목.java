import java.util.*;
import java.io.*;

public class Main {

    static int N, K;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        init();
    }

    public static void init() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        N=Integer.parseInt(br.readLine());
        arr=new int[20][20];

        boolean chk=false;
        
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());

            if(chk) continue;

            if(i%2==0){
                arr[r][c]=1;
            }
            else{
                arr[r][c]=-1;
            }
            if(proc(r,c,arr[r][c])){
                chk=true;
                System.out.println(i+1);
            }

            //print();
        }

        if(!chk) System.out.println(-1);
    }

    public static void print(){
        for(int i=0;i<20;i++){
            for(int j=0;j<20;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean proc(int r, int c, int value){
        return row(r,c,value)||col(r,c,value)||left(r,c,value)||right(r,c,value);
    }
    
    public static boolean row(int r, int c, int value){
        int sum=0;
        int idx=c;

        while(c>0) {
            c--;
            if(arr[r][c]!=value) {
                break;
            }
            sum++;
        }

        c=idx;

        while(c<19) {
            c++;
            if(arr[r][c]!=value) {
                break;
            }
            sum++;
        }
        return sum==4;
    }

    public static boolean col(int r, int c, int value){
        int sum=0;
        int idx=r;
        while(r>0){
            r--;
            if(arr[r][c]!=value){
                break;
            }
            sum++;
        }

        r=idx;

        while(r<19){
            r++;
            if(arr[r][c]!=value){
                break;
            }
            sum++;
        }

        return sum==4;
    }

    public static boolean left(int r, int c, int value){
        int sum=0;
        int tempR=r;
        int tempC=c;

        while(r>0&&c>0){
            r--;c--;
            if(arr[r][c]!=value){
                break;
            }
            sum++;
        }

        r=tempR;
        c=tempC;

        while(r<19&&c<19){
            r++;c++;
            if(arr[r][c]!=value){
                break;
            }
            sum++;
        }

        return sum==4;
    }

    public static boolean right(int r, int c, int value){
        int sum=0;
        int tempR=r;
        int tempC=c;
        while(r>0&&c<19){
            r--;c++;
            if(arr[r][c]!=value){
                break;
            }
            sum++;
        }

        r=tempR;
        c=tempC;

        while(r<19&&c>0){
            r++;c--;
            if(arr[r][c]!=value){
                break;
            }
            sum++;
        }

        return sum==4;
    }
}