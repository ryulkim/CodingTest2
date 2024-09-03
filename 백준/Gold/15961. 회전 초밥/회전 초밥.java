import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 시간: 162ms	메모리: 25,428KB
 */
public class Main {
	
	static int N,d,k,c,ans,sum;
	static ArrayList<Integer> chobab;
	static int[] type;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		chobab=new ArrayList<>();
		type=new int[d+1];
		type[c]++;
		sum=1;
		
		for (int i = 0; i < N; i++) {
			int num=Integer.parseInt(br.readLine());
			chobab.add(num);
		}
		
		for (int i = 0; i < k; i++) {
			chobab.add(chobab.get(i));
		}
		
		for (int i = 0; i <k; i++) {
			int num=chobab.get(i);
			if(type[num]==0) {
				sum++;
			}
			type[num]++;
		}
		ans=sum;
		
		for (int i = 0; i < N; i++) {
			int remove=chobab.get(i);
			int plus=chobab.get(i+k);
			if(type[remove]==1) {
				sum--;
			}
			type[remove]--;
			if(type[plus]==0) {
				sum++;
			}
			type[plus]++;
			ans=Math.max(ans, sum);
		}
		
		System.out.println(ans);
		
	}
	
	

}

