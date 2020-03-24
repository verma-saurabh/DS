package DP;

public class LongestPalindromeSubseq {
    /*
516. Longest Palindromic Subsequence
https://medium.com/@HERMANWOO/longest-palindromic-subsequence-ab985c5bc5cb
*/
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }

        }
        return dp[0][n - 1];
    }
}
