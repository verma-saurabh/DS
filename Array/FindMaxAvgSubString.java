package Array;

public class FindMaxAvgSubString {

    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 3, 3};
        int k = 2;
        System.out.println(findMaxAverage(nums, k));
    }

    public static double findMaxAverage(int[] nums, int k) {

        double sum = 0;
        double finalSum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + nums[i];
        }
        finalSum = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            finalSum = Math.max(finalSum, sum);
        }
        return finalSum / k;
    }
}
