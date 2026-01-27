import java.io.*;
import java.util.*;

public class Main {
	
	static int N, t, r, c, score=0;
	static int[][] board;
	static int greenSR=4, greenER=9, greenSC=0, greenEC=3, blueSR=0, blueER=3, blueSC=4, blueEC=9;
	
    public static void main(String[] args) throws IOException {
    	init();
    	print();
	}
    
    public static void init() throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	N=Integer.parseInt(br.readLine());
    	board=new int[10][10];
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		t=Integer.parseInt(st.nextToken());
    		r=Integer.parseInt(st.nextToken());
    		c=Integer.parseInt(st.nextToken());
    		
    		proc(t,r,c);
		}
    	
    }
    
    public static void proc(int t, int r, int c) {
    	move(t,r,c);
    	removeFill();
    	removeParticular();
//    	tempPrint(t,r,c);
    }
    
    public static void tempPrint(int t, int r, int c) {
    	System.out.println(t+" "+r+" "+c);
    	
    	for (int i = 0; i <= greenER; i++) {
			for (int j = 0; j <= blueEC; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
    }
    
    public static void print() {
    	System.out.println(score);
    	int cnt=0;
    	for (int i = 0; i <= greenER; i++) {
			for (int j = 0; j <= blueEC; j++) {
				if(board[i][j]!=0) cnt++;
			}
		}
    	System.out.println(cnt);
    }
    
    public static void removeParticular() {
    	removeParticularBlue();
    	removeParticularGreen();
    }
    
    private static boolean removeParticularGreen() {
    	int cnt=0;
    	for(int i=greenSR;i<=greenSR+1;i++) {
    		for(int j=greenSC;j<=greenEC;j++) {
    			if(board[i][j]!=0) {
    				cnt++;
    				break;
    			}
    		}
    	}
    	
    	for(int i=greenER;i>=greenER-cnt+1;i--) {
    		for(int j=greenSC;j<=greenEC;j++) {
    			int value=board[i][j];
				if(value==1) {
					board[i][j]=0;
				}
				else if(value==2) {
					board[i][j]=0;
				}
				else if(value==3) {
					board[i][j]=0;
					board[i-1][j]=1;
				}
				else if(value==4) {
					board[i][j]=0;
				}
				else if(value==5){
					board[i][j]=0;
					board[i+1][j]=1;
				}
    		}
    	}
    	
    	if(cnt==0) return false;
    	
    	int[][] temp=new int[6][4];
    	for(int i=greenSR;i<=greenER;i++) {
    		for(int j=greenSC;j<=greenEC;j++) {
    			temp[i-greenSR][j-greenSC]=board[i][j];
    			board[i][j]=0;
    		}
    	}
    	
    	for(int i=greenSR;i<=greenER-cnt;i++) {
    		for(int j=greenSC;j<=greenEC;j++) {
    			board[i+cnt][j]=temp[i-greenSR][j-greenSC];
    		}
    	}
    	
    	return cnt>0;
    }
    
    private static boolean removeParticularBlue() {
    	int cnt=0;
    	for(int i=blueSC;i<=blueSC+1;i++) {
    		for(int j=blueSR;j<=blueER;j++) {
    			if(board[j][i]!=0) {
    				cnt++;
    				break;
    			}
    		}
    	}
    	
    	for(int j=blueEC;j>=blueEC-cnt+1;j--) {
    		for(int i=blueSR;i<=blueER;i++) {
    			int value=board[i][j];
				if(value==1) {
					board[i][j]=0;
				}
				else if(value==2) {
					board[i][j]=0;
					board[i][j+1]=1;
				}
				else if(value==3) {
					board[i][j]=0;
				}
				else if(value==4) {
					board[i][j]=0;
					board[i][j-1]=1;
				}
				else if(value==5){
					board[i][j]=0;
				}
    		}
    	}
    	
    	if(cnt==0) return false;
    	
    	int[][] temp=new int[4][6];
    	for(int i=blueSR;i<=blueER;i++) {
    		for(int j=blueSC;j<=blueEC;j++) {
    			temp[i-blueSR][j-blueSC]=board[i][j];
    			board[i][j]=0;
    		}
    	}
    	
    	for(int i=blueSR;i<=blueER;i++) {
    		for(int j=blueSC;j<=blueEC-cnt;j++) {
    			board[i][j+cnt]=temp[i-blueSR][j-blueSC];
    		}
    	}
    	
    	return cnt>0;
    }
    
    public static void move(int t, int r, int c) {
    	greenMove(t,r,c);
    	blueMove(t,r,c);
    }
    
    private static void greenMove(int t, int r, int c) {
    	int sr=0;
    	for(int i=greenSR;i<=greenER;i++) {
    		if(t==1) {
    			if(board[i][c]==0) {
    				sr=i;
    			}
    			else {
    				break;
    			}
    		}
    		else if(t==2) {
    			if(board[i][c]==0&&board[i][c+1]==0) {
    				sr=i;
    			}
    			else break;
    		}
    		else {
    			if(i<greenER&&board[i][c]==0&&board[i+1][c]==0) {
    				sr=i;
    			}
    			else break;
    		}
    	}
    	
    	if(t==1) {
    		board[sr][c]=1;    		
    	}
    	else if(t==2) {
    		board[sr][c]=2;
    		board[sr][c+1]=4;
    	}
    	else {
    		board[sr][c]=5;
    		board[sr+1][c]=3;
    	}
    }
    
    private static void blueMove(int t, int r, int c) {
    	int sc=0;
    	for(int i=blueSC;i<=blueEC;i++) {
    		if(t==1) {
    			if(board[r][i]==0) sc=i;
    			else break;
    		}
    		else if(t==2) {
    			if(i<blueEC&&board[r][i]==0&&board[r][i+1]==0) sc=i;
    			else break;
    		}
    		else {
    			if(board[r][i]==0&&board[r+1][i]==0) sc=i;
    			else break;
    		}
    	}
    	
    	if(t==1) {
    		board[r][sc]=1;    		
    	}
    	else if(t==2) {
    		board[r][sc]=2;
    		board[r][sc+1]=4;
    	}
    	else {
    		board[r][sc]=5;
    		board[r+1][sc]=3;
    	}
    }
    
    public static void removeFill() { 
    	while(removeFillBlue()) {
    		score++;
    			
    	}
    	
    	while(removeFillGreen()) {
    		score++;
    	}
    	
    }
//    
//    private static void arrangeGreen() {
//    	for(int i=greenER;i>=greenSR;i--) {
//    		for(int j=greenSC;j<=greenEC;j++) {
//    			if(board[i][j]==0) {
//    				int r=i;
//    				while(r>=greenSR) {
//    					if(board[r][j]!=0) {
//    						int num=board[r][j];
//    						if(num==1) {
//    							board[i][j]=num;
//    							board[r][j]=0;
//    						}
//    						else if(num==2) {
//    							if(j<greenEC&&board[i][j+1]==0) {
//    								board[i][j]=num;
//    								board[i][j+1]=4;
//    								board[r][j]=0;
//    								board[r][j+1]=0;
//    							}
//    						}
//    						else {
//    							if(i>greenSR&&board[i-1][j]==0) {
//    								board[i][j]=num;
//    								board[i-1][j]=4;
//    								board[r][j]=0;
//    								board[r-1][j]=0;
//    							}
//    						}
//    						break;
//    					}
//    					r--;
//    				}
//    			}
//    		}
//    	}
//    }
//    
//    private static void arrangeBlue() {
//    	for(int i=blueEC;i>=blueSC;i--) {
//    		for(int j=blueSR;j<=blueER;j++) {
//    			if(board[j][i]==0) {
//    				int c=i;
//    				while(c>=blueSC) {
//    					if(board[j][c]!=0) {
//    						int num=board[j][c];
//    						if(num==1) {
//    							board[j][i]=num;
//    							board[j][c]=0;
//    						}
//    						else if(num==5) {
//    							if(i>blueSC&&board[j][i-1]==0) {
//    								board[j][i]=2;
//    								board[j][i-1]=num;
//    								board[j][c]=0;
//    								board[j][c-1]=0;
//    							}
//    						}
//    						else {
//    							if(j<blueER&&board[j+1][i]==0) {
//    								board[j-1][i]=4;
//    								board[j][i]=num;
//    								board[j-1][c]=0;
//    								board[j][c]=0;
//    							}
//    						}
//    						break;
//    					}
//    					c--;
//    				}
//    			}
//    		}
//    	}
//    }
    
    private static boolean removeFillGreen() {
    	boolean chk=false;
    	for (int i = greenSR; i <= greenER; i++) {
    		boolean temp=true;
			for(int j=greenSC; j<=greenEC; j++) {
				if(board[i][j]==0) {
					temp=false;
					break;
				}
			}
			if(temp) {
				for (int j=greenSC;j<=greenEC;j++) {
					int value=board[i][j];
					if(value==1) {
						board[i][j]=0;
					}
					else if(value==2) {
						board[i][j]=0;
					}
					else if(value==3) {
						board[i][j]=0;
						board[i-1][j]=1;
					}
					else if(value==4) {
						board[i][j]=0;
					}
					else if(value==5){
						board[i][j]=0;
						board[i+1][j]=1;
					}
					
				}
				
				int[][] arr=new int[i-greenSR][4];
				for(int a=0;a<i-greenSR;a++) {
					for (int j = greenSC; j <= greenEC; j++) {
						arr[a][j-greenSC]=board[a+greenSR][j];
						board[a+greenSR][j]=0;
					}
				}
				
				for(int a=0;a<i-greenSR;a++) {
					for (int j = greenSC; j <= greenEC; j++) {
						board[a+greenSR+1][j]=arr[a][j-greenSC];
					}
				}
				
				chk=true;
				break;
			}
		}
    	
    	return chk;
    }
    
    private static boolean removeFillBlue() {
    	boolean chk=false;
    	for(int i=blueSC;i<=blueEC;i++) {
    		boolean temp=true;
    		for(int j=blueSR;j<=blueER;j++) {
    			if(board[j][i]==0) {
    				temp=false;
    				break;
    			}
    		}
    		if(temp) {
    			for (int j=blueSR;j<=blueER;j++) {
    				int value=board[j][i];
					if(value==1) {
						board[j][i]=0;
					}
					else if(value==2) {
						board[j][i]=0;
						board[j][i+1]=1;
					}
					else if(value==3) {
						board[j][i]=0;
					}
					else if(value==4) {
						board[j][i]=0;
						board[j][i-1]=1;
					}
					else if(value==5){
						board[j][i]=0;
					}
				}
    			
    			int[][] arr=new int[4][i-blueSC];
				for(int a=0;a<i-blueSC;a++) {
					for (int j = blueSR; j <= blueER; j++) {
						arr[j-blueSR][a]=board[j][a+blueSC];
						board[j][a+blueSC]=0;
					}
				}
				
				for(int a=0;a<i-blueSC;a++) {
					for (int j = blueSR; j <= blueER; j++) {
						board[j][a+blueSC+1]=arr[j-blueSR][a];
					}
				}
    			
    			chk=true;
    			break;
    		}
    	}
    	
    	return chk;
    }
    
    
}


