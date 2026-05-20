import java.util.*;

class Solution {
    
    Map<Integer, Integer> hubo;
    int[] course;
    int courseSZ;
    
    public String[] solution(String[] orders, int[] course) {
        hubo=new HashMap<>();
        this.course=course;
        this.courseSZ=course.length;
        for(String order : orders){
            makeHubo(order, 0, order.length(), 0, 0, 0);
        }
        String[] answer = makeAns();
        return answer;
    }
    
    private String[] makeAns(){
        List<String> ans=new ArrayList<>();
        int[] cnt=new int[11];
        
        for(Map.Entry<Integer, Integer> entry: hubo.entrySet()){
            if(entry.getValue()<2) continue;
            String s=convertToString(entry.getKey());
            int len=s.length();
            cnt[len]=Math.max(cnt[len], entry.getValue());
        }
        
        for(Map.Entry<Integer, Integer> entry: hubo.entrySet()){
            String s=convertToString(entry.getKey());
            int len=s.length();
            if(entry.getValue()!=cnt[len]) continue;
            ans.add(s);
        }
        
        ans.sort((a,b)->a.compareTo(b));
        return ans.toArray(new String[0]);
    }
    
    private String convertToString(int value){
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<26;i++){
            if((value&(1<<i))!=0){
                sb.append((char)('A'+i));
            }
        }
        
        return sb.toString();
    }
    
    private void makeHubo(String order, int start, int end, int cnt, int cIdx, int value){
        if(cIdx==courseSZ) return;
        else if(cnt==course[cIdx]){
            hubo.put(value, hubo.getOrDefault(value, 0)+1);
            cIdx++;
        }
        
        for(int i=start;i<end;i++){
            int idx=order.charAt(i)-'A';
            makeHubo(order, i+1, end, cnt+1, cIdx, value|(1<<idx));
        }
    }
}