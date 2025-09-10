import java.util.*;

class Solution {
    TreeMap<Integer, Integer> times; // String → Integer
    int N, T, M, bh = 9, bm = 0, bus = 0;
    
    public String solution(int n, int t, int m, String[] timetable) {
        times = new TreeMap<>();
        for (String time : timetable) {
            int key = toMinute(time); // 직접 파싱
            times.put(key, times.getOrDefault(key, 0) + 1);
        }
        N = n; T = t; M = m;

        return proc();
    }
    
    public String proc() {
        int hour = 0;
        int min = 0;
        int enter = 0;
        
        for (Map.Entry<Integer, Integer> info : times.entrySet()) {
            int ch = info.getKey() / 60;
            int cm = info.getKey() % 60;
            int value = info.getValue();
            
            while (ch > bh || (ch == bh && cm > bm)) {
                if (bus >= N - 1) {
                    return convert(bh, bm);
                }
                calculateBus(1);
                enter = 0;
            }
            
            enter += value;
            calculateBus(enter / M);
            enter %= M;
            
            if (bus >= N) {
                hour = cm == 0 ? ch - 1 : ch;
                min  = cm == 0 ? 59 : cm - 1;
                return convert(hour, min);
            }
        }
        
        if (enter == M) {
            bus++;
        }
        
        while (bus < N) {
            hour = bh;
            min  = bm;
            bus++;
            
            calculateBus(1);
        }
        
        return convert(hour, min);
    }
    
    // HH:MM → 분
    private int toMinute(String s) {
        int h = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
        int m = (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');
        return h * 60 + m;
    }

    public String convert(int h, int m) {
        String ans = "";
        if (h / 10 == 0) ans += "0";
        ans += h;
        ans += ":";
        if (m / 10 == 0) ans += "0";
        ans += m;
        return ans;
    }
    
    public void calculateBus(int cnt) {
        bus += cnt;
        bm += T * cnt;
        bh += bm / 60;
        bm %= 60;
    }
}
