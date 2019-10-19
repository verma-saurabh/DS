package Array;

import java.util.ArrayList;
import java.util.List;

public class FIndAllTheSubSets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};

        FIndAllTheSubSets obj = new FIndAllTheSubSets();
        obj.subsets(nums);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(res, nums, new ArrayList<Integer>(), 0);

        for (List l : res) {
            System.out.println(l);
        }

        return null;
    }

    public void dfs(List<List<Integer>> res, int[] nums, List<Integer> l, int start) {
        for (List list : res) {
            System.out.println(list);
        }
        res.add(new ArrayList<Integer>(l));

        for (int i = start; i < nums.length; i++) {
            l.add(nums[i]);
            dfs(res, nums, l, i + 1);
            l.remove(l.size() - 1);
        }


    }
}

