import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;

class Objects{
	char c;
	int idx;
	public Objects(char c, int idx) {
		super();
		this.c = c;
		this.idx = idx;
	}
}

public class Main {
	
	static int[] pos;
	static ArrayDeque<Objects> st;
	static String s, bomb;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
//    	System.out.println();
//    	proc();
    	
    
    }
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	s=br.readLine();
    	bomb=br.readLine();
    	int len=s.length();
    	int idx=0;
    	int bSize=bomb.length();
    	st=new ArrayDeque<Objects>();
    	pos=new int[len];
    	
    	for (int i = 0; i < len; i++) {
			if(!isSame(i, idx)) {
				if(isSame(i, 0)) {
					pos[i]=0;
					idx=1;
				}
				else if(st.isEmpty()) {
					pos[i]=-1;
					idx=0;
				}
				else {
					idx=pos[st.peekLast().idx]+1;
					if(isSame(i,idx)) {
						pos[i]=++idx;
					}
					else {
						pos[i]=-1;
						idx=0;
					}
				}
				
				st.add(new Objects(s.charAt(i),i));
				
//				System.out.println(i+" "+idx);
				
			}
			else if(isSame(i, idx)) {
				pos[i]=idx;
				idx++;
				
//				System.out.println(i+" "+idx);
				
				st.add(new Objects(s.charAt(i),i));
				
				if(idx==bSize) {
					explode();
					if(st.isEmpty()) idx=0;
					else idx=pos[st.peekLast().idx]+1;
				}
			}
    		
		}
    	
//    	System.out.println(idx);
    	
//    	if(!st.isEmpty()&&idx==bSize-1) {
//    		explode();
//    	}
    	
    	StringBuilder sb=new StringBuilder();
    	
    	if(st.isEmpty()) {
    		sb.append("FRULA");
    	}
    	else {
    		while(!st.isEmpty()) {
    			sb.append(st.removeFirst().c);
    		}
    	}
    	
    	System.out.println(sb);
    }
    
    public static boolean isSame(int sIdx, int bIdx) {
    	return s.charAt(sIdx)==bomb.charAt(bIdx);
    }
    
    public static void explode() {
    	int bSize=bomb.length();
    	for (int j = 0; j < bSize; j++) {
			st.removeLast();
		}
    }
    
    public static void proc() {
    	for (int i = 0; i < s.length(); i++) {
			System.out.print(pos[i]+" ");
		}
    }
    
}