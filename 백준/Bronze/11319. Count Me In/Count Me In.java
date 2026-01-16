import java.io.*;
import java.util.*;

public class Main {
    static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder out = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            String s = br.readLine();

            int vowel = 0, consonant = 0;

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (!Character.isLetter(ch)) continue;

                if (isVowel(ch)) vowel++;
                else consonant++;
            }

            out.append(consonant).append(" ").append(vowel).append("\n");
        }

        System.out.print(out);
    }
}
