import java.util.*;

class Solution {
    String[] times;
    int N, T, M;
    
    public String solution(int n, int t, int m, String[] timetable) {
        this.times=timetable;
        Arrays.sort(times);
        N=n; T=t; M=m;

        return proc();
    }
    
    public String proc(){
        int hour=0;
        int min=0;
        int bh=9;
        int bm=0;
        int enter=0;
        int bus=0;
        int th=0;
        int tm=0;
        
        for(int i=0;i<times.length;){
            String[] temp=times[i].split(":");
            int ch=Integer.parseInt(temp[0]);
            int cm=Integer.parseInt(temp[1]);
            
            if(bus==N){
                break;
            }
            
            if(ch<bh||(ch==bh&&cm<=bm)){
                if(th!=ch||tm!=cm){
                    hour=cm==0?ch-1:ch;
                    min=cm==0?59:cm-1;

                    th=ch;
                    tm=cm;
                }
                
                enter++;
                i++;
                if(enter==M){
                    bus++;
                    
                    bm+=T;
                    bh+=bm/60;
                    bm%=60;
                    
                    enter=0;                    
                }

                
            }
            else{
                if(enter<M){
                    hour=bh;
                    min=bm;
                }

                bus++;
                enter=0;
                
                bm+=T;
                bh+=bm/60;
                bm%=60;
            }
            
            System.out.println(ch+" "+cm+" "+hour+" "+min+" "+enter+" "+bus);
        }
        
        if(enter==M){
            bus++;
        }
        
        while(bus<N){
            hour=bh;
            min=bm;
            bus++;
            
            bm+=T;
            bh+=bm/60;
            bm%=60;
        }
        
        String ans="";
        if(hour/10==0){
            ans+="0";
        }
        ans+=hour;
        ans+=":";
        if(min/10==0){
            ans+="0";
        }
        ans+=min;
        
        
        return ans;
    }
    
    public void init(){
    }
    
}