import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    
    public static int t, k;
    public static long n;
    public static char c;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        
        for (int testCase = 0; testCase < t; testCase++) {
            TreeMap<Long, Integer> tm = new TreeMap<>();
            k = sc.nextInt();
            
            for (int i = 0; i < k; i++) {
                c = sc.next().charAt(0);
                n = sc.nextLong();
                
                if (c == 'I') {
                    tm.put(n, tm.getOrDefault(n, 0) + 1);
                } else if (c == 'D') {
                    if (tm.isEmpty()) continue;
                    if (n == 1) {
                        // Delete the maximum value
                        Long key = tm.lastKey();
                        if (tm.get(key) == 1) {
                            tm.remove(key);
                        } else {
                            tm.put(key, tm.get(key) - 1);
                        }
                    } else if (n == -1) {
                        // Delete the minimum value
                        Long key = tm.firstKey();
                        if (tm.get(key) == 1) {
                            tm.remove(key);
                        } else {
                            tm.put(key, tm.get(key) - 1);
                        }
                    }
                }
            }
            
            if (tm.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(tm.lastKey() + " " + tm.firstKey());
            }
        }
        sc.close();
    }
}
