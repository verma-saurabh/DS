package SortingAlgorithms;

import java.util.Arrays;

public class InsertionSortWithBinarySearch {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        sort(nums);

    }

    public static int[] sort(int[] nums) {
        int j, key;
        for (int i = 1; i < nums.length; i++) {
            j = i - 1;
            key = nums[i];
            int loc = binarySearch(nums, 0, i, key);
            while (j >= loc) {
                nums[j+1] = nums[j ];
                j--;
            }
            nums[j + 1] = key;
        }
        Arrays.stream(nums).forEach(System.out::println);
        return nums;
    }

    public static int binarySearch(int[] nums, int low, int high, int key) {
        if (high <= low) {
            return key > nums[low] ? low + 1 : low;
        }

        int mid = (low + high) / 2;
        if (nums[mid] == key) {
            return mid + 1;
        }
        if (key > nums[mid]) {
            return binarySearch(nums, mid + 1, high, key);
        } else {
            return binarySearch(nums, low, mid - 1, key);
        }
    }
}
