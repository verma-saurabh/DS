package DP;

public class CountSquares {


    /*
     1277. Count Square Submatrices with All Ones
    https://www.cnblogs.com/wentiliangkaihua/p/11981497.html

    */
    public int countSquares(int[][] matrix) {
        int r = matrix.length;
        int c = r > 0 ? matrix[0].length : 0;
        if(r == 0 || c == 0) return 0;
        int res = 0;

        int[][] dp = new int[r+1][c+1];
        for(int i = 1; i <= r; i++){
            for(int j = 1; j <= c; j++){
                if(matrix[i-1][j-1] == 1){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + 1;
                }
                if(dp[i][j] != 0) res += dp[i][j];
            }
        }
        return res;
    }
}
