import java.util.*;

class Solution {
    int N;
    
    public String[] solution(String[] files) {
        N=files.length;
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N-i-1;j++){
                String[] first=divide(files[j]);
                String[] second=divide(files[j+1]);
                
                if(compare(first, second)>0){
                    String temp=files[j];
                    files[j]=files[j+1];
                    files[j+1]=temp;
                }
            }
        }
        
        String[] answer = {};
        
        
        
        return files;
    }
    
    public int compare(String[] first, String[] second){
        String fHead=first[0].toLowerCase();
        String sHead=second[0].toLowerCase();
        if(fHead.equals(sHead)){
            int fNum=Integer.parseInt(first[1]);
            int sNum=Integer.parseInt(second[1]);
            // if(fNum==sNum){
            //     String fTail=first[2].toLowerCase();
            //     String sTail=second[2].toLowerCase();
            //     return sTail.compareTo(fTail);
            // }
            return Integer.compare(fNum,sNum);
        }
        return fHead.compareTo(sHead);
    }
    
    public String[] divide(String name){
        int len=name.length();
        String[] result=new String[3];
        int first=0, second=len;
        
        for(int i=0;i<len;i++){
            char c=name.charAt(i);
            if(c>='0'&&c<='9'){
                first=i;
                break;
            }
        }
        
        for(int i=first;i<len;i++){
            char c=name.charAt(i);
            if(!(c>='0'&&c<='9')){
                second=i;
                break;
            }
        }
        
        result[0]=name.substring(0,first);
        result[1]=name.substring(first,second);
        result[2]=name.substring(second);
        
        return result;
    }
    
}