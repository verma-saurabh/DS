package Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LenLongestFibSubseq {

    public static void main(String[] args) {
        int[] A = {1, 3, 7, 11, 12, 14, 18};
        LenLongestFibSubseq obj = new LenLongestFibSubseq();
        System.out.println(obj.lenLongestFibSubseq(A));
    }

    public int lenLongestFibSubseq(int[] A) {

        int ans = 0;
        Set<Integer> S = new HashSet<>();
        for (int a : A) {
            S.add(a);
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int x = A[j];
                int y = A[j] + A[i];
                int length = 2;
                while (S.contains(y)) {
                    int temp = y;
                    y = y + x;
                    x = temp;
                    ans = Math.max(ans, ++length);
                }

            }

        }
        return ans >= 3 ? ans : 0;
    }
}
