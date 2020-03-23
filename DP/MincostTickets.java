package DP;

import java.util.HashSet;
import java.util.Set;

public class MincostTickets {
    public static Set<Integer> daySet;
    public static Integer[] memo;
    public static int[] costs;

    public static int mincostTickets(int[] days, int[] costs) {
        daySet = new HashSet<>();
        memo = new Integer[366];
        for (int d : days) {
            daySet.add(d);
        }
        return dp(1);
    }

    public static int dp(int i) {
        System.out.println(i);
        if (i >= 366)
            return 0;
        if (memo[i] != null)
            return memo[i];
        int ans = 0;
        if (daySet.contains(i)) {
            ans = Math.min(dp(i + 1) + costs[0], dp(i + 7) + costs[1]);
            ans = Math.min(dp(i + 30) + costs[2], ans);
        } else {
            ans = dp(i + 1);
        }

        memo[i] = ans;
        return ans;
    }
    public static int mincostTickets1(int[] days, int[] costs) {
        boolean[] dayIncluded = new boolean[366];
        for (int day : days) {
            dayIncluded[day] = true;
        }
        int[] minCost = new int[366];
        minCost[0] = 0;
        for (int day = 1; day <= 365; ++day) {
            if (!dayIncluded[day]) {
                minCost[day] = minCost[day-1];
                continue;
            }
            int min;
            min = minCost[day-1] + costs[0];
            min =Math.min(min, minCost[Math.max(0, day-7)] + costs[1]);
            min = Math.min(min, minCost[Math.max(0, day-30)] + costs[2]);
            minCost[day] = min;
        }

        return minCost[365];

    }


    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        costs = new int[]{2, 7, 15};
        System.out.println(mincostTickets1(days, costs));
        //System.out.println(mincostTickets(days, costs));
    }
}
