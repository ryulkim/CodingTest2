import java.util.PriorityQueue;
import java.util.Scanner;


class V implements Comparable<V>{
	int abs;
	int value;
	
	public V(int abs, int value) {
		super();
		this.abs = abs;
		this.value = value;
	}

	@Override
	public int compareTo(V v) {
		if(this.abs<v.abs) return -1;
		else if(this.abs==v.abs&&this.value<v.value) return -1;
		return 1;
	}
	
}


public class Main {
	
	public static int n, x;
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		PriorityQueue<V> pq=new PriorityQueue<V>();
		
		for (int i = 0; i < n; i++) {
			x=sc.nextInt();
			if(x==0) {
				if(pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.poll().value);
			}
			else pq.add(new V(Math.abs(x),x));
		}
	}
	
}