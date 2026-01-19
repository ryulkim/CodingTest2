import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, K, R, C;
	static long[] board;
	static int[][][][] stickers;
	static int[][][] bitStickers;
	static int[][] info;
	
    public static void main(String[] args) throws IOException {
    	init();
    	proc();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	K=Integer.parseInt(st.nextToken());
    	board=new long[N];
    	stickers=new int[K][4][10][10];
    	bitStickers=new int[K][4][10];
    	info=new int[K][2];
    	
    	for (int k = 0; k < K; k++) {
    		st=new StringTokenizer(br.readLine());
    		R=Integer.parseInt(st.nextToken());
    		C=Integer.parseInt(st.nextToken());
    		info[k][0]=R;info[k][1]=C;
    		
    		for (int i = 0; i < R; i++) {
    			st=new StringTokenizer(br.readLine());    		
    			for (int j = 0; j < C; j++) {
    				int value=Integer.parseInt(st.nextToken());
    				stickers[k][0][i][j]=value;
					bitStickers[k][0][i]+=value<<j;					
    			}
    		}
		}
    	
    	rotateSticker();
    	
    }
    
    private static void convertBit() {
    	
    }
    
    public static void proc() {
    	for (int k = 0; k < K; k++) {
			for (int i = 0; i < 4; i++) {
				if(find(k,i)) {
					break;
				}
			}
		}
    	
    	int cnt=0;
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if((board[i]&1L<<j)!=0) {
					cnt++;
				}
			}
		}
    	System.out.println(cnt);
    }
    
    public static boolean find(int stickerNum, int num) {
    	int[] arr=bitStickers[stickerNum][num];
    	R=info[stickerNum][0];
    	if(num%2==1) {
    		R=info[stickerNum][1];
    	}
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				boolean chk=true;
				for (int r = 0; r < R; r++) {
					if(!valid(i+r)) {
						chk=false;
						break;
					}
					long value=((long)arr[r]<<j)&board[i+r];
					if(value!=0||((long)arr[r]<<j)>=(1L<<M)) {
						chk=false;
						break;
					}
				}
				
				if(chk) {
					for (int r = 0; r < R; r++) {
						board[i+r]|=(long)arr[r]<<j;
					}
					
					return true;
				}
			}
		}
    	
    	return false;
    }
    
    private static boolean valid(int r) {
    	return r>=0&&r<N;
    }
    
    private static void rotateSticker() {
    	for (int i = 0; i < K; i++) {
			for (int j = 0; j < 3; j++) {
				rotate90(i, j);
			}
		}
    }
    
    private static void rotate90(int stickerNum, int num) {
    	int[][] arr=stickers[stickerNum][num];
    	int r=info[stickerNum][0];
    	int c=info[stickerNum][1];
    	if(num%2==1) {
    		int temp=r;
    		r=c;
    		c=temp;
    	}
    	
    	int[][] temp=new int[10][10];
    	
    	for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				temp[j][r-i-1]=arr[i][j];
			}
		}
    	
    	for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				stickers[stickerNum][num+1][i][j]=temp[i][j];
				bitStickers[stickerNum][num+1][i]+=temp[i][j]<<j;
			}
		}
    	
    	
    }

}