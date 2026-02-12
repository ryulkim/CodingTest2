import java.util.*;
import java.io.*;

public class Main {
    
    static int N, W, L, sum=0;
    static int[] truck, bridge;

    public static void main(String[] args) throws Exception {
        init();
        proc();
    }

    public static void init() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        W=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());

        truck=new int[N];
        bridge=new int[W];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            truck[i]=Integer.parseInt(st.nextToken());
        }
    }

    public static void print(){
        for(int i=0;i<W;i++){
            System.out.print(bridge[i]+" ");
        }
        System.out.println();
    }

    public static void proc() {
        int truckIdx=0;
        int time=0;
        while(truckIdx<N){
            time++;
            go();
            if(enter(truck[truckIdx])) truckIdx++;

            // System.out.println(time+" "+sum+" "+truckIdx);
            // print();
        }
        
        time+=W;

        System.out.println(time);
    }

    private static void go(){
        sum-=bridge[0];
        for(int i=1;i<W;i++){
            bridge[i-1]=bridge[i];
        }
        bridge[W-1]=0;
    }

    private static boolean enter(int weight){
        if(sum+weight<=L){
            sum+=weight;
            bridge[W-1]=weight;
            return true;
        }
        return false;
    }
}