package Array;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/*
1365. How Many Numbers Are Smaller Than the Current Number
 */
public class SmallerThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];

        List<Integer> list = IntStream.of(nums).boxed().collect(Collectors.toList());

        Collections.sort(list);

        for (int i = 0; i < nums.length; i++) {
            ans[i] = list.indexOf(nums[i]);
        }

        return ans;
    }
}
