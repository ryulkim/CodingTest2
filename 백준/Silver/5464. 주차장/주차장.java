import java.util.*;
import java.io.*;

public class Main {

    static int N, M, ans=0;
    static int[] costs, weights, parks;
    static ArrayDeque<Integer> waiting;

    public static void main(String[] args) throws Exception {
        init();
    }

    public static void init() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        costs=new int[N+1];
        weights=new int[M+1];
        parks=new int[N+1];
        waiting=new ArrayDeque<>();

        for(int i=1;i<=N;i++){
            costs[i]=Integer.parseInt(br.readLine());
        }

        for(int i=1;i<=M;i++){
            weights[i]=Integer.parseInt(br.readLine());
        }

        for(int i=0;i<2*M;i++){
            int num=Integer.parseInt(br.readLine());
            if(num>=0){
                enter(num);
            }
            else{
                out(-num);
            }
            // print();
            // System.out.println(ans);
        }

        System.out.println(ans);
    }

    public static void print(){
        for(int i=1;i<=N;i++){
            System.out.print(parks[i]+" ");
        }
        System.out.println();
    }

    public static void enter(int num){
        for(int i=1;i<=N;i++){
            if(parks[i]==0){
                parks[i]=num;
                ans+=costs[i]*weights[num];
                return;
            }
        }

        waiting.addLast(num);
    }

    public static void out(int num){
        for(int i=1;i<=N;i++){
            if(parks[i]==num){
                parks[i]=0;
                if(!waiting.isEmpty()){
                    int value=waiting.poll();
                    parks[i]=value;
                    ans+=costs[i]*weights[value];
                    return;
                }
            }
        }
    }

    
}