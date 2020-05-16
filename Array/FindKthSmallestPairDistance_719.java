package Array;

import java.util.*;

public class FindKthSmallestPairDistance_719 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,5,3,1};
        FindKthSmallestPairDistance_719 obj = new FindKthSmallestPairDistance_719();
        System.out.println(obj.smallestDistancePair(nums, 3));
    }

    public int smallestDistancePair(int[] nums, int k) {

        //Set<Integer> set = new HashSet<>();
        //List<Integer> list = new ArrayList<>(set);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                list.add(Math.abs(nums[i] - nums[j]));
            }
        }

        //List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        return list.get(k-1);
    }
}
