package Array;

/*
1029. Two City Scheduling
 */
import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        int ans = 0;

        Comparator<int[]> co = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Math.abs(b[1] - b[0]) - Math.abs(a[1] - a[0]);
            }
        };

        Arrays.sort(costs, co);

        int countA = 0, countB = 0, n = costs.length / 2;

        for (int i = 0; i < costs.length; i++) {
            if (countA < n && countB < n) {
                if (costs[i][0] < costs[i][1]) {
                    countA++;
                    ans += costs[i][0];
                } else {
                    countB++;
                    ans += costs[i][1];
                }
            } else if (countA < n) {
                countA++;
                ans += costs[i][0];
            } else if (countB < n) {
                countB++;
                ans += costs[i][1];
            }
        }
        return ans;
    }
}
