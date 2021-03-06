package Array;

public class JumpGame_55 {
    public static void main(String[] args) {
        JumpGame_55 obj = new JumpGame_55();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(obj.canJump(nums));
    }

    public boolean canJump(int[] A) {
        if (A.length <= 1)
            return true;

        int max = A[0]; //max stands for the largest index that can be reached.

        for (int i = 0; i < A.length; i++) {
            //if not enough to go to next
            if (max <= i && A[i] == 0)
                return false;

            //update max
            if (i + A[i] > max) {
                max = i + A[i];
            }

            //max is enough to reach the end
            if (max >= A.length - 1)
                return true;
        }

        return false;
    }
}
