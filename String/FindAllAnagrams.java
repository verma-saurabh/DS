package String;

import java.util.*;

public class FindAllAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abb";

        FindAllAnagrams obj = new FindAllAnagrams();
        obj.findAnagrams(s, p);
    }

    //If the pattern has all unique chars
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int l = p.length();

        List<Character> set = new ArrayList<>();
        for (char c : p.toCharArray()) {
            set.add(c);
        }
        for (int i = 0; i < s.length() - l+1; i++) {
            List<Character> temp = new LinkedList<>(set);
            for (int j = i; j < i + l; j++) {
                int index = p.indexOf(s.charAt(j));
                if (p.indexOf(s.charAt(j)) >= 0) {
                    temp.remove(p.charAt(index));
                }
            }
            if (temp.isEmpty()) {
                ans.add(i);
                //i = i + l - 1;
            }
        }


        return ans;
    }

    // if p has duplicate chars
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> rst = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() < p.length()) {
            return rst;
        }

        int[] map_p = new int[26];
        for (int i = 0; i < p.length(); i++) {
            map_p[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length() - p.length(); i++) {
            int[] map_s = new int[26];
            for (int j = 0; j < p.length(); j++) {
                map_s[s.charAt(i+j) - 'a']++;
            }
            if (isMatch(map_p, map_s)) {
                rst.add(i);
            }
        }
        return rst;
    }

    public boolean isMatch(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    //sliding window
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> rst = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() < p.length()) {
            return rst;
        }

        int[] map_p = new int[26];
        int[] map_s = new int[26];
        // Initialize the map / window
        for (int i = 0; i < p.length(); i++) {
            map_p[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < p.length(); i++) {
            map_s[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length() - p.length(); i++) {
            if (isMatch(map_p, map_s)) {
                rst.add(i);
            }
            // if don't match, we move the sliding window
            // remove the preceding character and add a new succeeding character to the new window
            map_s[s.charAt(i+p.length()) - 'a']++;
            map_s[s.charAt(i) - 'a']--;
        }
        if (isMatch(map_p, map_s)) {
            rst.add(s.length() - p.length());
        }
        return rst;
    }

}
