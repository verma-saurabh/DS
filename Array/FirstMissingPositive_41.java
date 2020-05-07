package Array;
/*
41. First Missing Positive
 */
public class FirstMissingPositive_41 {
    public static void main(String[] args) {
        FirstMissingPositive_41 obj = new FirstMissingPositive_41();
        int[] nums = {1,1,1};
        System.out.println(obj.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0)
            return 1;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] <= 0 || nums[i] > nums.length)
                nums[i] = nums.length + 1;

        for (int i = 0; i < nums.length; i++)
            if (Math.abs(nums[i]) != nums.length + 1) {
                int index = Math.abs(nums[i]) - 1;
                nums[index] = -1 * Math.abs(nums[index]);
            }

        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0)
                return i + 1;

        return nums.length + 1;
    }
}
