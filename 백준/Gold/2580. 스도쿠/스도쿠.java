import java.util.*;
import java.io.*;

public class Main {
    static List<int[]> empty;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        input();
        makeSudoku(0);
    }
    
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        map = new int[9][9];
        empty = new ArrayList<>(20);
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if (map[i][j] == 0) empty.add(new int[] {i, j});
            }
        }
    }
    
    static void makeSudoku(int idx) {
        if (idx == empty.size()) {
            StringBuilder sb = new StringBuilder();
            for (int[] arr : map) {
                for (int num : arr) {
                    sb.append(num).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            
            System.exit(0);
        }
        
        int[] pos = empty.get(idx);
        for (int i = 1; i <= 9; i++) {
            if (checkHorizonDup(pos[0], i) && checkVerticalDup(pos[1], i) && checkSquareDup(getStartIdx(pos[0]), getStartIdx(pos[1]), i)) {
                map[pos[0]][pos[1]] = i;
                makeSudoku(idx + 1);
                map[pos[0]][pos[1]] = 0;
            }
        }
    }
    
    static boolean checkHorizonDup(int r, int value) {
        for (int i = 0; i < 9; i++) {
            if (map[r][i] == value) return false;
        }
        
        return true;
    }
    
    static boolean checkVerticalDup(int c, int value) {
        for (int i = 0; i < 9; i++) {
            if (map[i][c] == value) return false;
        }
        
        return true;
    }
    
    static boolean checkSquareDup(int r, int c, int value) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[r + i][c + j] == value) return false;
            }
        }
        
        return true;
    }
    
    static int getStartIdx(int num) { 
        if (num < 3) return 0;
        else if (num < 6) return 3;
        else return 6;
    }
}