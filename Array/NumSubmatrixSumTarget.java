package Array;

import java.util.HashMap;
import java.util.Map;

/*
 * 1074. Number of Submatrices That Sum to Target
 *
 * */
class NumSubmatrixSumTarget {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        int target = 0;
        System.out.println(numSubmatrixSumTarget(matrix, target));
    }

    public static int numSubmatrixSumTarget(int[][] d, int target) {
        if (d.length == 0 || d[0].length == 0) return 0;
        int m = d.length, n = d[0].length, res = 0;
        int[][] sum = new int[m][n + 1];
        for (int k = 0; k < m; k++) {
            for (int i = 0; i < n; i++) {
                sum[k][i + 1] = d[k][i] + sum[k][i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int cur = 0;
                Map<Integer, Integer> map = new HashMap();
                map.put(0, 1);
                for (int k = 0; k < m; k++) {
                    cur += sum[k][j + 1] - sum[k][i];
                    if (map.containsKey(cur - target)) {
                        res += map.get(cur - target);
                    }
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }
}