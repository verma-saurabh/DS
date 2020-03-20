package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] answer = new int[intervals.length+1][2];
        int i = 0;
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                answer[i][0] = interval[0];
                answer[1][1] = interval[1];

            } else if (interval[0] > newInterval[1]) {
                answer[i][0] = newInterval[0];
                answer[1][1] = newInterval[1];
                newInterval = interval;

            } else if (interval[1] >= newInterval[0] || interval[0] <= newInterval[1]) {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }

        }
        answer[i][0] = newInterval[0];
        answer[i][1] = newInterval[1];

        return answer;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        System.out.println(insert(intervals, newInterval));
    }
}
