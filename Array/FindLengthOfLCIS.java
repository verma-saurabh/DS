package Array;

public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int left = 0, right = 0;
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > nums[i - 1]) {
                right = i;
            } else {
                left = i;
                right = i;
            }
            ans = Math.max(right - left + 1, ans);
        }

        return ans > 0 ? ans : 0;

    }
}
