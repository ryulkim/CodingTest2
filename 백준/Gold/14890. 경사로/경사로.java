import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

	static int N, L;
	static int[][] arr;
	
	static int idx=0;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    }
    
    
    public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	L=Integer.parseInt(st.nextToken());
    	arr=new int[N][N];
    	
    	for (int i = 0; i < N; i++) {
    		st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
    }
    
    public static void proc() {
    	int ans=0;
    	for (int i = 0; i < N; i++) {
    		idx=0;
    		// 가로 길 탐색
			if(availableH(i)) {
				ans++;
//				System.out.println(i);
			}
    		// 세로 길 탐색
			if(availableV(i)) {
				ans++;
//				System.out.println(i);
			}
//			else System.out.println("fail "+idx);
		}
    	System.out.println(ans);
    }
    
    public static boolean availableH(int start) {
    	boolean[] ramp=new boolean[N];
    	int put=0;
    	for (int i = 1; i < N; i++) {
    		idx=i;
    		int prev=arr[start][i-1];
    		int cur=arr[start][i];
    		
    		// 경사로 다 놓은 경우
    		if(put==L) {
    			put=0;
    		}
    		// 경사로 놓아야 하는 경우
    		// 경사로 불가능한 경우
    		// 1. 높이 차이가 1이 아닐 때
    		int depth=Math.abs(prev-cur);
    		
    		if(depth>1){
    			return false;
    		}
    		
    		// 2. 경사로를 다 두지 못했는데 또 둬야하는 경우
    		if(depth==1&&put<L&&put>0){
    			return false;
    		}
    		
    		// 3. 앞에 놓인 경사가 더 커서 둬야하는데 자리가 없거나 이미 경사각이 있는 경우, 또는 블록 길이가 다른 경우
    		if(prev<cur&&(i<L||ramp[i-L]==true||arr[start][i-L]!=prev)) {
    			return false;
    		}
    		
    		// 4. 범위 밖이어서 경사로를 못 두는 경우
    		if(prev>cur&&i+L-1>=N) {
    			return false;
    		}
    		
    		
    		// 경사로 놓기
    		if(prev<cur){
    			put=0;
    			for (int j = 1; j <= L; j++) {
					ramp[i-j]=true;
				}
    			continue;
    		}
    		else if(prev>cur) {
    			put++;
    			ramp[i]=true;
    			continue;
    		}
    		
    		if(put>0) {
    			ramp[i]=true;
    			put++;
    			continue;
    		}
    		
    		// 경사로 안 놓는 경우
    		
		}
    	
    	return true;
    }
    
    public static boolean availableV(int start) {
    	boolean[] ramp=new boolean[N];
    	int put=0;
    	for (int i = 1; i < N; i++) {
    		idx=i;
    		int prev=arr[i-1][start];
    		int cur=arr[i][start];
    		
    		// 경사로 다 놓은 경우
    		if(put==L) {
    			put=0;
    		}
    		// 경사로 놓아야 하는 경우
    		// 경사로 불가능한 경우
    		// 1. 높이 차이가 1이 아닐 때
    		int depth=Math.abs(prev-cur);
    		
    		if(depth>1){
    			return false;
    		}
    		
    		// 2. 경사로를 다 두지 못했는데 또 둬야하는 경우
    		if(depth==1&&put<L&&put>0){
    			return false;
    		}
    		
    		// 3. 앞에 놓인 경사가 더 커서 둬야하는데 자리가 없거나 이미 경사각이 있는 경우, 또는 블록 길이가 다른 경우
    		if(prev<cur&&(i<L||ramp[i-L]==true||arr[i-L][start]!=prev)) {
    			return false;
    		}
    		
    		// 4. 범위 밖이어서 경사로를 못 두는 경우
    		if(prev>cur&&i+L-1>=N) {
    			return false;
    		}
    		
    		
    		// 경사로 놓기
    		if(prev<cur){
    			put=0;
    			for (int j = 1; j <= L; j++) {
					ramp[i-j]=true;
				}
    			continue;
    		}
    		else if(prev>cur) {
    			put++;
    			ramp[i]=true;
    			continue;
    		}
    		
    		if(put>0) {
    			ramp[i]=true;
    			put++;
    			continue;
    		}
    		
    		// 경사로 안 놓는 경우
    		
		}
    	
    	return true;
    }
    
}