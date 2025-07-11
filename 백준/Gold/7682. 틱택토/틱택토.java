import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	static HashSet<Integer> X, O;
	static String s;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
//    	proc();
    }
    

	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	X=new HashSet<>();
    	O=new HashSet<>();
    	
    	while(true) {
    		s=br.readLine();
    		X.clear();
    		O.clear();
    		
    		if(s.equals("end")) {
    			break;
    		}
    		
    		if(valid()) {
    			sb.append("valid\n");
    		}
    		else {
    			sb.append("invalid\n");
    		}
    	}
    	
    	System.out.println(sb);
    	
    }
	
	
    public static boolean valid() {
    	int dot=0, x=0, o=0;
    	for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='.') {
				dot++;
			}
			else if(s.charAt(i)=='X') x++;
			else o++;
		}
    	
    	if(x<o) return false;
    	else if(x>o+1) return false;
    	
    	
    	//가로
    	chk(0,1,2);
    	chk(3,4,5);
    	chk(6,7,8);
    	//세로
    	chk(0,3,6);
    	chk(1,4,7);
    	chk(2,5,8);
    	//대각선
    	chk(0,4,8);
    	chk(2,4,6);
    	
    	if(X.size()==0&&O.size()==0) {
    		if(dot==0) return true;
    		return false;
    	}
    	else if(X.size()!=0&&O.size()!=0) {
    		return false;
    	}
    	else if(X.size()!=0&&x==o+1) return true;
    	else if(O.size()!=0&&x==o) return true;
    	return false;
    }
    
    public static void chk(int a, int b, int c) { // 0: false, 1: X가 이김, 2: O가 이김, 3: 이긴 사람이 없음
    	char A=s.charAt(a);
    	char B=s.charAt(b);
    	char C=s.charAt(c);
    	if(A=='X'&&A==B&&B==C) {
    		X.add(a);
    		X.add(b);
    		X.add(c);
    	}
    	else if(A=='O'&&A==B&&B==C) {
    		O.add(a);
    		O.add(b);
    		O.add(c);
    	}
    }
    
}