import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Main {
	
	static int H, W;
	static int[] arr, ans;
	/*
	 * 물 웅덩이가 생기는 기준
	 * 전에 나 이상의 탑이 있고, 그 사이에 나보다 낮은 탑이 있을 경우
	 */
		
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    }

	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	H=Integer.parseInt(st.nextToken());
    	W=Integer.parseInt(st.nextToken());
    	arr=new int[W];
    	ans=new int[W];
    	
    	st=new StringTokenizer(br.readLine());
    	for (int i = 0; i < W; i++) {
			int x=Integer.parseInt(st.nextToken());
			arr[i]=x;
		}
    }
	
	
    public static void proc() {
    	for (int i = 0; i < W; i++) {
			for (int j = i-1; j >= 0; j--) {
				if(arr[i]<=arr[j]&&i-1>j) {
//					System.out.println(i+" "+j);
					for (int k = j; k <= i; k++) {
						ans[k]=Math.max(ans[k], arr[i]);
					}
					break;
				}
				else if(arr[i]<=arr[j]) {
					break;
				}
			}
			
			for (int j = i+1; j < W; j++) {
				if(arr[i]<=arr[j]&&i+1<j) {
					for (int k = i; k <= j; k++) {
						ans[k]=Math.max(ans[k], arr[i]);
					}
					break;
				}
				else if(arr[i]<=arr[j]) {
					break;
				}
			}
		}
    	
    	int sum=0;
    	for (int i = 0; i < W; i++) {
			sum+=Math.max(ans[i]-arr[i], 0);
		}
    	System.out.println(sum);
    }
    
    public static void print() {
    	for (int i = 0; i < W; i++) {
			System.out.print(ans[i]+" ");
		}
    	System.out.println();
    }
    
}