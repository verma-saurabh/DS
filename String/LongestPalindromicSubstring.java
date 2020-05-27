package String;

import java.util.Vector;

/*
5. Longest Palindromic Substring
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        obj.longestPalindrome1(s);

    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int n = s.length();
        int start = 0, end = 0;

        for (int i = 0; i < n; i++) {
            int len1 = helper(s, i, i);
            int len2 = helper(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public int helper(String s, int left, int right) {
        int L = left, R = right;

        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }

        return R - L - 1;
    }

    public String longestPalindrome1(String s) {
        int n = s.length();
        int[] d1 = new int[s.length()];
        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int k = (i > r) ? 1 : Math.min(d1[l + r - i], r - i + 1);
            while (0 <= i - k && i + k < n && s.charAt(i - k) == s.charAt(i + k)) {
                k++;
            }
            d1[i] = k--;
            if (i + k > r) {
                l = i - k;
                r = i + k;
            }
        }

        int[] d2 = new int[s.length()];
        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int k = (i > r) ? 0 : Math.min(d2[l + r - i + 1], r - i + 1);
            while (0 <= i - k - 1 && i + k < n && s.charAt(i - k - 1) == s.charAt(i + k)) {
                k++;
            }
            d2[i] = k--;
            if (i + k > r) {
                l = i - k - 1;
                r = i + k;
            }
        }
        return "";
    }
}
