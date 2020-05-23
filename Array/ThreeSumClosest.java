package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] arr = {-1, 2, 1, -4};
        int target = 1;
        ThreeSumClosest obj = new ThreeSumClosest();
        System.out.println(obj.threeSumClosest(arr, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        int ans = 0;

        if (nums.length == 0 || nums == null) {
            return 0;
        }
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || !(i > 0 && nums[i] == nums[i - 1])) {
                int left = i + 1;
                int right = nums.length - 1;
                int sum = nums[i];


                while (left < right) {
                    int total = sum + nums[left] + nums[right];
                    if (total == target) {
                        return target;
                    } else if (total > target) {

                        if ((total - target) < min) {
                            min = total - target;
                            ans = total;
                        }
                        right--;
                    } else {
                        if ((target - total) < min) {
                            min = target - total;
                            ans = total;
                        }
                        left++;
                    }

                }
            }
        }
        return ans;
    }
}
