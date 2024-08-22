import java.util.*;

class V implements Comparable<V>{
	int weight;
	int price;
	
	public V(int weight, int price) {
		super();
		this.weight = weight;
		this.price = price;
	}
	@Override
	public int compareTo(V o) {
		if(this.price==o.price) return o.weight-this.weight;
		return o.price-this.price;
	}
}

public class Main {
	
	public static int jewelyCnt, bagCnt, weight, price, maxWeight;

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		List<V> jewelries = new ArrayList<>();
		List<Integer> bags=new ArrayList<>();
		PriorityQueue<V> possible=new PriorityQueue<>();

		jewelyCnt=sc.nextInt();
		bagCnt=sc.nextInt();
		
		for (int i = 0; i < jewelyCnt; i++) {
			weight=sc.nextInt();
			price=sc.nextInt();
			
			jewelries.add(new V(weight, price));
		}
		
		for (int i = 0; i < bagCnt; i++) {
			weight=sc.nextInt();
			
			bags.add(weight);
		}
		
		Collections.sort(jewelries, (a,b)->{
			if(a.weight==b.weight) return a.price-b.price;
			return a.weight-b.weight;
			});
		Collections.sort(bags);
		
		int idx=0;
        long ans=0;
		V v=jewelries.get(idx);
		
		for (int i = 0; i < bagCnt; i++) {
			while (idx<jewelyCnt&&jewelries.get(idx).weight<=bags.get(i)) {				
				v=jewelries.get(idx++);
				possible.add(new V(v.weight, v.price));
			}
			if(!possible.isEmpty()) {
				ans+=possible.poll().price;
			}
		}
		
		System.out.println(ans);
	}

}
