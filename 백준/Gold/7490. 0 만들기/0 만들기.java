import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	static int T, N;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    }
    

	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	T=Integer.parseInt(br.readLine());
    	ArrayList<String> ans=new ArrayList<>();
    	
    	for (int testCase = 0; testCase < T; testCase++) {
    		N=Integer.parseInt(br.readLine());
    		ans.clear();
			proc(2, "1", ans);
			
			ans.sort((a,b)->a.compareTo(b));
			
			for (String string : ans) {
				sb.append(string).append("\n");
			}
			sb.append("\n");
		}
    	
    	System.out.println(sb);
    }
	
	public static void proc(int num, String cmd, ArrayList<String> sb) {
		if(num>N) {
			if(calculate(cmd)) {
				sb.add(cmd);
			}
			return;
		}
		
		proc(num+1, cmd+"+"+num, sb);
		proc(num+1, cmd+"-"+num, sb);
		proc(num+1, cmd+" "+num, sb);
	}
	
	public static boolean calculate(String formul) {
		int ans=0;
		int cmd=-1;
		
		for (int i = 0; i < formul.length();) {
			int temp=getCmd(formul.charAt(i));
			if(temp!=3) {
				cmd=temp;
				i++;
			}
			else {
				String s="";
				while(i<formul.length()) {
					int temp1=getCmd(formul.charAt(i));
					if(temp1<2) break;
					if(temp1==2) {
						i++;
						continue;
					}
					s+=formul.charAt(i++);
				}
				if(cmd==-1) {
					ans+=Integer.parseInt(s);
				}
				else if(cmd==0) {
					ans+=Integer.parseInt(s);
				}
				else if(cmd==1) {
					ans-=Integer.parseInt(s);
				}
			}
		}
		
		
		if(ans==0) return true;
		return false;
	}
	
	public static int getCmd(char c) {
		if(c=='+') {
			return 0;
		}
		else if(c=='-') {
			return 1;
		}
		else if(c==' ') {
			return 2;
		}
		return 3;
	}
	
}