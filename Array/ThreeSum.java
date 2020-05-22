package Array;

/*
15. 3Sum
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        ThreeSum obj = new ThreeSum();
        obj.threeSum(arr);
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        if (nums.length == 0 || nums == null) {
            return ans;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || !(i > 0 && nums[i] == nums[i - 1])) {
                int left = i + 1;
                int right = nums.length - 1;
                int sum = nums[i];


                while (left < right) {
                    if (sum + nums[left] + nums[right] == 0) {
                        List<Integer> match = new ArrayList<>();
                        match.add(sum);
                        match.add(nums[left]);
                        match.add(nums[right]);
                        ans.add(match);

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right - 1] == nums[right]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum + nums[left] + nums[right] > 0) {
                        right--;
                    } else if (sum + nums[left] + nums[right] < 0) {
                        left++;
                    }

                }
            }
        }

        for (List<Integer> l : ans) {
            for (int num : l) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        return ans;
    }
}
