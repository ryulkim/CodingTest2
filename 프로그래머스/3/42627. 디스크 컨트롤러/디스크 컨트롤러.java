import java.util.*;

class Solution {
    PriorityQueue<int[]> initJob; //번호, 요청 시간, 소요시간
    PriorityQueue<int[]> waitingJob;
    int sum=0;
    
    public int solution(int[][] jobs) {
        int answer = 0;
        int len=jobs.length;
        
        init(jobs);
        proc();
        answer=sum/len;
        
        return answer;
    }
    
    void init(int[][] jobs){
        int len=jobs.length;
        initJob=new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        
        for(int i=0;i<len;i++){
            initJob.add(new int[]{i,jobs[i][0], jobs[i][1]});
        }
    }
    
    void proc(){
        waitingJob=new PriorityQueue<>((a,b)->{
            if(a[2]==b[2]&&a[1]==b[1]) return a[0]-b[0];
            if(a[2]==b[2]) return a[1]-b[1];
            return a[2]-b[2];
        });
        
        int time=initJob.peek()[1];
        // System.out.println(initJob.size());
        // waitingJob.add(initJob.poll());
        while(!initJob.isEmpty()){
            while(!initJob.isEmpty()&&initJob.peek()[1]<=time){
                int[] target=initJob.poll();
                // System.out.println(target[0]+" "+target[1]+" "+target[2]);
                waitingJob.add(target);
            }
            
            if(waitingJob.isEmpty()){
                time=initJob.peek()[1];
                continue;
            }
            int[] todo=waitingJob.poll();
            // System.out.println(todo[0]+" "+todo[1]+" "+todo[2]);
            time+=todo[2];
            sum+=(time-todo[1]);
        }
        
        while(!waitingJob.isEmpty()){
            int[] todo=waitingJob.poll();
            // System.out.println(todo[0]+" "+todo[1]+" "+todo[2]);
            time+=todo[2];
            sum+=(time-todo[1]);
        }
        
    }
    
}