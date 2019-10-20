package Array;

import java.util.ArrayList;
import java.util.List;

public class FindPowerSet {

    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};

        FindPowerSet obj = new FindPowerSet();
        obj.findPowerSet(nums);
    }

    public List<List<Integer>> findPowerSet(int[] nums) {


        List<Integer> arr = new ArrayList<Integer>();
        recursion(nums, 0, arr, nums.length);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
        return ans;

    }

    public void recursion(int[] nums, int index, List<Integer> arr, int length) {
        // ans.add(new ArrayList<Integer>(arr));
        //
        if (index == length) {
            ans.add(new ArrayList<Integer>(arr));
            return;

            //return;
        } else {
            recursion(nums, index + 1, arr, length);
            arr.add(nums[index]);
            recursion(nums, index + 1, arr, length);
            arr.remove(arr.size() - 1);
        }

    }
}
