package String;

import java.util.HashSet;
import java.util.Set;

public class MorseCode {

    String encrypt[] = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};


    public int uniqueMorseRepresentations(String[] words) {

        Set<String> codes = new HashSet<String>();
        int answer = 0;
        for (String w : words) {
            String code = "";
            for (char c : w.toCharArray()) {
                code = code + encrypt[c - 'a'];
            }
            codes.add(code);
        }

        return codes.size();
    }
}
