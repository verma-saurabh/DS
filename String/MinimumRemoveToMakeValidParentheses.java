package String;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
1249. Minimum Remove to Make Valid Parentheses
 */
public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {

        StringBuilder sb = new StringBuilder(s);
        int sum = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                sum++;
            } else if (sb.charAt(i) == ')') {
                sum--;
            }
            if (sum < 0) {
                sb.deleteCharAt(i);
                sum = 0;
                i--;
            }
        }
        int i = sb.length() - 1;
        while (sum > 0 && i >= 0) {
            if (sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
                sum--;
            }
            i--;
        }
        return sb.toString();
    }

}
