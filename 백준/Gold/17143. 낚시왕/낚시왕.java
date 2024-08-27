import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 시간: 432ms	메모리: 44,456KB
 */
public class Main {
	
	public static int R, C, M, ans=0;
	public static V[][] water;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		water=new V[R+1][C+1];
		
		for (int i = 0; i < M; i++) {
			int r,c,s,d,z;
			st=new StringTokenizer(br.readLine()," ");
			r=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			s=Integer.parseInt(st.nextToken());
			d=Integer.parseInt(st.nextToken());
			z=Integer.parseInt(st.nextToken());
			water[r][c]=new V(s,d,z);
		}
		
		for (int turn = 1; turn <= C; turn++) {
			for (int j = 1; j <= R; j++) {
				if(water[j][turn]!=null) {
					ans+=water[j][turn].z;
					water[j][turn]=null;
					break;
				}
			}
			
			V[][] copyWater=new V[R+1][C+1];
			
//			for (int i = 1; i <= R; i++) {
//				for (int j = 1; j <= C; j++) {
//					copyWater[i][j]=water[i][j];
//				}
//			}
			
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if(water[i][j]!=null) {
						V v=water[i][j];
						int r=i;
						int c=j;
						int tmpS=v.s;
						int go=0;
						
						while(tmpS>0) {
							if(v.d==1) {
								go=Math.min(r-1, tmpS);
								r=Math.max(r-go, 1);
								tmpS=Math.max(tmpS-go, 0);
								if(r==1) v.d=2;
							}
							else if(v.d==2) {
								go=Math.min(R-r, tmpS);
								r=Math.min(r+go, R);
								tmpS=Math.max(tmpS-go, 0);
								if(r==R) v.d=1;
							}
							else if(v.d==3) {
								go=Math.min(C-c, tmpS);
								c=Math.min(c+go, C);
								tmpS=Math.max(tmpS-go, 0);
								if(c==C) v.d=4;
							}
							else {
								go=Math.min(c-1, tmpS);
								c=Math.max(c-go, 1);
								tmpS=Math.max(tmpS-go, 0);
								if(c==1) v.d=3;
							}
						}
						
						if(copyWater[r][c]!=null) {
							if(copyWater[r][c].z<v.z) {
								copyWater[r][c]=v;								
							}
						}
						else {
							copyWater[r][c]=v;	
						}
						
					}
				}
			}
			
			
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					water[i][j]=copyWater[i][j];
				}
			}
			
		}
		
		System.out.println(ans);
		
		
		
	}
	
	
}

class V{
	int s,d,z;

	public V(int s, int d, int z) {
		super();
		this.s = s;
		this.d = d;
		this.z = z;
	}
	
}

