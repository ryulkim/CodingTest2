import java.util.*;
import java.io.*;

public class Main {
    static int[] info;
    static char[] status;
    static int N;
    static int[] dir={-1,0,1};

    public static void main(String[] args) throws Exception{
        init();
    }

    public static void init() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int testCase=0;testCase<T;testCase++){
            N=Integer.parseInt(br.readLine());
            info=new int[N];
            status=new char[N];

            String s=br.readLine();
            for(int i=0;i<N;i++){
                info[i]=s.charAt(i)-'0';
            }
            s=br.readLine();
            for(int i=0;i<N;i++){
                status[i]=s.charAt(i);
            }

            proc();
        }
    }

    public static void confirm(){
        for(int i=0;i<N;i++){
            int sum=0;
            for(int k=0;k<3;k++){
                int index=i+dir[k];
                if(!valid(index)) continue;
                if(status[index]=='*'||status[index]=='#') sum++;
            }

            if(sum==info[i]){
                for(int k=0;k<3;k++){
                    int index=i+dir[k];
                    if(!valid(index)||status[index]=='.') continue;
                    status[index]='*';
                }
            }
        }

        for(int i=N-1;i>=0;i--){
            int sum=0;
            for(int k=0;k<3;k++){
                int index=i+dir[k];
                if(!valid(index)) continue;
                if(status[index]=='*'||status[index]=='#') sum++;
            }

            if(sum==info[i]){
                for(int k=0;k<3;k++){
                    int index=i+dir[k];
                    if(!valid(index)||status[index]=='.') continue;
                    status[index]='*';
                }
            }
        }
    }

    public static void greedy(){
        for(int i=0;i<N;i++){
            int value=info[i];
            int sum=0;
            for(int k=0;k<3;k++){
                int index=i+dir[k];
                if(!valid(index)) continue;
                if(status[index]=='*') value--;
            }

            if(value>0){
                for(int k=0;k<3;k++){
                    int index=i+dir[k];
                    if(!valid(index)||status[index]!='#') continue;
                    if(value>0) {
                        status[index]='*';
                        value--;
                    }
                    else{
                        status[index]='.';
                    }
                }
            }
            else{
                for(int k=0;k<3;k++){
                    int index=i+dir[k];
                    if(!valid(index)||status[index]!='#') continue;
                    status[index]='.';
                }
            }

            // print();
        }
    }

    private static void print(){
        for(int i=0;i<N;i++){
            System.out.print(status[i]);
        }
        System.out.println();
    }

    public static void proc() {
        // confirm();
        // print();
        greedy();
        // print();
        chk();
    }

    public static void chk(){
        int sum=0;
        for(int i=0;i<N;i++){
            if(status[i]=='*'){
                sum++;
            }
        }

        System.out.println(sum);
    }

    private static boolean valid(int i){
        return i>=0&&i<N;
    }
}

/*
111111
######

#*##*#
*##*#*
*/