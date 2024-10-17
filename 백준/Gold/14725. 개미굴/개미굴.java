import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/* 시간: 568ms  메모리: 34888kb */

public class Main {

	public static int N, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		Tri tree=new Tri();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			K=Integer.parseInt(st.nextToken());
			
			List<String> info=new ArrayList<String>();
			for (int j = 0; j < K; j++) {
				info.add(st.nextToken());
			}
			
			tree.input(info);
		}
		
		tree.print();
	}
	
}

class Tri{
	Node root;

	public Tri() {
		root=new Node("root");
	}
	
	public void input(List<String> info) {
		Node node=root;
		for (String key : info) {
			Node child=node.findChild(key);
			if(child==null) {
				node=node.addChild(key);
			}
			else node=child;
		}
	}
	
	public void print() {
		root.printChild(0);
	}
}

class Node{
	String key;
	Set<Node> child;

	public Node(String key) {
		super();
		this.key = key;
		this.child = new TreeSet<Node>((o1,o2)->{
			return o1.key.compareTo(o2.key);
		});
	}
	
	public Node findChild(String key) {
		for (Node node : child) {
			if(node.key.equals(key)) {
				return node;
			}
		}
		return null;
	}
	
	public Node addChild(String key) {
		Node node=new Node(key);
		this.child.add(node);
		
		return node;
	}
	
	public void printChild(int depth) {
		for (Node node : child) {
			for (int i = 0; i < depth; i++) {
				System.out.print("--");
			}
			System.out.println(node.key);
			node.printChild(depth+1);
		}
	}
}

