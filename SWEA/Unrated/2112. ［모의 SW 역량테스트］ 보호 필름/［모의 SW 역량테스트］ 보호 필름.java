/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static int t, d, w, k, ans=500;
	public static int[][] arr, copy;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		t=Integer.parseInt(br.readLine()); 
		
		for (int testCase = 1; testCase <= t; testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine(), " ");
			d=Integer.parseInt(st.nextToken());
			w=Integer.parseInt(st.nextToken());
			k=Integer.parseInt(st.nextToken());
			arr=new int[d][w];
			copy=new int[d][w];
			ans=500;
			
			for (int i = 0; i < d; i++) {
				st=new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
					copy[i][j]=arr[i][j];
				}
			}
			
			if(d==1) {
				System.out.println("#"+testCase+" 0");
			}
			else {
				combi(0,0);
				System.out.println("#"+testCase+" "+ans);
			}
			
			
		}
	}
	
	public static void combi(int depth, int count) {
		if(ans<=count) {
			return;
		}
		if(depth==d) {
			if(inspect()&&ans>count) {
				ans=count;
			}
			return;
		}
		
		for (int i = 2; i >= 0; i--) {
			if(i==2) {
				combi(depth+1, count);
			}
			else {
				for (int j = 0; j < w; j++) {
					copy[depth][j]=i;
				}
				combi(depth+1, count+1);
				for (int j = 0; j < w; j++) {
					copy[depth][j]=arr[depth][j];
				}
			}
		}
	}
	
	public static boolean inspect() {
		int count=0;
		
		for (int i = 0; i < w; i++) {
			int seq=1;
			for (int j = 1; j < d; j++) {
				if(copy[j-1][i]==copy[j][i]) {
					seq++;
				}
				else {
					seq=1;
				}
				if(seq==k) {
					count++;
					break;
				}
			}
		}
		
		if(count==w) {
			return true;
		}
		
		return false;
	}
}