package Array;

public class MaximumSumCircularSubarray {
    public static void main(String[] args) {
        int[] A={1,-2,3,-2};
        MaximumSumCircularSubarray obj= new MaximumSumCircularSubarray();
        System.out.println(obj.maxSubarraySumCircular(A));
    }

    public int maxSubarraySumCircular(int[] A) {
        if (A.length == 1) return A[0];

        int sum = 0;
        for (int num : A) sum += num;

        int ans1 = A[0], currentSum = 0;
        for (int num : A) {
            currentSum = num + Math.max(currentSum, 0);
            ans1 = Math.max(ans1, currentSum);
        }

        int ans2 = A[0];
        currentSum = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; i++) {
            currentSum = A[i] + Math.min(currentSum, 0);
            ans2 = Math.min(ans2, currentSum);
        }
        ans2 = sum - ans2;

        return Math.max(ans1, ans2);

    }
}
