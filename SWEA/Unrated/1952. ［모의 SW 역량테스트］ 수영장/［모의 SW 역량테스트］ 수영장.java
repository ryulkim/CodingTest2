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
	public static int t, n, x, ans;
	public static String s;
	public static int[] price, plan;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		t=Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= t; testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			price=new int[4];
			plan=new int[12];
			ans=5000000;
			
			for (int i = 0; i < 4; i++) {
				price[i]=Integer.parseInt(st.nextToken());
			}
			
			st=new StringTokenizer(br.readLine()," ");
			
			for (int i = 0; i < 12; i++) {
				plan[i]=Integer.parseInt(st.nextToken());
			}
			
			back(0,0);
			
			System.out.println("#"+testCase+" "+ans);
		}
	}
	
	
	public static void back(int depth, int sum) {
		if(ans<sum) return;
		if(depth>=12) {
			ans=sum;
			return;
		}
		
		back(depth+1, sum+price[0]*plan[depth]);
		back(depth+1, sum+price[1]);
		back(depth+3, sum+price[2]);
		back(depth+12, sum+price[3]);
		
		
	}
}