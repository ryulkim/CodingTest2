import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int S, P, A, C, G, T, ans = 0;
	static int[] a,c,g,t;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	proc();
    	System.out.println(ans);
    }

	public static void init() throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	S=Integer.parseInt(st.nextToken());
    	P=Integer.parseInt(st.nextToken());
    	String s=br.readLine();
    	st=new StringTokenizer(br.readLine());
    	A=Integer.parseInt(st.nextToken());
    	C=Integer.parseInt(st.nextToken());
    	G=Integer.parseInt(st.nextToken());
    	T=Integer.parseInt(st.nextToken());
    	
    	a=new int[S+1];
    	g=new int[S+1];
    	c=new int[S+1];
    	t=new int[S+1];
    	
    	for (int i = 1; i <= S; i++) {
			char temp=s.charAt(i-1);
			
			switch (temp) {
				case 'A': {
					a[i]=a[i-1]+1;
					g[i]=g[i-1];
					c[i]=c[i-1];
					t[i]=t[i-1];
					break;
				}
				case 'C': {
					c[i]=c[i-1]+1;
					g[i]=g[i-1];
					a[i]=a[i-1];
					t[i]=t[i-1];
					break;
				}
				case 'G': {
					g[i]=g[i-1]+1;
					a[i]=a[i-1];
					c[i]=c[i-1];
					t[i]=t[i-1];
					break;
				}
				case 'T': {
					t[i]=t[i-1]+1;
					g[i]=g[i-1];
					c[i]=c[i-1];
					a[i]=a[i-1];
					break;
				}
			}
    	}
    }
    
    public static void proc() {
    	int start=1;
    	int end=P;
    	while(end<=S) {
    		if(valid(start-1, end)) {
    			ans++;
    		}
    		start++; end++;
    	}
    }
    
    public static boolean valid(int start, int end) {
    	if(a[end]-a[start]<A) return false;
    	if(g[end]-g[start]<G) return false;
    	if(t[end]-t[start]<T) return false;
    	if(c[end]-c[start]<C) return false;
    	return true;
    }
}