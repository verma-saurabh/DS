package String;

/**
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flow", "flower", "flight"};

        LongestCommonPrefix obj = new LongestCommonPrefix();
        System.out.printf(obj.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public String longestCommonPrefixUsingDC(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        return helper(strs, 0, strs.length - 1);

    }

    public String helper(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        } else {
            int mid = (left + right) / 2;
            String lcpLeft = helper(strs, left, mid);
            String lcpRight = helper(strs, 1 + mid, right);
            return findCommonPrefix(lcpLeft, lcpRight);
        }
    }

    public String findCommonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }
}
