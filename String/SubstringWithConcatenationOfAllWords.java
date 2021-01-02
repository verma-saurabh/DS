package String;

import java.util.*;
/**
 * 30. Substring with Concatenation of All Words
 * */

public class SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "good"};
        SubstringWithConcatenationOfAllWords obj = new SubstringWithConcatenationOfAllWords();
        obj.findSubstring_1(s, words);
    }

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, int[]> wordToCountMap = new HashMap<>();

        int wordCount = words.length;
        int[] templateOrigin = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int[] cnt = wordToCountMap.get(word);
            if (cnt == null) {
                cnt = new int[]{i, 0};
            }

            cnt[1]++;
            wordToCountMap.put(word, cnt);
            templateOrigin[cnt[0]] = cnt[1];
        }

        int n = words[0].length();

        List<Integer> result = new ArrayList<>();
        for (int k = 0; k < n; k++) {
            int[] template = Arrays.copyOf(templateOrigin, templateOrigin.length);
            int cnt = wordCount;
            Deque<int[]> deque = new LinkedList<>();
            for (int i = k; i < s.length(); i += n) {
                if (deque.size() >= wordCount) {
                    int[] rem = deque.removeFirst();
                    if (rem[1] >= 0) {
                        template[rem[1]]++;
                        if (template[rem[1]] > 0) {
                            cnt++;
                        }
                    }
                }

                if (i + n <= s.length()) {
                    String sub = s.substring(i, i + n);
                    if (!wordToCountMap.containsKey(sub)) {
                        deque.addLast(new int[]{i, -1});
                    } else {
                        int add = wordToCountMap.get(sub)[0];
                        deque.addLast(new int[]{i, add});
                        template[add]--;
                        if (template[add] >= 0) {
                            cnt--;
                            if (cnt == 0) {
                                result.add(deque.getFirst()[0]);
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    public List<Integer> findSubstring_1(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return ans;

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int wordLen = words[0].length();
        int strLen = wordLen * words.length;
        for (int i = 0; i < s.length() - strLen + 1; i++) {

            String sub = s.substring(i, i + strLen);

            String[] subStr = new String[words.length];
            int n = 0;
            for (int j = 0; j < words.length; j++) {
                subStr[j] = sub.substring(n, n + wordLen);
                n = n + wordLen;
            }

            HashMap<String, Integer> tempMap = new HashMap<>();
            for (String string : subStr) {
                tempMap.put(string, tempMap.getOrDefault(string, 0) + 1);
            }

            if (map.equals(tempMap)) {
                ans.add(i);
            }
        }
        return ans;
    }


}
