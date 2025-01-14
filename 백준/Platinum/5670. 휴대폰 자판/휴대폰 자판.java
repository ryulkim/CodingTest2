import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder result = new StringBuilder();

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            N = Integer.parseInt(line);
            Trie trie = new Trie();
            int totalKeyPresses = 0;

            for (int i = 0; i < N; i++) {
                String word = br.readLine();
                trie.add(word);
            }

            for (String word : trie.words) {
                totalKeyPresses += trie.countKeyPresses(word);
            }

            result.append(String.format("%.2f\n", (double) totalKeyPresses / N));
        }

        System.out.print(result);
    }
}

class Trie {
    Node root;
    List<String> words; // 단어 목록 저장

    public Trie() {
        root = new Node();
        words = new ArrayList<>();
    }

    public void add(String word) {
        Node current = root;
        words.add(word); // 단어 저장

        for (char c : word.toCharArray()) {
            current = current.children.computeIfAbsent(c, k -> new Node());
        }
        current.isEndOfWord = true;
    }

    public int countKeyPresses(String word) {
        Node current = root;
        int keyPresses = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            // 버튼을 눌러야 하는 경우
            if (i == 0 || current.children.size() > 1 || current.isEndOfWord) {
                keyPresses++;
            }

            current = current.children.get(c);
        }

        return keyPresses;
    }
}

class Node {
    Map<Character, Node> children;
    boolean isEndOfWord;

    public Node() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}
