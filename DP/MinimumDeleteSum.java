package DP;


public class MinimumDeleteSum {
    public static int minimumDeleteSum(String s1, String s2) {
        int[][] cost = new int[s1.length() + 1][s2.length() + 1];

        //Base
        cost[0][0] = 0;
        for (int i = 1; i <= s1.length(); i++) {
            int temp = (int) s1.charAt(i - 1);
            cost[i][0] = temp + cost[i - 1][0];
        }

        for (int i = 1; i <= s2.length(); i++) {
            int temp = (int) s2.charAt(i - 1);
            cost[0][i] = temp + cost[0][i - 1];
        }


        //Induction
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    cost[i][j] = cost[i - 1][j - 1];
                else cost[i][j] =
                        Math.min(Math.min(cost[i - 1][j] + s1.charAt(i - 1), cost[i][j - 1] + s2.charAt(j - 1))
                                , s1.charAt(i - 1) + s1.charAt(j - 1) + cost[i - 1][j - 1]);
            }
        }

        return cost[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "sea", s2 = "eat";
        System.out.println(minimumDeleteSum(s1, s2));
    }
}