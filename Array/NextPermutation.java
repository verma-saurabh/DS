package Array;
/**
 * https://leetcode.com/problems/next-permutation/
 * 31. Next Permutation
 *
 * */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 5, 1};
        NextPermutation obj = new NextPermutation();
        obj.nextPermutation(nums);
    }

    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        for (int n : nums) {
            System.out.print(n + ",");
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int j = nums.length - 1;
        int i = start;

        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }

    }
}
