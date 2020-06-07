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

    /*
    322. Coin Change
     */
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;


        for (int i = 0; i <=amount; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            for (int coin : coins) {
                if(i<=amount-coin){ //handle case when coin is Integer.MAX_VALUE
                    dp[i+coin] = Math.min(dp[i]+1, dp[i+coin]);
                }
            }

        }


        for (int i : dp) {
            System.out.println(i);
        }

        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }

        return dp[amount];

    }
}
