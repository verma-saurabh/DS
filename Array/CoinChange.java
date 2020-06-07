package Array;

import java.util.Arrays;

/*
518. Coin Change 2
 */
public class CoinChange {

    public int coinChange2(int[] coins, int amount) {
        int dp[] = new int[amount];
        dp[0] = 1;


        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }


        for (int i : dp) {
            System.out.println(i);
        }

        return dp[amount - 1];

    }
}
