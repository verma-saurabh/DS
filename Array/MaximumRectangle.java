package Array;

import java.util.Arrays;

public class MaximumRectangle {
    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int res = 0;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];

        Arrays.fill(right, n);

        for (int i = 0; i < matrix.length; i++) {
            int curLeft = 0;
            int curRight = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    height[j] = 0;
                    left[j] = 0;
                    curLeft = j + 1;
                } else {
                    height[j]++;
                    left[j] = Math.max(left[j], curLeft);
                }
            }

            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '0') {
                    curRight = j;
                    right[j] = n;
                } else {
                    right[j] = Math.min(right[j], curRight);
                }
            }

            for (int j = 0; j < n; j++) {
                res = Math.max(res, (right[j] - left[j]) * height[j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(matrix));
    }
}