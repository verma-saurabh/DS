package Array;

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    public void backtrack(int[] candidates, int start, int target, List<Integer> list, List<List<Integer>> ans) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(list));
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], list, ans);
            list.remove(list.size() - 1);
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>> ans = new HashSet<>();
        Arrays.sort(candidates);
        backtrack2(candidates, 0, target, new ArrayList<>(), ans);
        return new ArrayList<>(ans);
    }

    public void backtrack2(int[] candidates, int start, int target, List<Integer> list, HashSet<List<Integer>> ans) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(list));
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrack2(candidates, i + 1, target - candidates[i], list, ans);
            list.remove(list.size() - 1);
        }

    }
}
