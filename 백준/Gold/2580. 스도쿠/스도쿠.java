import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/* 시간: 568ms  메모리: 34888kb */

public class Main {

	public static int[][] board, select;
	public static List<int[]> blank;
	public static int[] range = {0,3,6,9};
	public static boolean flag=false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		board=new int[9][9];
		blank=new ArrayList<int[]>();
		
		for (int i = 0; i < 9; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
				if(board[i][j]==0) {
					blank.add(new int[] {i,j});
				}
			}
		}
		
		proc(0);
		
//		for (int i = 0; i < 9; i++) {
//			for (int j = 0; j < 9; j++) {
//				System.out.print(board[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		
	}

	public static void proc(int depth) {
		if(depth==blank.size()) {
			if(flag) return;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(board[i][j]+" ");
				}
				System.out.println();
			}
			flag=true;
			return;
		}
		
		int r=blank.get(depth)[0];
		int c=blank.get(depth)[1];
		
		for (int num = 1; num <= 9; num++) {
			board[r][c]=num;
			if(chk(r,c)) {
				proc(depth+1);
			}
		}
		board[r][c]=0;
	}
	
	public static boolean chk(int r, int c) {
		boolean number[]=new boolean[10];
		//가로 췌크
		for (int i = 0; i < 9; i++) {
			if(board[r][i]==0) continue;
			if(number[board[r][i]]) {
				return false;
			}
			number[board[r][i]]=true;
		}
		number=new boolean[10];
		//세로 췌크
		for (int i = 0; i < 9; i++) {
			if(board[i][c]==0) continue;
			if(number[board[i][c]]) {
				return false;
			}
			number[board[i][c]]=true;
		}
		//네모 췌크
		if(!nemoChk(r, c)) return false;
		
		return true;
	}
	
	public static boolean nemoChk(int r, int c) {
		int fromR=0, toR=0, fromC=0, toC=0;
		boolean number[]=new boolean[10];
		
		for (int i = 0; i < 3; i++) {
			if(r>=range[i]&&r<range[i+1]) {
				fromR=range[i];
				toR=range[i+1];
			}
			if(c>=range[i]&&c<range[i+1]) {
				fromC=range[i];
				toC=range[i+1];
			}
		}
		
		for (int i = fromR; i < toR; i++) {
			for (int j = fromC; j < toC; j++) {
				if(board[i][j]==0) continue;
				if(number[board[i][j]]) {
					return false;
				}
				number[board[i][j]]=true;
			}
		}
		
		return true;
	}
	
}


class Pos{
	int i, j;

	public Pos(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}
	
}