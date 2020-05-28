package Array;
/*
338. Counting Bits
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            int temp = i;
            int count = 0;
            while (temp != 0) {
                temp = temp & (temp - 1);
                count++;
            }
            ans[i] = count;

        }
        return ans;
    }
}
