import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
	
	static int N, T;
	static int[][][] cube;
	static char[] color= {'w','r','g','y','o','b'}; // 위, 앞, 왼, 아래, 뒤, 오른
	static Map<Character, Integer> m = Map.of (
		'U',0,'F',1,'L',2,'D',3,'B',4,'R',5,'+',1,'-',-1
	);
	static int[][] roll= {
			{10,11,12,20,21,22,40,41,42,50,51,52},
			{6,7,8,50,53,56,32,31,30,28,25,22},
			{0,3,6,10,13,16,30,33,36,48,45,42},
			{16,17,18,56,57,58,46,47,48,26,27,28},
			{0,1,2,26,23,20,38,37,36,52,55,58},
			{8,5,2,40,43,46,38,35,32,18,15,12}
	};
	static char[] arr;
	
	/*
	 * 윗 => 아랫면 제외
	 * 아랫면 => 윗면 제외
	 * 앞면 => 뒷면 제외
	 * 왼쪽면 =>오른쪽면 제외
	 * 오른면 => 왼쪽면 제외
	 * 뒷면 => 앞면 제외
	 * 
	 * 윗, 앞, 왼, 아래, 뒤, 오른
	 * w, r, g, y, o, b
	 * 0, 1, 2, 3, 4, 5
	 */


    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
//    	System.out.println(rotateInfo[0][1][0]);
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	T=Integer.parseInt(br.readLine());
    	cube=new int[6][3][3];
    	cubeInit();
    	arr=new char[60];
    	StringBuilder sb=new StringBuilder();
    	
    	for (int testCase = 0; testCase < T; testCase++) {
			N=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine());
			arrInit();
			
			for (int i = 0; i < N; i++) {
				String cmd=st.nextToken();
//				System.out.println(cmd);
				proc(cmd.charAt(0), cmd.charAt(1));
			}
			print(sb);
		}
    	System.out.println(sb);
    }
    
    public static void print(StringBuilder sb) {
    	
//    	for (int i = 0; i < 6; i++) {
    		for (int j = 0; j < 3; j++) {
    			for (int k = 0; k < 3; k++) {
    				sb.append((char) arr[cube[0][j][k]]);
    			}
    			sb.append("\n");
    		}
//		}
    }
    
    public static void arrInit() {
    	for (int i = 0; i < 6; i++) {
			for (int j = i*10; j < i*10+10; j++) {
				arr[j]=color[i];
			}
		}
    }
    
    public static void cubeInit() {
    	for (int i = 0; i < 6; i++) {
    		int cnt=0+i*10;
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					cube[i][j][k]=cnt++;
				}
			}
		}
    }
     
    public static void proc(char position, char direct) {
    	int idx=m.get(position);
    	int dir=m.get(direct);
    	
//    	System.out.println(idx+" "+dir);
    	
    	clockFac(idx,dir);
		rotate(idx, dir);
    }
    
    public static void rotate(int idx, int dir) {
    	char[] temp=new char[12];
    	
    	for (int i = 0; i < 12; i++) {
			temp[i]=arr[roll[idx][i]];
		}
    	if (dir == 1) { // 시계 방향
            for (int i = 0; i < 12; i++) {
                arr[roll[idx][i]] = temp[(i + 9) % 12];
            }
        } else { // 반시계 방향
            for (int i = 0; i < 12; i++) {
                arr[roll[idx][i]] = temp[(i + 3) % 12];
            }
        }
    }
    
    public static void clockFac(int idx, int dir) {
    	if(dir==1) {
    		clock(idx);
    	}
    	else {
    		rClock(idx);
    	}
    }

    public static void clock(int idx) {
    	char[][] temp=new char[3][3];
    	
    	for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				temp[j][2-i]=arr[cube[idx][i][j]];
			}
		}
    	
    	for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr[cube[idx][i][j]]=temp[i][j];
			}
		}
    }
    
    public static void rClock(int idx) {
    	char[][] temp=new char[3][3];
    	
    	for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				temp[2-j][i]=arr[cube[idx][i][j]];
			}
		}
    	
    	for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr[cube[idx][i][j]]=temp[i][j];
			}
		}
    }
}