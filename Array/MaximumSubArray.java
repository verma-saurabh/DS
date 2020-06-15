package Array;

import java.util.Map;

/*
53. Maximum Subarray
 */
public class MaximumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(MaximumSubArray.maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (max < sum) max = sum;

            if (sum < 0) sum = 0;
        }
        return max;
    }
}
