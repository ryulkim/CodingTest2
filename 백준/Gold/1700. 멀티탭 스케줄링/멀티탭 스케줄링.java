import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    
	static int N, K;
	static HashMap<Integer, Integer> tab;
	static int[] arr;
	static int ans=0;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
        
    	proc();
    	
//    	chk();
        
        System.out.println(ans);
        
    }
    
    public static void proc() {

    	
    	for (int i = 0; i < K; i++) {
    		if(tab.containsKey(arr[i])) { // 이미 꽂혀있다면 가만히 둔다.
    			continue;
    		}
    		else if(tab.size()<N) { // 멀티탭이 비어있는게 있다면, 넣는다.
				tab.put(arr[i], -1);
			}
			else { // 가장 나중에 걸 뺀다.
				for (int num : tab.keySet()) { // 순서 갱신
					if(tab.get(num)>i) continue; // 멀티탭에 이미 뒤에 나올 순서로 갱신 되어 있다면
					tab.put(num, -1);
					
					for (int j = i+1; j < K; j++) {
						if(arr[j]==num) {
							tab.put(num, j);
							break;
						}
					}
				}
				
				int key=0, value=0;
				// 가장 나중에 나오는 멀티탭 제거
				for (int num : tab.keySet()) {
					// 아예 안쓰이는 애가 있다면
					if(tab.get(num)==-1) {
						key=num;
						value=-1;
						break;
					}
					
					if(value<tab.get(num)) {
						key=num;
						value=tab.get(num);
					}
				}
				
				tab.remove(key);
				ans++;
				
				// 빈 공간에 넣는다.
				tab.put(arr[i], -1);
			}
		}
    }
    
    public static void init() throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr=new int[K];
        tab=new HashMap<>();
        
        st=new StringTokenizer(br.readLine());
        
        for (int i = 0; i < K; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
    }
}