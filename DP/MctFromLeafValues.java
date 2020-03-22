package DP;

import java.util.Stack;

/*
 * https://www.cnblogs.com/Dylan-Java-NYC/p/11457644.html
 * */
public class MctFromLeafValues {
    public static int mctFromLeafValues(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int res = 0;
        Stack<Integer> stk = new Stack<>();
        stk.push(Integer.MAX_VALUE);
        for (int num : arr) {
            while (stk.peek() <= num) {
                int mid = stk.pop();
                res += mid * Math.min(stk.peek(), num);
            }

            stk.push(num);
        }

        while (stk.size() > 2) {
            res += stk.pop() * stk.peek();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {15, 13, 5, 3, 15};
        System.out.println(mctFromLeafValues(arr));
    }
}
