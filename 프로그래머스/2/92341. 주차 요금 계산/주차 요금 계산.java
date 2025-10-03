import java.util.*;

class Solution {
    int rLen, endTime=23*60+59;
    HashMap<Integer, Integer> times, in;
    TreeMap<Integer, Integer> ans;
    int[] fees;
    
    public int[] solution(int[] fees, String[] records) {
        rLen=records.length;
        times=new HashMap<>();
        in=new HashMap<>();
        ans=new TreeMap<>();
        this.fees=fees;
        
        for(int i=0;i<rLen;i++){
            proc(records[i]);
            
            
        }
        
        for(Map.Entry<Integer, Integer> entry : in.entrySet()){
            int carNumber=entry.getKey();
            int inTime=entry.getValue();
            
            // System.out.println("remain: "+carNumber+" "+inTime);
            
            times.put(carNumber, times.getOrDefault(carNumber, 0)+(endTime-inTime));
        }
        
        calculate();
        
        int[] answer = new int[ans.size()];
        int i=0;
        for(Map.Entry<Integer, Integer> entry : ans.entrySet()){
            answer[i++]=entry.getValue();
        }
        
        return answer;
    }
    
    public void calculate(){
        for(Map.Entry<Integer, Integer> entry : times.entrySet()){
            int key=entry.getKey();
            int value=entry.getValue();
            
            // System.out.println(key+" "+value);
            
            if(value<=fees[0]){
                ans.put(key, fees[1]);
            }
            else{
                int total=fees[1];
                int extra=(value-fees[0])/fees[2];
                if(((value-fees[0])%fees[2])>0){
                    extra++;
                }
                total+=extra*fees[3];
                ans.put(key, total);
            }
        }        
    }
    
    public void proc(String record){
        String[] info=record.split(" ");
        int carNumber=Integer.parseInt(info[1]);
        
        if(info[2].equals("IN")){
            in.put(carNumber, convertMinute(info[0]));
        }
        else{
            int inTime=in.get(carNumber);
            int outTime=convertMinute(info[0]);
            times.put(carNumber, times.getOrDefault(carNumber, 0)+(outTime-inTime));
            in.remove(carNumber);
        }
        
        
    }
    
    public int convertMinute(String time){
        int hour=Integer.parseInt(time.substring(0, 2));
        int minute=Integer.parseInt(time.substring(3, 5));
        
        return hour*60+minute;
    }
}