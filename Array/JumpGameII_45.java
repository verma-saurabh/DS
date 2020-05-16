package Array;

/*
45. Jump Game II
 */
public class JumpGameII_45 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        JumpGameII_45 obj = new JumpGameII_45();
        System.out.println(obj.jump2(nums));
    }

    public int jump(int[] nums) {

        int[] jumps = new int[nums.length];
        //int[] result = new int[nums.length];
        jumps[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            jumps[i] = Integer.MAX_VALUE - 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (i <= nums[j] + j) {
                    if (jumps[i] > jumps[j] + 1) {
                        //result[i] = j;
                        jumps[i] = jumps[j] + 1;
                    }
                }

            }

        }
        return jumps[jumps.length - 1];
    }

    public int jump2(int[] nums) {
        int curStep = 0, level = 0;

        while (curStep < nums.length - 1) {
            level++;
            int preStep = curStep;
            for (int j = 0; j <= preStep; j++) {
                curStep = Math.max(curStep, j + nums[j]);
            }
        }
        return level;
    }
}
