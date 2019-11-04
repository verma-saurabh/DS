package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAndReplacePattern {
    public static void main(String[] args) {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";

        System.out.println(FindAndReplacePattern.findAndReplacePattern(words, pattern));
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < pattern.length(); i++) {

        }
        for (String word : words) {
            HashMap<Character, Character> map = new HashMap<>();
            boolean isPattern = true;
            for (int i = 0; i < word.toCharArray().length; i++) {
                if (map.get(pattern.charAt(i)) == null) {
                    map.put(pattern.charAt(i), word.charAt(i));
                } else if (map.get(pattern.charAt(i)) != word.charAt(i)) {
                    isPattern = false;
                }
            }
            boolean[] seen = new boolean[26];
            for(char p:map.values()){
                if (seen[p - 'a']) isPattern = false;
                seen[p - 'a'] = true;
            }
            if (isPattern) {
                answer.add(word);
            }
        }
        return answer;
    }
}
