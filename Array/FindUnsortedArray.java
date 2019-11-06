package Array;

import java.util.Stack;

public class FindUnsortedArray {

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(FindUnsortedArray.findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int left = len - 1;
        int right = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }
        return left < right ? right - left + 1 : 0;
    }

    public static int findUnsortedSubarray_LogNApproach(int[] nums) {
        int len = nums.length;
        int left = len - 1;
        int right = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }
        return left < right ? right - left + 1 : 0;

    }

}
